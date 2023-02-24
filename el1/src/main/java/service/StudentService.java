package service;

import java.util.List;

import com.masai.model.Student;

public interface StudentService {

	public Student registerStudent(String name);

	public List<Student> AllStudentsDetails();
	
	public String fillStudentMarks(Integer roll, Integer sem, String subject, Integer marks);
	
	public Double findAverageBySem(int sem);

}
