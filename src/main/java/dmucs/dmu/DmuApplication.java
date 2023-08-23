package dmucs.dmu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DmuApplication {
	public static void main(String[] args) {
		SpringApplication.run(DmuApplication.class, args);
	}
}
