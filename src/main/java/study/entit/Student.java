package study.entit;



import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Student {
	
	private int id;
	
	private String name;
	
	/**
	 * 班级
	 */
	private Clazz clazz;
	
	/**
	 * 课程
	 */
	private List<Course> courses;
	
	private Date insertTime;

}
