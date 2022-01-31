package com.metsoft.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public OutInfoWithData<Academician> add(@RequestBody Academician academician){
		return academicianService.add(academician);
	}
	@PatchMapping("/update")
	public OutInfoWithData<Academician> update(@RequestBody Academician academician){
		return academicianService.update(academician);
	}
	@DeleteMapping("/delete")
	public OutInfoWithData<Academician> delete(@RequestBody Academician academician) {
		return academicianService.delete(academician);
	}

}
