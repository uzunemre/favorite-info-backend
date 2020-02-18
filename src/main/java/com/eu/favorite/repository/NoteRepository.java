package com.eu.favorite.repository;

import com.eu.favorite.model.Note;
import com.eu.favorite.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Page<Note> findByUser(User user, Pageable pageable);

}
