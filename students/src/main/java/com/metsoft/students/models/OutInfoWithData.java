package com.metsoft.students.models;


import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class OutInfoWithData<T> {
	private String message;
	private boolean status;
	private T data;
	
	
}
