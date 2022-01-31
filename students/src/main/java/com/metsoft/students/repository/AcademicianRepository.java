package com.metsoft.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metsoft.students.models.Academician;

public interface AcademicianRepository extends JpaRepository<Academician, Integer> {
	Academician findById(int id);
}
