package com.test.job.notepad.repositories;

import com.test.job.notepad.domain.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note,Integer> {

}
