package Fintech.bank.Services;


import Fintech.bank.Models.TransferBlanace;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface BalanceService {


    void addMoney(String to, String amount);

    void makeTransfer(TransferBlanace transferBlanace) throws IllegalAccessException;
}
