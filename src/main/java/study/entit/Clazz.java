package study.entit;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Clazz {
	 private int cid;
	 private String cname;
	 private List<Student> students;
}
