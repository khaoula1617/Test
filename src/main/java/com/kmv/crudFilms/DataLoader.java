package com.kmv.crudFilms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.kmv.crudFilms.controllers.dto.FilmMessageDTO;
import com.kmv.crudFilms.entites.FilmEntity;
import com.kmv.crudFilms.repository.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;


@Component
public class DataLoader {


	private IFilmRepository filmRepository;

	ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    public DataLoader(IFilmRepository filmRepository) {
		this.filmRepository = filmRepository;
		LoadFilms();

    }
	private void LoadFilms(){
		try {
			FilmMessageDTO filmMessage =  new FilmMessageDTO();
			ClassPathResource resource = new ClassPathResource("/film.json");

			FilmMessageDTO objectList =  objectMapper.readValue(resource.getInputStream(), new TypeReference<FilmMessageDTO>() {});
			List<FilmEntity> filmEntity = new ArrayList<>();
			objectList.getFilms().forEach(filmDto ->
				filmRepository.save(new FilmEntity(null,filmDto.getTitle(),filmDto.getYear(),filmDto.getType(),filmDto.getGenre()))
			);
		}catch (
		IOException exception){
			System.out.println("ERROR exception ."+ exception);
		}
	}

}
