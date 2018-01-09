package com.example.easynote.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;

public class NotesService implements NoteRepository{

	@Autowired
	protected RestTemplate restTemplate;
	protected String serviceUrl;
	
	public NotesService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	
	
	@Override
	public List<Note> getAllNotes() {
		Note[] notes = restTemplate.getForObject(serviceUrl+"/api/notes", Note[].class);
		return Arrays.asList(notes);
	}

	@Override
	public Note getNote(String number) {
		return restTemplate.getForObject(serviceUrl + "/api/notes/{number}",
				Note.class, number);
	}

}
