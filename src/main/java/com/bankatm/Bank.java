package com.bankatm;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank (){
        this.accounts = new ArrayList<>();
        loadAccountsFromFile();
    }

    private void loadAccountsFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("accounts.csv"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                Double balance = Double.parseDouble(parts[2]);
                Account accountFromFile = new Account(parts[0], parts[1], balance);
                this.accounts.add(accountFromFile);

            }
        }catch(FileNotFoundException e){
            System.out.println("Dosya bulunamadı!");
        }catch(IOException e){
            System.out.println("Bir hata oluştu.");
        }

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
