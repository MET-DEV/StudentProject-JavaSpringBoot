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
@Table(name = "students")
public class Student{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotBlank(message = "Ad alanı boş bırakılamaz")
	@Column(name = "firstname")
	private String firstName;
	@NotBlank(message = "Soyad alanı boş bırakılamaz")
	@Column(name = "lastname")
	private String lastName;
	@NotBlank(message = "Kimlik numarası alanı boş bırakılamaz")
	@Column(name = "nationalitynumber")
	private String nationalityNumber;
	@Column(name = "gpa")
	private double gPA;
	@NotBlank(message = "Telefon numarası alanı boş bırakılamaz")
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;
	
	

}
