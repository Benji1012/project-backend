package szakdoga.Balatoni_szallas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BalatoniSzallasApplication implements CommandLineRunner{

	@Autowired
	
	public static void main(String[] args) {
		SpringApplication.run(BalatoniSzallasApplication.class, args);
	}
	
	public void run(String... args) {
//		
	}

}
