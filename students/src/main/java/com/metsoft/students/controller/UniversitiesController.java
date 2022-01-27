package com.metsoft.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metsoft.students.models.OutInfoWithData;
import com.metsoft.students.models.University;
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
	@PostMapping("/add")
	public OutInfoWithData<University> add(@RequestBody University university){
		return universityService.add(university);
	}
	@PatchMapping("/update")
	public OutInfoWithData<University> update(@RequestBody University university){
		return universityService.update(university);
	}
	@DeleteMapping("/delete")
	public OutInfoWithData<University> delete(@RequestBody University university){
		return universityService.delete(university);
	}
}
