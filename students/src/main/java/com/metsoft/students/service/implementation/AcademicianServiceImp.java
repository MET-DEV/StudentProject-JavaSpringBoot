package com.metsoft.students.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metsoft.students.models.Academician;
import com.metsoft.students.models.servicemodel.OutInfoWithData;
import com.metsoft.students.repository.AcademicianRepository;
import com.metsoft.students.service.interfaces.AcademicianService;

@Service
public class AcademicianServiceImp implements AcademicianService{
	private AcademicianRepository academicianRepo;
	
	@Autowired
	public AcademicianServiceImp(AcademicianRepository academicianRepo) {
		super();
		this.academicianRepo = academicianRepo;
	}

	@Override
	public OutInfoWithData<List<Academician>> getAll() {
		List<Academician> academicians=academicianRepo.findAll();
		return new OutInfoWithData<List<Academician>>("Data listed", true, academicians);
	}
	@Override
	public OutInfoWithData<Academician> getById(int id) {
		Academician academician =academicianRepo.findById(id);
		return new OutInfoWithData<Academician>("Data listed", true, academician);
	}

	@Override
	public OutInfoWithData<Academician> add(Academician academician) {
		Academician academicianDb=academicianRepo.save(academician);
		return new OutInfoWithData<Academician>("Data added", true, academicianDb);
	}

	@Override
	public OutInfoWithData<Academician> update(Academician academician) {
		Academician academicianDb=academicianRepo.save(academician);
		return new OutInfoWithData<Academician>("Data added", true, academicianDb);
	}

	@Override
	public OutInfoWithData<Academician> delete(Academician academician) {
		academicianRepo.delete(academician);
		return new OutInfoWithData<Academician>("Data added", true, academician);
		
	}

	

}
