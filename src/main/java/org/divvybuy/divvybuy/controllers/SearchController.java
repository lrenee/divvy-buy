package org.divvybuy.divvybuy.controllers;

import org.divvybuy.divvybuy.data.ThreadRepository;
import org.divvybuy.divvybuy.data.TopicRepository;
import org.divvybuy.divvybuy.models.Thread;
import org.divvybuy.divvybuy.models.ThreadTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private TopicRepository topicRepository;

    @RequestMapping("")
    public String search(Model model) {
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchTerm) {

        Iterable<Thread> threads;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")) {
            threads = threadRepository.findAll();
        } else {
            threads = ThreadTerms.findByTerm(searchTerm, threadRepository.findAll());
        }
        model.addAttribute("title", "Threads with " + searchTerm);
        model.addAttribute("threads", threads);

        return "search";
    }

}
