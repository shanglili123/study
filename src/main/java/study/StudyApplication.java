package study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@SpringBootApplication
@MapperScan("study.dao") 
public class StudyApplication {
	public static void main(String[] args) throws Exception {
	
		SpringApplication.run(StudyApplication.class, args);
	}
}
