package org.jsp.bootcrud.controller;

import java.util.List;

import org.jsp.bootcrud.dto.Student;
import org.jsp.bootcrud.helper.ResponseStructure;
import org.jsp.bootcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("students")
	public ResponseStructure<Student> save(@RequestBody Student student) {
		return service.save(student);
	}
	
	@PostMapping("students/all")
	public ResponseStructure<List<Student>> saveAll(@RequestBody List<Student> list)
	{
		return service.saveAll(list);
	}
	
	@GetMapping("students/all")
	public ResponseStructure<List<Student>> fetchAll()
	{
		return service.fetchAll();
	}
	
	@GetMapping("students")
	public ResponseStructure<Student> fetchById(@RequestParam int id)
	{
		return service.fetchById(id);
	}
	
	@GetMapping("students/name/{name}")
	public ResponseStructure<List<Student>> fetchByName(@PathVariable String name)
	{
		return service.fetchByName(name);
	}
	
	@GetMapping("students/mobile/{mobile}")
	public ResponseStructure<List<Student>> fetchByMobile(@PathVariable long mobile)
	{
		return service.fetchByMobile(mobile);
	}
	
	@GetMapping("students/result/{result}")
	public ResponseStructure<List<Student>> fetchByResult(@PathVariable String result)
	{
		return service.fetchByResult(result);
	}
	
	@GetMapping("students/{subject}/{marks}")
	public ResponseStructure<List<Student>> findbyMathsGreater(@PathVariable String subject,@PathVariable int marks)
	{
		return service.findbySubjectGreater(subject,marks);
	}
	
	@GetMapping("students/physics/{a}/{b}")
	public ResponseStructure<List<Student>> fetchBetweenPhysics(@PathVariable int a,@PathVariable int b){
		return service.fetchBetweenPhysics(a,b);
	}
	
	@DeleteMapping("students/{id}")
	public ResponseStructure<Student> deleteById(@PathVariable int id)
	{
		return service.deleteById(id);
	}
	
	@PutMapping("students")
	public ResponseStructure<Student> update(@RequestBody Student student) {
		return service.update(student);
	}
	
}
