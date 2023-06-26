package org.jsp.bootcrud.repository;

import java.util.List;

import org.jsp.bootcrud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	List<Student> findByMobile(long mobile);

	List<Student> findByResult(String result);

	List<Student> findByMathematicsGreaterThanEqual(int marks);

	List<Student> findByPhysicsGreaterThanEqual(int marks);

	List<Student> findByComputerScienceGreaterThanEqual(int marks);
	
	
	//1
	
	List<Student> findByPhysicsGreaterThanEqualAndPhysicsLessThanEqual(int a,int b);

	//2
	@Query("select x from Student x where physics between ?1 and ?2")
	List<Student> findphysicsbetween1(int a,int b);
	
	//3
	List<Student> findByPhysicsBetween(int a,int b);
	
	//4
	@Query(nativeQuery = true,value = "select * from student where physics between ?1 and ?2")
	List<Student> findphysicsbetween2(int a,int b);
	
	
}
