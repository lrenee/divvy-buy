package org.divvybuy.divvybuy.controllers;

import org.divvybuy.divvybuy.data.TopicRepository;
import org.divvybuy.divvybuy.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public String displayAllTopics(Model model) {
        model.addAttribute("title", "All Topics");
        model.addAttribute("topics", topicRepository.findAll());
        return "topics/index";
    }

    @GetMapping("create")
    public String renderCreateTopicForm(Model model) {
        model.addAttribute("title", "Create Topic");
        model.addAttribute(new Topic());
        return "topics/create";
    }

    @PostMapping("create")
    public String processCreateTopicForm(@ModelAttribute @Valid Topic topicName, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Topic");
            model.addAttribute(new Topic());
            return "topics/create";
        }
        topicRepository.save(topicName);
        return "redirect:";
    }

}
