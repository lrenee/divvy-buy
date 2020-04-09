package org.divvybuy.divvybuy.controllers;

import org.divvybuy.divvybuy.data.ThreadRepository;
import org.divvybuy.divvybuy.data.TopicRepository;
import org.divvybuy.divvybuy.models.Topic;
import org.divvybuy.divvybuy.models.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("threads")
public class ThreadController {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public String displayAllThreads(@RequestParam(required = false)Integer topicId, Model model) {

        if (topicId == null) {
            model.addAttribute("title", "All Threads");
            model.addAttribute("threads", threadRepository.findAll());
        } else {
            Optional<Topic> result = topicRepository.findById(topicId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Topic ID: " + topicId);
            } else {
                Topic topic = result.get();
                model.addAttribute("title", "Threads in topic: " + topic.getTopicName());
                model.addAttribute("threads", topic.getThreads());
            }
        }

        return "threads/index";
    }

    @GetMapping("create")
    public String displayCreateThreadForm(Model model) {
        model.addAttribute("title", "Create Thread");
        model.addAttribute(new Thread());
        model.addAttribute("topics", topicRepository.findAll());
        return "threads/create";

    }


    @PostMapping("create")
    public String processCreateThreadForm(@ModelAttribute @Valid Thread newThreadName, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Thread");
            return "threads/create";
        }
        threadRepository.save(newThreadName);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteThreadForm(Model model) {
        model.addAttribute("title", "Delete Thread");
        model.addAttribute("threads", threadRepository.findAll());
        return "threads/delete";
    }

    @GetMapping("detail")
    public String displayThreadDetails(@RequestParam Integer threadId, Model model) {

        Optional<Thread> result = threadRepository.findById(threadId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Thread ID: " + threadId);
        } else {
            Thread threadName = result.get();
            model.addAttribute("title", threadName.getThreadName() + " Details");
            model.addAttribute("threadName", threadName);
        }
        return "threads/detail";
    }

}
