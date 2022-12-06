package com.example.bunk;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {

    private final Map<Integer, Integer> storage = new HashMap<>(Map.of(1, 10);


    public Integer getBalanceForId(int accountId) {
        return storage.get(accountId);
    }

    public void save(int id, int amount) {
        storage.put(id, amount);
    }
}
