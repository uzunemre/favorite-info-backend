package com.eu.favorite.model;

import com.eu.favorite.enumaration.ImportanceLevelEnum;
import com.eu.favorite.enumaration.ImportanceLevelEnumConverter;
import com.eu.favorite.model.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "NOTE")
public class Note {

    private static final long serialVersionUID = 4074374728582967483L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "IMPORTANCE_LEVEL")
    @Convert(converter = ImportanceLevelEnumConverter.class)
    private ImportanceLevelEnum importanceLevel;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "READ", length = 1)
    private boolean read = false;

}
