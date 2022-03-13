package study.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import study.entit.Student;

@Repository
public interface StudentMapper {
	
	void save(Student stu);

	List<Student> findAll();  
	
	Student findById(int id);
}
