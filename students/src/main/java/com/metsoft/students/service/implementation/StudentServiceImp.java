package com.metsoft.students.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metsoft.students.models.Student;
import com.metsoft.students.models.servicemodel.OutInfo;
import com.metsoft.students.models.servicemodel.OutInfoWithData;
import com.metsoft.students.repository.StudentRepository;
import com.metsoft.students.service.interfaces.StudentService;

@Service
public class StudentServiceImp implements StudentService{
	private StudentRepository studentRepo;
	@Autowired
	public StudentServiceImp(StudentRepository studentRepo) {
		this.studentRepo=studentRepo;
	}
	@Override
	public OutInfoWithData<List<Student>> getStudents() {
		List<Student> students=studentRepo.findAll();
		return new OutInfoWithData<List<Student>>("Data listed for you <3", true, students);
	}
	@Override
	public OutInfoWithData<Student> add(Student student) {
		Student studentDb=studentRepo.save(student);
		return new OutInfoWithData<Student>("Data added",true,studentDb);
	}
	@Override
	public OutInfo update(Student student) {
		studentRepo.save(student);
		return new OutInfo("Data updated",true);
	}
	@Override
	public OutInfo delete(Student student) {
		studentRepo.delete(student);
		return new OutInfo("Data deleted",true);
	}
	@Override
	public OutInfoWithData<Student> getById(int id) {
		Student student=studentRepo.findById(id);
		return new OutInfoWithData<Student>("Veri getirildi", true, student);
	}
	
}
