package com.kmv.crudFilms.entites;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "film")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilmEntity implements Cloneable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title", nullable = false, length = 255)
	private String title;
	
	@Column(name = "year", nullable = false, length = 255)
	private String year;

	@Column(name = "type", nullable = false, length = 255)
	private String type;

	@Column(name = "genre", nullable = false, length = 255)
	private String genre;

}
