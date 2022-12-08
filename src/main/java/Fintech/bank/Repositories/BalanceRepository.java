//package com.example.bunk.Repositories;
//
//import com.example.bunk.Models.DataTable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class BalanceRepository {
//
//    @Autowired
//    private DataTableRepository dataTableRepository;
//
//
//    public DataTable getUserAccountNumber (String accountNumber){
//        Iterable<DataTable> users = dataTableRepository.findAll();
//        for(DataTable dt : users){
//            if(dt.getAccountNumber() == accountNumber){
//                return dt;
//            }
//        }
//        return null;
//    }
//
//    public String getBalanceAccountNumber (String accountNumber){
//        Iterable<DataTable> users = dataTableRepository.findAll();
//        for(DataTable dt : users){
//            if(dt.getAccountNumber() == accountNumber){
//                return dt.getBalance();
//            }
//        }
//        return null;
//    }
//
//    public void save(String accountNumber, String amount) {
//        DataTable dt = getUserAccountNumber(accountNumber);
//        dt.setBalance(amount);
//        dataTableRepository.save(dt);
//    }
//}
