package com.example.easynotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.easynote.service.NotesService;
import com.example.easynotes.repository.NoteRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class EasyNotesWebApplication {

	
	public static final String NOTES_SERVICE_URL = "http://NOTES-MICROSERVICE";
	
	public static void main(String[] args) {
		SpringApplication.run(EasyNotesWebApplication.class, args);
	}
	

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public NoteRepository accountRepository(){
		return new NotesService(NOTES_SERVICE_URL);
	}
}
