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
package br.com.sinax.musicpoc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Music.
 *
 * @author pflima
 * @since 29/06/2016
 */
@Entity
@Table
public class Music {

	/** The id. */
	@Id
	@GeneratedValue
	private int id;

	/** The name. */
	private String name;

	/** The band. */
	private String band;

	/** The duration. */
	private String duration;

	/**
	 * Gets the band.
	 *
	 * @return the band
	 */
	public String getBand() {
		return band;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the band.
	 *
	 * @param band
	 *            the new band
	 */
	public void setBand(String band) {
		this.band = band;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration
	 *            the new duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
