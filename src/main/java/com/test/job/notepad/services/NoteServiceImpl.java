package com.test.job.notepad.services;

import com.test.job.notepad.domain.Note;
import com.test.job.notepad.domain.User;
import com.test.job.notepad.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void addNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(Integer id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> target = new ArrayList<>();
        for (Note note : noteRepository.findAll()) {
            target.add(note);
        }
        return target;
    }

    @Override
    public List<Note> getAllNotesByUser(Integer id) {
        List<Note> target = new ArrayList<>();
        for (Note note : noteRepository.findAll()) {
            if (note.getUser().getUserId() == id) {
                target.add(note);
            }
        }
        return target;
    }



    @Override
    public Note getNoteById(Integer id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public Note saveOrUpdateNote(Note note) {
        return noteRepository.save(note);
    }
}
