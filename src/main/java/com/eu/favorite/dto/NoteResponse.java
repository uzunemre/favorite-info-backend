package com.eu.favorite.dto;

import com.eu.favorite.model.Note;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoteResponse {

    private long id;

    private String title;

    private String content;

    private String summary;

    private Integer level;

    private String importanceLevel;

    private long categoryId;

    private String category;

    private boolean read;

    public NoteResponse(Note note) {
        this.setId(note.getId());
        this.setTitle(note.getTitle());
        this.setContent(note.getContent());
        this.setSummary(note.getSummary());
        this.setLevel(note.getImportanceLevel().getLevel());
        this.setImportanceLevel(note.getImportanceLevel().getLabel());
        this.setCategoryId(note.getCategory().getId());
        this.setCategory(note.getCategory().getName());
        this.setRead(note.isRead());
    }
}
