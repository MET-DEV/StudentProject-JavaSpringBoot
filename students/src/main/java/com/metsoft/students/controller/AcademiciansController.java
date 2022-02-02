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

import com.metsoft.students.models.Academician;
import com.metsoft.students.models.servicemodel.OutInfoWithData;
import com.metsoft.students.service.interfaces.AcademicianService;

@RestController
@RequestMapping("/api/academicians")
public class AcademiciansController {
	
	private AcademicianService academicianService;
	
	@Autowired
	public AcademiciansController(AcademicianService academicianService) {
		super();
		this.academicianService = academicianService;
	}
	@GetMapping("/getall")
	public OutInfoWithData<List<Academician>> getAll(){
		return academicianService.getAll();
	}
	@GetMapping("/getbyid/{id}")
	public OutInfoWithData<Academician> getById(@PathVariable int id){
		return academicianService.getById(id);
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Academician academician){
		return ResponseEntity.ok(academicianService.add(academician));
	}
	@PatchMapping("/update")
	public OutInfoWithData<Academician> update(@RequestBody Academician academician){
		return academicianService.update(academician);
	}
	@DeleteMapping("/delete")
	public OutInfoWithData<Academician> delete(@RequestBody Academician academician) {
		return academicianService.delete(academician);
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
