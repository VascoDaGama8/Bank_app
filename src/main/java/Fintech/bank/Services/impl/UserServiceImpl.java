package Fintech.bank.Services.impl;


import Fintech.bank.Models.User;
import Fintech.bank.Repositories.UserRepository;
import Fintech.bank.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(User user) {
        if(userRepository.findByUsername(user.getUsername()) != null
                && userRepository.findByPassword(user.getPassword()) != null){
            return userRepository.findByPassword(user.getPassword());
        }
        return null;
    }

    @Override
    public void register(User user) throws IllegalAccessException {
        User u = new User();
        char[] notAllowSymb = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w'
                ,'x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W'
                ,'X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
        for(char nas : notAllowSymb){
            if(user.getFio().indexOf(nas) != -1){
                throw new IllegalAccessException("Not allow symbol in fio");
            }
        }
        u.setFio(user.getFio());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setBalance("0");
        u.setUserType(user.isUserType());
        Random r = new Random();
        u.setAccountNumber(Integer.toString(r.nextInt(10000)+1000));
        while(userRepository.findByAccountNumber(u.getAccountNumber()) != null){
            u.setAccountNumber(Integer.toString(r.nextInt()));
        }
        if(userRepository.findByUsername(user.getUsername()) == null) {
            userRepository.save(u);
        }
        else throw new IllegalAccessException("Such user has been registered earlier");
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String accountNumber) throws IllegalAccessException {
        User u = userRepository.findByAccountNumber(accountNumber);
        if(u == null) throw new IllegalAccessException(accountNumber);
        userRepository.delete(u);
    }
}
