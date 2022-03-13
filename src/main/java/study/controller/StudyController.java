package study.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import study.dao.StudentMapper;
import study.entit.Student;

@RestController
public class StudyController {
	
	@Autowired
	StudentMapper studentMapper;
	
	@PostMapping("/add")
	public ResponseEntity<Student> add(@RequestBody Student stuedent) {
		ResponseEntity<Student> responseEntity = new ResponseEntity<Student>(stuedent, HttpStatus.OK);
		stuedent.setInsertTime(new Date());
		studentMapper.save(stuedent);
		System.out.println(stuedent.toString()+"�����ɹ�");
		return responseEntity;
		
	}
	@GetMapping("/getList")
	public Object getList() {
		PageHelper.startPage(0,2);
		final PageInfo<Student> stuPageInfo = new PageInfo( studentMapper.findAll());
        //List<Student> stus = studentMapper.findAll();
		//ResponseEntity<List<Student>> responseEntity = new ResponseEntity<List<Student>>(stus, HttpStatus.OK);
		
		return stuPageInfo;
		
	}

	public static void main(String[] args) {
		TreeMap<String,String>  tree = new TreeMap<>((o1,o2)->Integer.parseInt(Optional.ofNullable(o1).orElse("0"))-Integer.parseInt(Optional.ofNullable(o2).orElse("0")));
		tree.put(null,"null");
		tree.put("2","b");
		tree.put("1","a");
		tree.put("11","aa");
		tree.put("22","bb");
		tree.put("3","c");
		tree.forEach((k,v)->{
			System.out.println(k+v);
		});
	}
}
