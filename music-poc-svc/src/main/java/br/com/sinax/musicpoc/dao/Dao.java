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

import org.jspare.core.container.Component;

/**
 * The Interface Dao.
 *
 * @author pflima
 * @param <T>
 *            the generic type
 * @since 29/06/2016
 */
@Component
public interface Dao<T> {

	/**
	 * List.
	 *
	 * @return the list
	 */
	List<T> list();

	/**
	 * Persist.
	 *
	 * @param entity
	 *            the entity
	 * @return the t
	 */
	T persist(T entity);

	/**
	 * Removes the.
	 *
	 * @param entity
	 *            the entity
	 */
	void remove(T entity);
}
