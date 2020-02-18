package com.eu.favorite.service;

import com.eu.favorite.model.Note;
import com.eu.favorite.model.User;
import com.eu.favorite.repository.NoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class NoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        super();
        this.noteRepository = noteRepository;
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public Page<Note> getNotes(User loggedInUser, Pageable pageable) {
        return noteRepository.findByUser(loggedInUser, pageable);
    }

}
