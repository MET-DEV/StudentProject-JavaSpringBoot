package com.metsoft.students.service.interfaces;

import java.util.List;

import com.metsoft.students.models.OutInfoWithData;
import com.metsoft.students.models.University;

public interface UniversityService {
	OutInfoWithData<List<University>> getAll();
}
