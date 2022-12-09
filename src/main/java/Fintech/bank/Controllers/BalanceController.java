package Fintech.bank.Controllers;

import Fintech.bank.Models.TransferBlanace;
import Fintech.bank.Services.BalanceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
public class BalanceController {

    private BalanceService bunkService;


    @PostMapping("/add")
    public void addMoney(@RequestBody TransferBlanace transferBlanace){
        bunkService.addMoney(transferBlanace.getTo(), transferBlanace.getAmount());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBlanace transferBlanace) throws IllegalAccessException {
        bunkService.makeTransfer(transferBlanace);
    }

    @ExceptionHandler(IllegalAccessException.class)
    public String handle(IllegalAccessException e){
        log.error(e.getMessage());
        return e.getMessage();
    }
}
