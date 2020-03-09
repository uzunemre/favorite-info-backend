package com.eu.favorite.service;

import com.eu.favorite.enumaration.ImportanceLevelEnum;
import com.eu.favorite.error.NotFoundException;
import com.eu.favorite.model.Note;
import com.eu.favorite.model.User;
import com.eu.favorite.repository.NoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;


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

    public void delete(long id) {
        getById(id);
        noteRepository.deleteById(id);
    }

    public Note getById(long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        }
        throw new NotFoundException("note not found:" + id);
    }

    public Note getRandomNote(User loggedInUser, Long categoryId) {
        List<Integer> levels = new ArrayList<>();
        Arrays.stream(ImportanceLevelEnum.values()).forEach(
                importanceLevelEnum -> {
                    for (int i = 1; i <= importanceLevelEnum.getLevel(); i++) {
                        levels.add(importanceLevelEnum.getLevel());
                    }
                }
        );
        Random r = new Random();
        int index = r.nextInt(levels.size());
        int randomLevel = levels.get(index);
        Note note = null;
        if (categoryId == null) {
            note = noteRepository.getRandomByLevelAndUser(randomLevel, loggedInUser.getId());
        } else {
            note = noteRepository.getRandomByLevelAndCategoryAndUser(randomLevel, categoryId, loggedInUser.getId());
        }

        if (note == null) {
            note = noteRepository.getRandomByUser(loggedInUser.getId());
            if (note == null) {
                throw new NotFoundException("user has no note");
            }
        }
        return note;
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
