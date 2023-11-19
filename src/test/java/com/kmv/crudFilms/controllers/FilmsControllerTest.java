package com.kmv.crudFilms.controllers;

import com.kmv.crudFilms.controllers.dto.FilmDto;
import com.kmv.crudFilms.services.impl.FilmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class FilmsControllerTest {



    @Mock
    private FilmService filmService;

    @Test
    void addFilm() {

    }

    @Test
    void getFilmById() throws Exception {
        // Mock the behavior of filmService.getFilmById
        /* TODO correction mock
         Long filmId = 1L;
        FilmDto filmDto = new FilmDto("test","test","test","tst");
        when(filmService.getFilmById(filmId)).thenReturn(filmDto);


        // Verify that filmService.getFilmById was called with the correct argument
        verify(filmService, times(1)).getFilmById(filmId);*/
    }

    @Test
    void getFilmByName() {
    }
}