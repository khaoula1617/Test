package com.kmv.crudFilms.services;

import com.kmv.crudFilms.controllers.dto.FilmDto;

import java.util.Map;



public interface IFilmService {

	FilmDto saveFilm(FilmDto filmDto);

	FilmDto getFilmById(Long id);

	Map<String, Long> getFilmByName(String name);

}
