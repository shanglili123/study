package study.entit;

import java.util.List;

import lombok.Data;

@Data
public class Course {
	/**
	 * 主键
	 */
	private int crid;
	/**
	 * 名称
	 */
	private String crname;
	
	private List<Student>  students;
	
	/**
	 * 代课老师
	 */
	private Teacher teacher;
}
