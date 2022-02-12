package com.metsoft.students.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metsoft.students.models.Attendant;
import com.metsoft.students.models.servicemodel.OutInfo;
import com.metsoft.students.models.servicemodel.OutInfoWithData;
import com.metsoft.students.repository.AttendantRepository;
import com.metsoft.students.service.interfaces.AttendantService;

@Service
public class AttendantServiceImp implements AttendantService{

	private AttendantRepository attendantRepository;
	@Autowired
	public AttendantServiceImp(AttendantRepository attendantRepository) {
		super();
		this.attendantRepository = attendantRepository;
	}
	@Override
	public OutInfoWithData<List<Attendant>> getAll() {
		
		return new OutInfoWithData<List<Attendant>>("Listed", true, attendantRepository.findAll());
	}
	@Override
	public OutInfoWithData<Attendant> getById(int id) {
		
		return new OutInfoWithData<Attendant>("Listed", true, attendantRepository.getById(id));
	}
	@Override
	public OutInfoWithData<Attendant> add(Attendant attendant) {
		return new OutInfoWithData<Attendant>("added", true, attendantRepository.save(attendant));
	}
	@Override
	public OutInfoWithData<Attendant> update(Attendant attendant) {
		// TODO Auto-generated method stub
		return new OutInfoWithData<Attendant>("added", true, attendantRepository.save(attendant));
	}
	@Override
	public OutInfo delete(Attendant attendant) {
		attendantRepository.delete(attendant);
		return new OutInfo("deleted", true);
	}
	
}
