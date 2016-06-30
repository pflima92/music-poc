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
package br.com.sinax.musicpoc.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jspare.core.container.Inject;
import org.jspare.core.container.MySupport;

import br.com.sinax.musicpoc.dao.Dao;
import br.com.sinax.musicpoc.entity.Music;

/**
 * The Class MusicController.
 *
 * @author pflima
 * @since 29/06/2016
 */
@Path("api")
public class MusicController extends MySupport {

	/** The music dao. */
	@Inject
	private Dao<Music> musicDao;

	/**
	 * List.
	 *
	 * @return the list
	 */
	@GET
	@Path("musics")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Music> list() {

		List<Music> musics = musicDao.list();
		return musics;
	}

	/**
	 * Persist.
	 *
	 * @param music
	 *            the music
	 * @return the response
	 */
	@POST
	@Path("musics")
	public Response persist(Music music) {

		musicDao.persist(music);
		return Response.status(200).entity(music).build();
	}

	/**
	 * Removes the.
	 *
	 * @param music
	 *            the music
	 * @return the response
	 */
	@POST
	@Path("musics/delete")
	public Response remove(Music music) {

		musicDao.remove(music);
		return Response.status(200).entity(music).build();
	}
}