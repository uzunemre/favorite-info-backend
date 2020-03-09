package com.eu.favorite.repository;

import com.eu.favorite.model.Note;
import com.eu.favorite.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Page<Note> findByUser(User user, Pageable pageable);

    @Query(value = "select * from favorite.note n where n.importance_level = :level and n.user_id = :user_id  and read = false " +
            "order by random() limit 1", nativeQuery = true)
    Note getRandomByLevelAndUser(@Param("level") int level,
                                 @Param("user_id") long user_id);

    @Query(value = "select * from favorite.note n where n.importance_level = :level and n.category_id = :category_id n.user_id = :user_id  and read = false " +
            "order by random() limit 1", nativeQuery = true)
    Note getRandomByLevelAndCategoryAndUser(@Param("level") int level,
                                            @Param("category_id") long category_id,
                                            @Param("user_id") long user_id);

    @Query(value = "select * from favorite.note n where n.user_id = :user_id and read = false " +
            "order by random() limit 1", nativeQuery = true)
    Note getRandomByUser(@Param("user_id") long user_id);


}
