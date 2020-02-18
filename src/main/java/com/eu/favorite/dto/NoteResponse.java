package com.eu.favorite.dto;

import com.eu.favorite.model.Note;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoteResponse {

    private long id;

    private String title;

    private String category;

    private boolean read;

    public NoteResponse(Note note) {
        this.setId(note.getId());
        this.setTitle(note.getTitle());
        this.setCategory(note.getCategory().getName());
        this.setRead(note.isRead());
    }
}
