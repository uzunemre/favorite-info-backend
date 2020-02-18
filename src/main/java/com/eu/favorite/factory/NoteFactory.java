package com.eu.favorite.factory;

import com.eu.favorite.dto.NoteAddRequest;
import com.eu.favorite.model.Category;
import com.eu.favorite.model.Note;
import com.eu.favorite.model.User;

public class NoteFactory {

    public static Note createNote(NoteAddRequest request, User user, Category category) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setSummary(request.getSummary());
        note.setImportanceLevel(request.getImportanceLevel());
        note.setCategory(category);
        note.setUser(user);
        note.setRead(request.isRead());
        return note;
    }

}
