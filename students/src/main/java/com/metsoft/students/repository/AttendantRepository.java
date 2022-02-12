package com.metsoft.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metsoft.students.models.Attendant;

public interface AttendantRepository extends JpaRepository<Attendant, Integer>{

}
