package org.jsp.bootcrud.dao;

import java.util.List;

import org.jsp.bootcrud.dto.Student;
import org.jsp.bootcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public Student save(Student student) {
		return repository.save(student);
	}

	public List<Student> saveAll(List<Student> list) {
		return repository.saveAll(list);
	}

	public List<Student> fetchAll() {
		return repository.findAll();
	}

	public Student fetchById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Student> fetchByName(String name) {
		return repository.findByName(name);
	}

	public List<Student> fetchByMobile(long mobile) {
		return repository.findByMobile(mobile);
	}

	public List<Student> fetchByResult(String result) {
		return repository.findByResult(result);
	}

	public List<Student> findbyMathsGreater(int marks) {
		return repository.findByMathematicsGreaterThanEqual(marks);
	}

	public List<Student> findByPhysicsGreater(int marks) {
		return repository.findByPhysicsGreaterThanEqual(marks);
	}

	public List<Student> findByCSGreater(int marks) {
		return repository.findByComputerScienceGreaterThanEqual(marks);
	}

	public List<Student> fetchBetweenPhysics(int a, int b) {
	//	return repository.findByPhysicsGreaterThanEqualAndPhysicsLessThanEqual(a, b);
	//	return repository.findphysicsbetween1(a, b);
	//	return repository.findByPhysicsBetween(a, b);
		return repository.findphysicsbetween2(a, b);
	}

	public Student deleteById(int id) {
		repository.deleteById(id);
		return null;
	}
	
}
