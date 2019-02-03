package com.test.job.notepad;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.test.job.notepad.domain.User;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

    public static final String BASE_SQL //
            = "Select u.user_Id, u.login, u.password From notepad.user u ";

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        int userId = rs.getInt("user_Id");
        String login = rs.getString("login");
        String password = rs.getString("password");

        return new User(userId,login,password);
    }

}