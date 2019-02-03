package com.test.job.notepad.controllers;//package com.test.job.notepad.controllers;

import com.test.job.notepad.domain.User;
import com.test.job.notepad.services.NoteService;
import com.test.job.notepad.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;

    @RequestMapping("/")
    public String redirToList(Model model) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByLogin(login);
        model.addAttribute("notes", noteService.getAllNotesByUser(user.getUserId()));
        return "notes";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
}

