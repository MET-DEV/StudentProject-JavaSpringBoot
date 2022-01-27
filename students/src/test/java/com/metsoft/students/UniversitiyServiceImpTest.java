package com.metsoft.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.metsoft.students.models.University;
import com.metsoft.students.repository.UniversityRepository;
import com.metsoft.students.service.implementation.UniversityServiceImp;

@ExtendWith(MockitoExtension.class)
public class UniversitiyServiceImpTest {
	
	@InjectMocks
	private UniversityServiceImp universityService;
	@Mock
	private UniversityRepository universityRepository;
	
	@Test
	public void TestAdd() {
		University university=new University();
		university.setUniversityName("TEST-UNI");
		University uniMock=Mockito.mock(University.class);
		Mockito.when(uniMock.getId()).thenReturn(1);
		Mockito.when(uniMock.getUniversityName()).thenReturn("TEST-UNI");
		Mockito.when(universityRepository.save(ArgumentMatchers.any(University.class))).thenReturn(uniMock);
		University uniData=universityService.add(university).getData();
		Assertions.assertEquals(uniData.getId(), 1);
		Assertions.assertEquals(university.getUniversityName(), uniData.getUniversityName());
		
		
	}
}
