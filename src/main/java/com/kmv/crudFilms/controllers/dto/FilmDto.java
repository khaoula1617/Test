package com.kmv.crudFilms.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.kmv.crudFilms.entites.FilmEntity;
import com.kmv.crudFilms.utils.Functions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto  {

	 @JsonProperty("Title")
	 String Title;

	@JsonProperty("Year")
	 String Year;

	@JsonProperty("Genre")
	 String Genre;

	@JsonProperty("Type")
	 String Type;



    public static FilmDto entityToDto(FilmEntity entity){
		FilmDto dto = null;
		if(entity != null){
			dto = new FilmDto();
        	dto.setGenre(entity.getGenre());
        	dto.setTitle(entity.getTitle());
        	dto.setType(entity.getType());
        	dto.setYear(entity.getYear());
		}
		return  dto;
    }

    public static FilmEntity dtoToEntity(FilmDto dto){
		FilmEntity entity = null;
		if(dto != null){
			entity = new FilmEntity();
        	entity.setGenre(dto.getGenre()); ;
        	entity.setTitle(dto.getTitle());
        	entity.setType(dto.getType());
        	entity.setYear(dto.getYear());
		}
		
		return  entity;
    }

    public static List<FilmDto> entitiesToDtos(List<FilmEntity> listEntity){
		List<FilmDto> list = new ArrayList<>();
		if(Functions.isNotEmpty(listEntity)){
        	for(FilmEntity entity:listEntity){
    			list.add(entityToDto(entity));
    		}
		}
        return list;
    }
}
