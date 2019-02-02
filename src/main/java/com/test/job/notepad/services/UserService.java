package com.test.job.notepad.services;

import com.test.job.notepad.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);//add new user

    List<User> getAllUsers();// select all users

    User getUserById(Integer id);// get user

    User getUserByLogin(String login);// get user

    void deleteUser(Integer id); //delete user

    User saveOrUpdateUser(User user);//save new user or update


}
