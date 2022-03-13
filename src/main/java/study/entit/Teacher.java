package study.entit;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Teacher {
  private int tid;	
  private String tname;
  private List<Course> courses;
}
