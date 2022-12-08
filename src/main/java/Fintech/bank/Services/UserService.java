package Fintech.bank.Services;


import Fintech.bank.Models.User;

public interface UserService {

    User login(User user);
    void register(User user) throws IllegalAccessException;
    Iterable<User> getAll();
    void deleteUser(String accountNumber) throws IllegalAccessException;
}
