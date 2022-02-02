package com.metsoft.students.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import com.metsoft.students.models.University;
import com.metsoft.students.models.servicemodel.OutInfoWithData;
import com.metsoft.students.service.interfaces.UniversityService;


@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {
	private UniversityService universityService;

	@Autowired
	public UniversitiesController(UniversityService universityService) {
		super();
		this.universityService = universityService;
	}
	@GetMapping("/getall")
	public OutInfoWithData<List<University>> getAll(){
		return universityService.getAll();
	}
	@GetMapping("/getbyid/{id}")
	public OutInfoWithData<University> getById(@PathVariable int id){
		return universityService.getById(id);
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody University university){
		return ResponseEntity.ok(universityService.add(university));
	}
	@PatchMapping("/update")
	public OutInfoWithData<University> update(@RequestBody University university){
		return universityService.update(university);
	}
	@DeleteMapping("/delete")
	public OutInfoWithData<University> delete(@RequestBody University university){
		return universityService.delete(university);
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
