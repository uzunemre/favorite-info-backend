package com.eu.favorite.controller;

import com.eu.favorite.dto.NoteAddRequest;
import com.eu.favorite.dto.NoteResponse;
import com.eu.favorite.factory.NoteFactory;
import com.eu.favorite.model.Category;
import com.eu.favorite.model.Note;
import com.eu.favorite.model.User;
import com.eu.favorite.service.CategoryService;
import com.eu.favorite.service.NoteService;
import com.eu.favorite.shared.CurrentUser;
import com.eu.favorite.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/notes/{noteId}")
    NoteResponse getNoteById(@PathVariable long noteId) {
        Note note = noteService.getById(noteId);
        return new NoteResponse(note);
    }

    @GetMapping("/notes")
    Page<NoteResponse> getNotes(@CurrentUser User loggedInUser, Pageable page) {
        return noteService.getNotes(loggedInUser, page).map(NoteResponse::new);
    }

    @GetMapping("/notes/random-note/{categoryId}")
    NoteResponse getRandomNote(@CurrentUser User loggedInUser, @PathVariable Long categoryId) {
        Note note = noteService.getRandomNote(loggedInUser, categoryId);
        return new NoteResponse(note);
    }

    @PostMapping("/notes")
    public ResponseEntity<?> createNote(@Valid @RequestBody NoteAddRequest request, @CurrentUser User loggedInUser) {
        Category category = categoryService.getById(request.getCategoryId());
        Note note = NoteFactory.createNote(request, loggedInUser, category);
        noteService.save(note);
        return ResponseEntity.ok(new GenericResponse("Note saved"));
    }

    @PutMapping("/notes/{id:[0-9]+}")
    @PreAuthorize("@noteService.isAllowedToModify(#id, principal)")
    public ResponseEntity<?> updateNote(@PathVariable long id, @Valid @RequestBody NoteAddRequest request) {
        Note note = noteService.getById(id);
        Category category = categoryService.getById(request.getCategoryId());
        note = NoteFactory.updateNote(request, note, category);
        noteService.save(note);
        return ResponseEntity.ok(new GenericResponse("Note updated"));
    }

    @DeleteMapping("/notes/{id:[0-9]+}")
    @PreAuthorize("@noteService.isAllowedToModify(#id, principal)")
    GenericResponse deleteNote(@PathVariable long id) {
        noteService.delete(id);
        return new GenericResponse("Note is removed");
    }

}
