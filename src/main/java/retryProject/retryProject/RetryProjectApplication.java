package retryProject.retryProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;


@EnableRetry
@SpringBootApplication
public class RetryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryProjectApplication.class, args);
	}

}
