package com.metsoft.students.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.metsoft.students.models.Student;
import com.metsoft.students.models.servicemodel.OutInfo;
import com.metsoft.students.models.servicemodel.OutInfoWithData;
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
	@GetMapping("/getbyid/{id}")
	public OutInfoWithData<Student> getById(@PathVariable int id){
		return studentService.getById(id);
	}
	@PostMapping("/add")
	public ResponseEntity<?>  add(@Valid @RequestBody Student student) {
		return ResponseEntity.ok(studentService.add(student));
	}
	@PatchMapping("/update")
	public OutInfo update(@RequestBody Student student) {
		return studentService.update(student);
	}
	@DeleteMapping("/delete")
	public OutInfo delete(@RequestBody Student student) {
		return studentService.delete(student);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public OutInfoWithData<Object> handleValidation(MethodArgumentNotValidException exceptions) {
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		OutInfoWithData<Object> errors=new OutInfoWithData<Object>("Veri formatında hata var", false, validationErrors);
		return errors;
	}
}
