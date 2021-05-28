package br.com.icarusxc.icarus;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IcarusApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcarusApplication.class, args);
	}
	
	@PostConstruct
    void started() {
      TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }

}
