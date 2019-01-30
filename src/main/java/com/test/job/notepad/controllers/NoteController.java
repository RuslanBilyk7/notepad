package com.test.job.notepad.controllers;

import com.test.job.notepad.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/notes")
    public String redirToList(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "notes";

    }


}