package com.thoughtprocessing.core;

import com.thoughtprocessing.model.Contact;
import com.thoughtprocessing.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thoughtprocessing-core")
@SpringBootApplication
@EntityScan(basePackages = "com.thoughtprocessing.model")


@EnableJpaRepositories(basePackages = "com.thoughtprocessing.repository")


@ComponentScan(basePackages = {"com.thoughtprocessing.core", "com.thoughtprocessing.controller",
        "com.thoughtprocessing.service","com.thoughtprocessing.repository",
        "com.thoughtprocessing",
        "com.thoughtprocessing.security"
})


public class Application {

	public static void main(String[] args) {

        System.out.println("Hello from Spring Boot!");
        SpringApplication.run(Application.class, args);
	}
    @GetMapping("/status")
    public String checkCoreStatus() {
        return "Lantern is glowing from core!";
    }
    @GetMapping("/check")
    public ResponseEntity<String> getValue(@RequestParam String thoughtprocessing) {
        String response = String.format("Query param: " + thoughtprocessing);
        return ResponseEntity.ok(response);
        //return ResponseEntity.ok("Query param: " + value);


    }

   // @Bean
   // CommandLineRunner init(ContactRepository repo) {
        //return args -> {
           // Contact c = new Contact();
           // c.setName("Singu");
           // c.setEmail("singu@example.com");
            //c.setSubject("Lantern Inquiry");
           // c.setMessage("How do we model emotional clarity in layout?");
            //repo.save(c);
        //};
    //}



}
