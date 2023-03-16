/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.websocketApp.repository;


import com.webapp.websocketApp.model.Jeopardy;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;


/**
 *
 * @author vaish
 */
@Repository
public interface JeopardyRepository extends JpaRepository<Jeopardy, Long> {

    @Query("SELECT question FROM Jeopardy WHERE  lower(question) like lower(concat('%', :keyword, '%'))")
    List<String> findByKeyword(@Param("keyword") String keyword);

    
}


