package com.metsoft.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metsoft.students.models.OutInfo;
import com.metsoft.students.models.OutInfoWithData;
import com.metsoft.students.models.Student;
import com.metsoft.students.service.interfaces.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
	private StudentService studentService;
	@Autowired
	public StudentsController(StudentService studentService) {
		this.studentService = studentService;
	}
	//TEST COMMIT
	@GetMapping("/getall")
	public OutInfoWithData<List<Student>> getAll(){
		return studentService.getStudents();
	}
	@PostMapping("/add")
	public OutInfoWithData<Student>  add(@RequestBody Student student) {
		return studentService.add(student);
	}
	@PostMapping("/update")
	public OutInfo update(@RequestBody Student student) {
		return studentService.update(student);
	}
	@PostMapping("/delete")
	public OutInfo delete(@RequestBody Student student) {
		return studentService.delete(student);
	}
}
