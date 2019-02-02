package com.test.job.notepad.services;

import com.test.job.notepad.domain.Note;
import com.test.job.notepad.domain.User;
import com.test.job.notepad.repositories.NoteRepository;
import com.test.job.notepad.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> target = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            target.add(user);
        }
        return target;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        for (User user : userRepository.findAll()) {
            if (login.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }
}
