package gestion.finanzas.personales.gfp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "gestion.finanzas.personales.gfp.repository")
//@EntityScan(basePackages = "gestion.finanzas.personales.gfp.entity")

public class 	GfpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GfpApplication.class, args);
	}

}
