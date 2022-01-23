package com.metsoft.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metsoft.students.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
