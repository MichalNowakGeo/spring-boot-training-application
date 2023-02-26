package pl.sda.springboottraining;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootTrainingApplication implements CommandLineRunner {

	@Value("${moj.properties}")
	private String propertyValue;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootTrainingApplication.class, args);

		System.out.println("Hello world");

		PeselValidator peselValidator = context.getBean(PeselValidator.class);
		System.out.println(peselValidator.check("wef"));
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Property value: " + propertyValue);
	}
}