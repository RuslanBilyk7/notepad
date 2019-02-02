package com.test.job.notepad.controllers;

import com.test.job.notepad.domain.Note;
import com.test.job.notepad.domain.User;
import com.test.job.notepad.services.NoteService;
import com.test.job.notepad.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private UserService userService;

    @RequestMapping("/notes")
    public String redirToList(Model model) {
        User user = getCurrentUser();
        model.addAttribute("notes", noteService.getAllNotesByUser(user.getUserId()));
        return "notes";
    }

    @RequestMapping("/notes/{user}")
        public String redirToList1(@PathVariable User user, Model model) {
            model.addAttribute("notes", noteService.getAllNotesByUser(user.getUserId()));
            return "notes";
        }


    @RequestMapping("/note/new")
    public String newNote(Model model) {
        Note note = new Note();
        model.addAttribute("note", note);
        return "addEditNote";
    }

    @RequestMapping("/note/delete/{id}")
    public String delete(@PathVariable String id) {
        noteService.deleteNote(Integer.valueOf(id));
        return "redirect:/notes";
    }

    @RequestMapping(value = "/saveNote", method = RequestMethod.POST)
    public String saveOrUpdateNote(@Valid Note note, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addEditNote";
        }
        User user = getCurrentUser();
        note.setUser(user);
        noteService.saveOrUpdateNote(note);
        return "redirect:/notes";
    }

    private User getCurrentUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getUserByLogin(login);
    }

    @RequestMapping("note/edit/{id}")
    public String editUser(@PathVariable String id, Model model) {
        Note note = noteService.getNoteById(Integer.valueOf(id));
        model.addAttribute("note", note);
        return "addEditNote";
    }
}
