package com.example.bunk.Model;

import lombok.Data;

@Data
public class User {
    private String userType;
    private String username;
    private String password;
    private String fio;
    private int accountNumber;
    private int id;
    private int balance;
}
