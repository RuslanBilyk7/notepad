package com.test.job.notepad.repositories;

import com.test.job.notepad.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
