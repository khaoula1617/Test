package com.kmv.crudFilms.services.impl;


import com.kmv.crudFilms.controllers.dto.FilmDto;
import com.kmv.crudFilms.entites.FilmEntity;
import com.kmv.crudFilms.repository.IFilmRepository;
import com.kmv.crudFilms.services.IFilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class FilmService implements IFilmService {

	private static Logger logger = LoggerFactory.getLogger(FilmService.class);

	@Autowired
	IFilmRepository filmRepository;

	@Override
	public FilmDto saveFilm(FilmDto filmDto) {
		// save film in json file
		FilmEntity filmEntity = FilmDto.dtoToEntity(filmDto);
		FilmDto result = FilmDto.entityToDto(filmRepository.save(filmEntity));
		logger.info("save film  ", filmDto, new Date(), null);
		return result;
	}

	@Override
	public FilmDto getFilmById(Long id) {
		FilmEntity filmEntity = filmRepository.getById(id);
		FilmDto result =  FilmDto.entityToDto(filmEntity);
		logger.info("get film by id ", id, new Date(), null);
		return result;
	}

	@Override
	public Map<String, Long> getFilmByName(String name) {
		List<FilmEntity> filmEntities = filmRepository.findByTitleLike(name);
		List<FilmDto> filmDtos = FilmDto.entitiesToDtos(filmEntities);
		Map<String, Long> totalParGenre = filmDtos.stream()
				.collect(Collectors.groupingBy(FilmDto::getGenre, Collectors.counting()));
		return totalParGenre;
	}

}
