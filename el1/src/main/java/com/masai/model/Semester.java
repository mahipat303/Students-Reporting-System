package com.masai.model;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(indexName = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Semester {

	private Integer sem;
	private Integer Science;
	private Integer English;
	private Integer Maths;

	public Semester(Integer sem) {
		super();
		this.sem = sem;
	}

}
