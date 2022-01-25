package com.metsoft.students;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.metsoft.students.models.Student;
import com.metsoft.students.models.University;
import com.metsoft.students.repository.StudentRepository;
import com.metsoft.students.service.implementation.StudentServiceImp;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImpTest {
	
	@InjectMocks
	private StudentServiceImp studentService;
	@Mock
	private StudentRepository studentRepository;
	
	@Test
	public void testAdd() {

		Student student=new Student();
		University uni = new University();
		student.setFirstName("Test-FirstName");
		student.setGPA(3.5);
		student.setLastName("Test-LastName");
		student.setUniversity(uni);
		Student studentMock=Mockito.mock(Student.class);
		Mockito.when(studentMock.getFirstName()).thenReturn("Test-FirstName");
		Mockito.when(studentMock.getId()).thenReturn(1);
		Mockito.when(studentRepository.save(ArgumentMatchers.any(Student.class))).thenReturn(studentMock);
		Student studentData=studentService.add(student).getData();
		Assertions.assertEquals(studentData.getFirstName(), student.getFirstName());
		Assertions.assertEquals(studentData.getId(), 1);
		
	}
}
