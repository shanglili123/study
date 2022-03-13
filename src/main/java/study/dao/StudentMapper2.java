package study.dao;

import org.springframework.stereotype.Repository;
import study.entit.Student;

import java.util.List;

@Repository
public interface StudentMapper2 {
	
	void save(Student stu);

	List<Student> findAll();  
	
	Student findById(int id);
}
