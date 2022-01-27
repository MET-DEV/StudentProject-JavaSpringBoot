package com.metsoft.students.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metsoft.students.models.OutInfoWithData;
import com.metsoft.students.models.University;
import com.metsoft.students.repository.UniversityRepository;
import com.metsoft.students.service.interfaces.UniversityService;

@Service
public class UniversityServiceImp implements UniversityService{
	private UniversityRepository universityRepository;
	@Autowired
	public UniversityServiceImp(UniversityRepository universityRepository) {
		super();
		this.universityRepository = universityRepository;
	}
	@Override
	public OutInfoWithData<List<University>> getAll() {
		List<University> data=universityRepository.findAll();
		return new OutInfoWithData<List<University>>("Data listed for you <3", true, data);
	}
	@Override
	public OutInfoWithData<University> add(University university) {
		University uniDb=universityRepository.save(university);
		return new OutInfoWithData<University>("Ekleme başarılı", true, uniDb);
	}
	@Override
	public OutInfoWithData<University> update(University university) {
		University universityDb=universityRepository.save(university);
		return new OutInfoWithData<University>("Başarıyla Güncellendi", true, universityDb);
	}
	@Override
	public OutInfoWithData<University> delete(University university) {
		universityRepository.delete(university);
		return new OutInfoWithData<University>("Başarıyla Silindi", true, university);
	}

	

}
