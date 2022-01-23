package com.metsoft.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metsoft.students.models.University;

public interface UniversityRepository extends JpaRepository<University, Integer> {

}
