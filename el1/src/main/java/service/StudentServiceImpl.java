package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.Semester;
import com.masai.model.Student;
import com.masai.repository.StudentRepo;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo s_repo;

	@Override
	public Student registerStudent(String name) {
		int random_int = (int) Math.floor(Math.random() * (Integer.MAX_VALUE - 1 + 1) + 1);

		Semester first_sem = new Semester(1);
		Semester second_sem = new Semester(2);

		List<Semester> semList = new ArrayList<>();
		semList.add(first_sem);
		semList.add(second_sem);

		Student student = new Student(random_int, name, semList);

		s_repo.save(student);

		return student;
	}

	@Override
	public List<Student> AllStudentsDetails() {

		Iterable<Student> students = s_repo.findAll();

		List<Student> studentList = new ArrayList<>();

		for (Student s : students) {
			studentList.add(s);
		}

		return studentList;
	}

	@Override
	public String fillStudentMarks(Integer roll, Integer sem, String subject, Integer marks) {

		if (sem > 2 || sem < 1)
			return "please enter semester 1 or 2";

		Optional<Student> students = s_repo.findById(roll);

		if (students.isEmpty()) {
			return "enter valid rollNumber";
		} else {

			Student student = students.get();

			for (Semester semester : student.getSemesters()) {

				int semNo = semester.getSem();

				if (semNo == sem) {
					if (subject.equals("English")) {
						semester.setEnglish(marks);
					} else if (subject.equals("Science")) {
						semester.setScience(marks);
					} else if (subject.equals("Maths")) {
						semester.setMaths(marks);
					} else {
						return "please enter valid subject";
					}
				}
			}

			s_repo.save(student);
		}

		return "Marks added succesfully";
	}

	@Override
	public Double findAverageBySem(int sem) {

		Double averageMarks = 0.0;

		Iterable<Student> studentList = s_repo.findAll();
		int size = 0;

		for (Student stud : studentList) {
			Semester semester = stud.getSemesters().get(sem - 1);
			Double percentage = (double) (semester.getEnglish() + semester.getMaths() + semester.getScience()) / 3;
			size++;
			averageMarks += percentage;
		}

		return averageMarks / size;

	}

}
