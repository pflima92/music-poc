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
package br.com.sinax.musicpoc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.jspare.core.container.Inject;

import br.com.sinax.musicpoc.entity.Music;
import br.com.sinax.musicpoc.persistance.SessionProvider;

/**
 * The Class MusicDaoImpl.
 *
 * @author pflima
 * @since 29/06/2016
 */
public class MusicDaoImpl implements Dao<Music> {

	/** The session provider. */
	@Inject
	private SessionProvider<Session> sessionProvider;

	/* (non-Javadoc)
	 * @see br.com.sinax.musicpoc.persistance.Dao#list()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Music> list() {

		Session session = sessionProvider.provide();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Music.class);
		List<Music> result = criteria.list();

		session.getTransaction().commit();
		if (session.isOpen()) {

			session.close();
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see br.com.sinax.musicpoc.persistance.Dao#persist(java.lang.Object)
	 */
	@Override
	public Music persist(Music entity) {

		Session session = sessionProvider.provide();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		if (session.isOpen()) {

			session.close();
		}
		return entity;
	}

	/* (non-Javadoc)
	 * @see br.com.sinax.musicpoc.persistance.Dao#remove(java.lang.Object)
	 */
	@Override
	public void remove(Music entity) {

		Session session = sessionProvider.provide();
		session.beginTransaction();

		session.delete(entity);

		session.getTransaction().commit();
		if (session.isOpen()) {

			session.close();
		}
	}

}
