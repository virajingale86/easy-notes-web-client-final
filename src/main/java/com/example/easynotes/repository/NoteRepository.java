package com.example.easynotes.repository;

import java.util.List;

import com.example.easynotes.model.Note;

public interface NoteRepository  {
	

	List<Note> getAllNotes();
	
	Note getNote(String number);

}
