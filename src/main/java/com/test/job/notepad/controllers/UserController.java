package com.test.job.notepad.controllers;

import com.test.job.notepad.domain.User;
import com.test.job.notepad.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String redirToList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping("/user/new")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable String id) {
        userService.deleteUser(Integer.valueOf(id));
        return "redirect:/users";
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String saveOrUpdateUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        User savedUser = userService.saveOrUpdateUser(user);
        return "redirect:/users";
    }

    @RequestMapping("user/edit/{id}")
    public String editUser(@PathVariable String id, Model model) {
        User user = userService.getUserById(Integer.valueOf(id));
        model.addAttribute("user", user);
        return "editUser";
    }
}