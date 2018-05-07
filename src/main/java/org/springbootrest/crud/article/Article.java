package org.springbootrest.crud.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Article {

	@Getter
	@Setter
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Getter
	@Setter
	@Column(name = "TITLE")
	private String title;

	@Getter
	@Setter
	@Column(name = "CATEGORY")
	private String category;
}