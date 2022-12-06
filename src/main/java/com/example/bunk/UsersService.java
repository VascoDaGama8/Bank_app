package com.example.bunk;

import com.example.bunk.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UsersService {

    private UsersRepository repository;
    public boolean registration(User user) {

        return false;
    }

    public boolean sigin(User user) {

        return false;
    }

    public User getUserInfo(int userId) {

        return null;
    }

    public ArrayList<User> getUsersInfo() {

        return null;
    }
}
