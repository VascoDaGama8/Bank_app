package com.example.bunk;

import com.example.bunk.Model.TransferBlanace;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BalanceService {

    private final BalanceRepository repository;

    public Integer addMoney(int to, int amount) {
        Integer currentBalance = repository.getBalanceForId(to);
        if(currentBalance == null){
            repository.save(to, amount);
            return amount;
        }
        else{
            Integer updateBalance = currentBalance + amount;
            repository.save(to,  updateBalance);
            return updateBalance;
        }
    }

    public void makeTransfer(TransferBlanace transferBlanace) throws IllegalAccessException {
        Integer fromBalance = repository.getBalanceForId(transferBlanace.getFrom());
        BigDecimal toBalance = repository.getBalanceForId(transferBlanace.getTo());
        if(fromBalance == null || toBalance == null){
            throw new IllegalAccessException();
        }
        if(transferBlanace.getAmount() == fromBalance){
            throw new IllegalAccessException("No money");
        }

        BigDecimal updatedFromBalance = fromBalance.subtract(transferBlanace.getAmount());
        BigDecimal updatedTobalance = toBalance.add(transferBlanace.getAmount());
        repository.save(transferBlanace.getFrom(), updatedFromBalance);
        repository.save(transferBlanace.getTo(), updatedTobalance);
    }
}
