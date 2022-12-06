package com.example.bunk;

import com.example.bunk.Model.TransferBlanace;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController("/balance")
@AllArgsConstructor
public class BalanceController {

    private BalanceService bunkService;


    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBlanace transferBlanace){
        return bunkService.addMoney(transferBlanace.getTo(), transferBlanace.getAmount());
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
