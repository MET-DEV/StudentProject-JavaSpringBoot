package com.metsoft.students.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="academicians")
public class Academician {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@NotBlank(message = "Ad alanı boş bırakılamaz")
	@Column(name="first_name")
	private String firstName;
	@NotBlank(message = "Soyad alanı boş bırakılamaz")
	@Column(name="last_name")
	private String lastName;
	@NotBlank(message = "Kimlik numarası boş bırakılamaz")
	@Column(name="nationality_number")
	private String nationalityNumber;
	@NotBlank(message = "Akademik statü alanı boş bırakılamaz")
	@Column(name="academic_status")
	private String academicStatus;
	@NotBlank(message = "Mail alanı boş bırakılamaz")
	@Column(name="email")
	private String email;
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;

}
