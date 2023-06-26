package org.jsp.bootcrud.service;

import java.util.List;

import org.jsp.bootcrud.dao.StudentDao;
import org.jsp.bootcrud.dto.Student;
import org.jsp.bootcrud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public ResponseStructure<Student> save(Student student) {
		int total = student.getPhysics() + student.getMathematics() + student.getComputerScience();
		student.setTotal(total);
		double percentage = total / 3.0;

		student.setPercetage(percentage);
		if (student.getPhysics() < 35 || student.getMathematics() < 35 || student.getComputerScience() < 35) {
			student.setResult("Fail");
		} else {
			if (percentage >= 85)
				student.setResult("Distinction");
			else if (percentage >= 60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}

		ResponseStructure<Student> structure = new ResponseStructure<>();
		structure.setMessage("Data Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.save(student));

		return structure;
	}

	public ResponseStructure<List<Student>> saveAll(List<Student> list) {
		for (Student student : list) {
			int total = student.getPhysics() + student.getMathematics() + student.getComputerScience();
			student.setTotal(total);
			double percentage = total / 3.0;
			student.setPercetage(percentage);
			if (student.getPhysics() < 35 || student.getMathematics() < 35 || student.getComputerScience() < 35) {
				student.setResult("Fail");
			} else {
				if (percentage >= 85)
					student.setResult("Distinction");
				else if (percentage >= 60)
					student.setResult("First Class");
				else
					student.setResult("Second Class");
			}
		}

		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		structure.setMessage("Data Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAll(list));

		return structure;
	}

	public ResponseStructure<List<Student>> fetchAll() {
		List<Student> list = dao.fetchAll();
		ResponseStructure<List<Student>> strucutre = new ResponseStructure<>();
		if (list.isEmpty()) {
			strucutre.setMessage("No Data Found");
			strucutre.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			strucutre.setMessage("Data Found");
			strucutre.setStatus(HttpStatus.FOUND.value());
			strucutre.setData(list);
		}
		return strucutre;
	}

	public ResponseStructure<Student> fetchById(int id) {
		Student student = dao.fetchById(id);
		ResponseStructure<Student> strucutre = new ResponseStructure<>();
		if (student == null) {
			strucutre.setMessage("No Data Found");
			strucutre.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			strucutre.setMessage("Data Found");
			strucutre.setStatus(HttpStatus.FOUND.value());
			strucutre.setData(student);
		}
		return strucutre;
	}

	public ResponseStructure<List<Student>> fetchByName(String name) {
		List<Student> list = dao.fetchByName(name);
		ResponseStructure<List<Student>> strucutre = new ResponseStructure<>();
		if (list.isEmpty()) {
			strucutre.setMessage("No Data Found");
			strucutre.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			strucutre.setMessage("Data Found");
			strucutre.setStatus(HttpStatus.FOUND.value());
			strucutre.setData(list);
		}
		return strucutre;
	}

	public ResponseStructure<List<Student>> fetchByMobile(long mobile) {
		List<Student> list = dao.fetchByMobile(mobile);
		ResponseStructure<List<Student>> strucutre = new ResponseStructure<>();
		if (list.isEmpty()) {
			strucutre.setMessage("No Data Found");
			strucutre.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			strucutre.setMessage("Data Found");
			strucutre.setStatus(HttpStatus.FOUND.value());
			strucutre.setData(list);
		}
		return strucutre;
	}

	public ResponseStructure<List<Student>> fetchByResult(String result) {
		List<Student> list = dao.fetchByResult(result);
		ResponseStructure<List<Student>> strucutre = new ResponseStructure<>();
		if (list.isEmpty()) {
			strucutre.setMessage("No Data Found");
			strucutre.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			strucutre.setMessage("Data Found");
			strucutre.setStatus(HttpStatus.FOUND.value());
			strucutre.setData(list);
		}
		return strucutre;
	}

	public ResponseStructure<List<Student>> findbySubjectGreater(String subject, int marks) {
		
		List<Student> list=null;
		
		if (subject.equalsIgnoreCase("Mathematics"))
			list= dao.findbyMathsGreater(marks);
		else if (subject.equalsIgnoreCase("Physics"))
			list= dao.findByPhysicsGreater(marks);
		else
			list= dao.findByCSGreater(marks);
		
		ResponseStructure<List<Student>> strucutre = new ResponseStructure<>();
		if (list==null || list.isEmpty()) {
			strucutre.setMessage("No Data Found");
			strucutre.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			strucutre.setMessage("Data Found");
			strucutre.setStatus(HttpStatus.FOUND.value());
			strucutre.setData(list);
		}
		return strucutre;
		
	}

	public ResponseStructure<List<Student>> fetchBetweenPhysics(int a, int b) {
		List<Student> list = dao.fetchBetweenPhysics(a, b);
		ResponseStructure<List<Student>> strucutre = new ResponseStructure<>();
		if (list.isEmpty()) {
			strucutre.setMessage("No Data Found");
			strucutre.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			strucutre.setMessage("Data Found");
			strucutre.setStatus(HttpStatus.FOUND.value());
			strucutre.setData(list);
		}
		return strucutre;
	}

	public ResponseStructure<Student> deleteById(int id) {
		Student student = dao.fetchById(id);
		ResponseStructure<Student> strucutre = new ResponseStructure<>();
		if (student == null) {
			strucutre.setMessage("No Data Found");
			strucutre.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			dao.deleteById(id);
			strucutre.setMessage("Data Found");
			strucutre.setStatus(HttpStatus.FOUND.value());
			strucutre.setData(student);
		}

		return strucutre;
	}

	public ResponseStructure<Student> update(Student student) {
		int total = student.getPhysics() + student.getMathematics() + student.getComputerScience();
		student.setTotal(total);
		double percentage = total / 3.0;
		student.setPercetage(percentage);
		if (student.getPhysics() < 35 || student.getMathematics() < 35 || student.getComputerScience() < 35) {
			student.setResult("Fail");
		} else {
			if (percentage >= 85)
				student.setResult("Distinction");
			else if (percentage >= 60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}

		ResponseStructure<Student> strucutre = new ResponseStructure<>();

		strucutre.setMessage("Data Found");
		strucutre.setStatus(HttpStatus.FOUND.value());
		strucutre.setData(dao.save(student));
		return strucutre;
	}
}
