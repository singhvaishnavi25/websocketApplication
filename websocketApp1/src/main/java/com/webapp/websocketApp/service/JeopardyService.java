/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.websocketApp.service;



import com.webapp.websocketApp.model.Jeopardy;
import com.webapp.websocketApp.repository.JeopardyRepository;
import java.util.List;
//import java.util.stream.Stream;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author vaish
 */
@Service
public class JeopardyService {

    @Autowired
    private JeopardyRepository jeopardyRepository;
    
    @Autowired
    private CacheManager cacheManager;
    
    @Cacheable(value = "suggestions")
    public List<Jeopardy> getQuestion() {
        System.out.println("getting query from db!!");
        System.out.println("cache"+cacheManager.toString());
        return jeopardyRepository.findAll();
    }

    @Cacheable(value = "suggestions", key = "#keyword")
    public List<String> streamSuggestedQuestions(String keyword) {
        System.out.println("getting query from cache!!!!!!!!");
        return (List<String>) jeopardyRepository.findByKeyword(keyword);
    }
    
}

