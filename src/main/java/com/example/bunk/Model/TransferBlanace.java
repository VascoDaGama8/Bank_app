package com.example.bunk.Model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransferBlanace {

    private int from;
    private int to;
    private int amount;
}
