package org.springbootrest.crud.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

	@Getter
	@Setter
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Getter
	@Setter
	@Column(name = "NAME")
	private String name;

	@Getter
	@Setter
	@Column(name = "PASSPORT_NUMBER")
	private String passportNumber;
}