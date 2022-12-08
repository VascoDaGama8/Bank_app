package Fintech.bank.Controllers;



import Fintech.bank.Models.User;
import Fintech.bank.Services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private UserService usersService;

    @PostMapping("/register")
    public void register(@RequestBody User user) throws IllegalAccessException {
        usersService.register(user);
    }

    @PostMapping("/login")
    public @ResponseBody User  login(@RequestBody User user) throws IllegalAccessException {
        if(usersService.login(user) == null){
            throw new IllegalAccessException("Wrong username or password");
        }
        return usersService.login(user);
    }

    @PostMapping("/delet")
    public void deletUser(@RequestBody String accountNumber) throws IllegalAccessException {
        usersService.deleteUser(accountNumber);
    }

    @PostMapping("/users")
    public  @ResponseBody Iterable<User> getAll(){
        return usersService.getAll();
    }

    @ExceptionHandler(IllegalAccessException.class)
    public String handle(IllegalAccessException e){
        log.error(e.getMessage());
        return e.getMessage();
    }

}
