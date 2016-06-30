/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.sinax.musicpoc;

import static org.jspare.core.container.Environment.registryComponent;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.com.sinax.musicpoc.controller.MusicController;
import br.com.sinax.musicpoc.dao.MusicDaoImpl;
import br.com.sinax.musicpoc.entity.Music;
import br.com.sinax.musicpoc.persistance.HibernateSessionProviderImpl;

/**
 * The Class Bootstrap.
 *
 * @author pflima
 * @since 29/06/2016
 */
public class Bootstrap {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {

		new Bootstrap().run();
	}

	/** The jetty server. */
	private Server jettyServer;

	/**
	 * Builds the persistance.
	 */
	private void buildPersistance() {

		// Build Hibernate Configuration
		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(Music.class);
		configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test_mem;");
		configuration.setProperty("hibernate.connection.username", "");
		configuration.setProperty("hibernate.connection.password", "");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.connection.pool_size", "3");

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		// Registry on Container
		registryComponent(MusicDaoImpl.class);
		registryComponent(new HibernateSessionProviderImpl(sessionFactory));
	}

	/**
	 * Builds the server.
	 */
	private void buildServer() {

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		// CORS Filter
		FilterHolder cors = context.addFilter(CrossOriginFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
		cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
		cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,DELETE,HEAD");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");

		jettyServer = new Server(8080);
		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);
		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", MusicController.class.getCanonicalName());
	}

	/**
	 * Run.
	 *
	 * @throws Exception
	 *             the exception
	 */
	private void run() throws Exception {

		buildServer();
		buildPersistance();

		try {
			jettyServer.start();
			jettyServer.join();
		} finally {
			jettyServer.destroy();
		}
	}
}
