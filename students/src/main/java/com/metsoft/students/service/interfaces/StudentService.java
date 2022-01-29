package com.metsoft.students.service.interfaces;

import java.util.List;

import com.metsoft.students.models.Student;
import com.metsoft.students.models.servicemodel.OutInfo;
import com.metsoft.students.models.servicemodel.OutInfoWithData;

public interface StudentService {

	OutInfoWithData<List<Student>> getStudents();
	OutInfoWithData<Student> getById(int id);
	OutInfoWithData<Student>  add(Student student);
	OutInfo update(Student student);
	OutInfo delete(Student student);
	
	
}
