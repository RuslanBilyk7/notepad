package com.test.job.notepad.services;

import com.test.job.notepad.domain.Note;

import java.util.List;

public interface NoteService {
    void addNote(Note user);

    void deleteNote(Integer id);

    List<Note> getAllNotes();

    Note getNoteById(Integer id);

    Note saveOrUpdateUser(Note note);
}
