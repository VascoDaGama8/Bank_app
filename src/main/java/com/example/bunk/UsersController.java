package com.example.bunk;

import com.example.bunk.Model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController("/user")
@AllArgsConstructor
public class UsersController {

    private UsersService usersService;

    @PostMapping("/register")
    public boolean Registration(@RequestBody User user){
        return usersService.registration(user);
    }

    @PostMapping("/login")
    public boolean Sigin(@RequestBody User user){
        return usersService.sigin(user);
    }

    @GetMapping("/users")
    public ArrayList<User> usersInfo(){
        return usersService.getUsersInfo();
    }

}
