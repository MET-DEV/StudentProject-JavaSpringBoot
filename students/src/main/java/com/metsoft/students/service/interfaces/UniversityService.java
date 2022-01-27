package com.metsoft.students.service.interfaces;

import java.util.List;

import com.metsoft.students.models.OutInfoWithData;
import com.metsoft.students.models.University;

public interface UniversityService {
	OutInfoWithData<List<University>> getAll();
	OutInfoWithData<University> add(University university);
	OutInfoWithData<University> update(University university);
	OutInfoWithData<University> delete(University university);
}
