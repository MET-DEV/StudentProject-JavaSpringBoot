package com.metsoft.students.service.interfaces;

import java.util.List;

import com.metsoft.students.models.Attendant;
import com.metsoft.students.models.servicemodel.OutInfo;
import com.metsoft.students.models.servicemodel.OutInfoWithData;

public interface AttendantService {
	OutInfoWithData<List<Attendant>> getAll();
	OutInfoWithData<Attendant> getById(int id);
	OutInfoWithData<Attendant> add(Attendant attendant);
	OutInfoWithData<Attendant> update(Attendant attendant);
	OutInfo delete(Attendant attendant);
}
