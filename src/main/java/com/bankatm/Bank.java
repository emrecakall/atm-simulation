package com.bankatm;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank (){
        accounts = new ArrayList<>();
        accounts.add(new Account("12345","1234", 1000.0));
        accounts.add(new Account("67890","6789", 500.0));
        accounts.add(new Account("98765","9876", 2000.0));
    }

    public Account getAccount(String accountNumber){

        for (Account account : accounts){
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }
}
