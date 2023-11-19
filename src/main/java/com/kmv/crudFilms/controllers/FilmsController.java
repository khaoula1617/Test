package com.kmv.crudFilms.controllers;

import com.kmv.crudFilms.controllers.dto.FilmDto;
import com.kmv.crudFilms.enums.RsMethodEnum;
import com.kmv.crudFilms.services.IFilmService;
import com.kmv.crudFilms.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/film/v0")
public class FilmsController {
	
	private static Logger logger = LoggerFactory.getLogger(FilmsController.class);
	
	@Autowired
	private ServerProperties serverProperties;

	@Autowired
	private IFilmService filmService;

	@PostMapping(value = "", headers = Constants.HEADERS)
	public ResponseEntity<FilmDto> addFilm(@RequestBody FilmDto filmDto) {
		if (logger.isInfoEnabled()) {
			logger.info( null ,serverProperties.getPort(), "save film", null,
			RsMethodEnum.POST.getValue(), "/film/v0", null);
		}
		/* add film */
		return new ResponseEntity<>(filmService.saveFilm(filmDto), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", headers = Constants.HEADERS)
	public ResponseEntity<FilmDto>  getFilmById(@PathVariable Long id) {
		if (logger.isInfoEnabled()) {
			logger.info( null ,serverProperties.getPort(), "get film by id", null,
					RsMethodEnum.GET.getValue(), "/film/v0", "id:"+id);
		}
		/* return film by id */
		return new ResponseEntity<>(filmService.getFilmById(id), HttpStatus.OK);
	}


	@GetMapping(value = "", headers = Constants.HEADERS)
	public ResponseEntity<Map<String,Long>>  getFilmByName(@RequestParam(name = "name") String name) {
		if (logger.isInfoEnabled()) {
			logger.info( null ,serverProperties.getPort(), "get film by name", null,
					RsMethodEnum.GET.getValue(), "/film/v0", "id:"+name);
		}
		return new ResponseEntity<>(filmService.getFilmByName(name), HttpStatus.OK);
	}


}
