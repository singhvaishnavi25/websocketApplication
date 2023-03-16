package com.webapp.websocketApp.controller;

import com.webapp.websocketApp.service.JeopardyService;
import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private JeopardyService jeopardyService;

    @MessageMapping("/auto-suggest")
    @SendTo("/topic/suggestions")
    public List<String> streamSuggestedQuestions(String keyword) throws JSONException {
    List<String> suggestions = (List<String>) jeopardyService.streamSuggestedQuestions(keyword);
        
    // Parse the JSON array
    JSONArray jsonArray = new JSONArray(suggestions);

    List<String> topSuggestions = new ArrayList<>();
    // Print up to 7 suggestions on a new line
    int count = 0;
    for (int i = 0; i < jsonArray.length(); i++) {
        if (count >= 7) {
            break;
        }
        topSuggestions.add(jsonArray.getString(i));
        count++;
    }

    return topSuggestions;
    }
}
