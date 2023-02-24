package com.masai.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(indexName = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	private Integer rollNumber;
	private String name;
	private List<Semester> semesters;

}
