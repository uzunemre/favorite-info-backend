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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/notes")
    Page<NoteResponse> getNotes(@CurrentUser User loggedInUser, Pageable page) {
        return noteService.getNotes(loggedInUser, page).map(NoteResponse::new);
    }

    @PostMapping("/notes")
    public ResponseEntity<?> createNote(@Valid @RequestBody NoteAddRequest request, @CurrentUser User loggedInUser) {
        Category category = categoryService.getById(request.getCategoryId());
        Note note = NoteFactory.createNote(request, loggedInUser, category);
        noteService.save(note);
        return ResponseEntity.ok(new GenericResponse("Note saved"));
    }

}
