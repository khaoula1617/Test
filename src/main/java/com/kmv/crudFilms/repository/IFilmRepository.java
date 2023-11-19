package com.kmv.crudFilms.repository;


import com.kmv.crudFilms.entites.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IFilmRepository extends JpaRepository<FilmEntity, Long> {

   @Query("SELECT f FROM FilmEntity f WHERE LOWER(f.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<FilmEntity> findByTitleLike(String keyword);


}
