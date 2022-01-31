package com.metsoft.students.service.interfaces;

import java.util.List;

import com.metsoft.students.models.Academician;
import com.metsoft.students.models.servicemodel.OutInfoWithData;

public interface AcademicianService {
	OutInfoWithData<List<Academician>> getAll();
	OutInfoWithData<Academician> getById(int id);
	OutInfoWithData<Academician> add(Academician academician);
	OutInfoWithData<Academician> update(Academician academician);
	OutInfoWithData<Academician> delete(Academician academician);
}
