package br.com.scheiner.oauth.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.scheiner"})
public class OauthResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthResourceServerApplication.class);
	}

}
