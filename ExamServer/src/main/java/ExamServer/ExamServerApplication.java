package ExamServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
		
		System.out.println("Spring boot Started");
		
	}

}
