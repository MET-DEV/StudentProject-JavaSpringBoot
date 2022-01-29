package com.metsoft.students.service.interfaces;

import java.util.List;

import com.metsoft.students.models.University;
import com.metsoft.students.models.servicemodel.OutInfoWithData;

public interface UniversityService {
	OutInfoWithData<List<University>> getAll();
	OutInfoWithData<University> getById(int id);
	OutInfoWithData<University> add(University university);
	OutInfoWithData<University> update(University university);
	OutInfoWithData<University> delete(University university);
	
}
