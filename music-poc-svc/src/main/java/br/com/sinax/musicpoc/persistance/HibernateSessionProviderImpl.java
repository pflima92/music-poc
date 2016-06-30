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
package br.com.sinax.musicpoc.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * The Class HibernateSessionProviderImpl.
 *
 * @author pflima
 * @since 29/06/2016
 */
public class HibernateSessionProviderImpl implements SessionProvider<Session> {

	/** The session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Instantiates a new hibernate session provider impl.
	 *
	 * @param sessionFactory
	 *            the session factory
	 */
	public HibernateSessionProviderImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see br.com.sinax.musicpoc.persistance.SessionProvider#provide()
	 */
	@Override
	public Session provide() {

		return sessionFactory.openSession();
	}
}
