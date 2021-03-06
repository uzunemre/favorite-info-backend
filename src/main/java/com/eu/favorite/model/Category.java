package com.eu.favorite.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category {

    private static final long serialVersionUID = 4074374728582967483L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

}
