/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.websocketApp.model;

import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

/**
 *
 * @author vaish
 */
//[{"category": "HISTORY", "air_date": "2004-12-31", "question": "'For the last 8 years of his life,
//Galileo was under house arrest for espousing this man's theory'", 
//"value": "$200", "answer": "Copernicus", "round": "Jeopardy!", "show_number": "4680"}
@Entity
@Table(name = "jeopardy")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Jeopardy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "show_number")
    private Integer showNumber;

    @Column(name = "air_date")
    private LocalDate airDate;

    @Column(name = "round")
    private String round;

    @Column(name = "category")
    private String category;

    @Column(name = "value")
    private String value;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    // getters and setters
    
    public void setId(Long id) {
        this.id = id;
    }

    @CacheEvict(value = "suggestions", allEntries = true)
    public void setQuestion(String question) {
        this.question = question;
    }

    
    public Long getId() {
        return id;
    }

    @Cacheable(value = "suggestions ")
    public String getQuestion() {
        return question;
    }
    // constructors
    // other methods


}

