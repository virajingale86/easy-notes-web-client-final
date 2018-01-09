package com.example.easynotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.easynotes.repository.NoteRepository;


@Controller
public class NoteController {

    @Autowired
    NoteRepository noteRepository;
    
    	
    @RequestMapping("/")
	public String home(){
		return "index";
	}
	@RequestMapping("/notesList")
	public String notesList(Model model) {
		model.addAttribute("Notes", noteRepository.getAllNotes());
		return "notesList";
	}
	
	@RequestMapping("/noteDetails")
	public String noteDetails(@RequestParam("number") String id, Model model) {
		model.addAttribute("NoteData", noteRepository.getNote(id));
		return "noteDetails";
	}

}
