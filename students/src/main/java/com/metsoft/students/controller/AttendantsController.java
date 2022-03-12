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

import com.metsoft.students.models.Attendant;
import com.metsoft.students.models.servicemodel.OutInfo;
import com.metsoft.students.models.servicemodel.OutInfoWithData;
import com.metsoft.students.repository.AttendantRepository;
import com.metsoft.students.service.interfaces.AttendantService;

@RestController
@RequestMapping("/api/attendants")
public class AttendantsController {
	private AttendantService attendantService;

	
	@Autowired
	public AttendantsController(AttendantService attendantService,AttendantRepository repo) {
		super();
		this.attendantService = attendantService;

	}

	@GetMapping("/getall")
	public OutInfoWithData<List<Attendant>> getAll(){
		return attendantService.getAll();
	}
	@GetMapping("/getbyid/{id}")
	public OutInfoWithData<Attendant> getById(@PathVariable int id){
		return attendantService.getById(id);
	}
	@PostMapping("/add")
	public OutInfoWithData<Attendant> add(@RequestBody Attendant attendant){
		return attendantService.add(attendant);
	}
	@PatchMapping("/update")
	public OutInfoWithData<Attendant> update(@RequestBody Attendant attendant){
		return attendantService.update(attendant);
	}
	
	@DeleteMapping("/delete")
	public OutInfo delete(@RequestBody Attendant attendant){
		return attendantService.delete(attendant);
	}

}
