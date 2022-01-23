package com.metsoft.students.service.interfaces;

import java.util.List;

import com.metsoft.students.models.OutInfo;
import com.metsoft.students.models.OutInfoWithData;
import com.metsoft.students.models.Student;

public interface StudentService {

	OutInfoWithData<List<Student>> getStudents();
	OutInfo add(Student student);
	OutInfo update(Student student);
	OutInfo delete(Student student);
	
	
}
