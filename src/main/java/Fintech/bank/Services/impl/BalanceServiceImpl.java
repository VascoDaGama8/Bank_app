package Fintech.bank.Services.impl;

import Fintech.bank.Models.TransferBlanace;
import Fintech.bank.Models.User;
import Fintech.bank.Repositories.UserRepository;
import Fintech.bank.Services.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private UserRepository userRepository;

    public void save(String to, String amount){
        User user = userRepository.findByAccountNumber(to);
        user.setBalance(amount);
        userRepository.save(user);
    }

    public void addMoney(String to, String amount) {

        Integer currentBalance = Integer.parseInt(userRepository.findByAccountNumber(to).getBalance());
        if(currentBalance == null){
            save(to, amount);
        }
        else{
            String updateBalance = Integer.toString(currentBalance + Integer.parseInt(amount));
            save(to,  updateBalance);
        }
    }

    public void makeTransfer(TransferBlanace transferBlanace) throws IllegalAccessException {
        Integer fromBalance = Integer.parseInt(userRepository.findByAccountNumber(transferBlanace.getFrom()).getBalance());
        Integer toBalance = Integer.parseInt(userRepository.findByAccountNumber(transferBlanace.getTo()).getBalance());
        if(fromBalance == null || toBalance == null){
            throw new IllegalAccessException("No such user");
        }
        if(Integer.parseInt(transferBlanace.getAmount()) > fromBalance){
            throw new IllegalAccessException("Not enough money");
        }
        String updatedFromBalance = Integer.toString( fromBalance - Integer.parseInt(transferBlanace.getAmount()));
        String updatedToBalance = Integer.toString( toBalance + Integer.parseInt(transferBlanace.getAmount()));
        save(transferBlanace.getFrom(), updatedFromBalance);
        save(transferBlanace.getTo(), updatedToBalance);
    }
}
