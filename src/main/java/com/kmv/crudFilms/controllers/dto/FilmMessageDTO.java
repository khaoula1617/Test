package com.kmv.crudFilms.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Builder
@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class FilmMessageDTO {

    List<FilmDto> films;
    String total;
}
