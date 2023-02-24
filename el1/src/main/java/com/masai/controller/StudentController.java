package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.masai.model.Student;
import com.masai.repository.StudentRepo;

import service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService student_service;

	@PostMapping("/students/{name}")
	public Student registerStudentHandler(@PathVariable("name") String name) {

		return student_service.registerStudent(name);

	}

	@GetMapping("/students")
	public List<Student> AllStudentsDetailsHandler() {

		List<Student> students = student_service.AllStudentsDetails();

		return students;

	}

	@GetMapping("/students/{sem}")
	public ModelAndView findAverageBySem(@PathVariable("sem") int sem) {

		double average = student_service.findAverageBySem(sem);
		ModelAndView model = new ModelAndView("home");
		model.addObject("message", average);
		System.out.println("Home Section");
		return model;

	}

}
