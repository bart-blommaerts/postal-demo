package be.bbconsulting.postal;

import be.bbconsulting.postal.calculation.Calculator;
import be.bbconsulting.postal.model.PostalInformation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostalApplication.class, args);

		Calculator c = new Calculator();
		c.calculate(new PostalInformation());
	}
}
