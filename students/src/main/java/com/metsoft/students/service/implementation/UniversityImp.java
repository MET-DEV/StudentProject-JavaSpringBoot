package com.metsoft.students.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metsoft.students.models.OutInfoWithData;
import com.metsoft.students.models.University;
import com.metsoft.students.repository.UniversityRepository;
import com.metsoft.students.service.interfaces.UniversityService;

@Service
public class UniversityImp implements UniversityService{
	private UniversityRepository universityRepository;
	@Autowired
	public UniversityImp(UniversityRepository universityRepository) {
		super();
		this.universityRepository = universityRepository;
	}
	@Override
	public OutInfoWithData<List<University>> getAll() {
		List<University> data=universityRepository.findAll();
		return new OutInfoWithData<List<University>>("Data listed for you <3", true, data);
	}

	

}
