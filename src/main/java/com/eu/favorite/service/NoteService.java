package com.eu.favorite.service;

import com.eu.favorite.error.NotFoundException;
import com.eu.favorite.model.Note;
import com.eu.favorite.model.User;
import com.eu.favorite.repository.NoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    public Note getById(long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        }
        throw new NotFoundException("note not found:" + id);
    }

    public Page<Note> getNotes(User loggedInUser, Pageable pageable) {
        return noteRepository.findByUser(loggedInUser, pageable);
    }

    public boolean isAllowedToModify(long noteId, User loggedInUser) {
        Optional<Note> note = noteRepository.findById(noteId);
        if (note.isPresent()) {
            Note inDB = note.get();
            return inDB.getUser().getId() == loggedInUser.getId();
        }
        return false;
    }

}
