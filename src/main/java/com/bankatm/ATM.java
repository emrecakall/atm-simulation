package com.bankatm;
import java.util.Scanner;

public class ATM {
    private Scanner scanner;
    private Bank bank;

    public ATM() {
        this.scanner = new Scanner(System.in);
        this.bank = new Bank();
    }

    public void run (){
        while(true){

        }
    }

    private Account handleLogin(){
        while(true) {
            System.out.print("Hesap numaranızı giriniz: ");
            String enteredNumber = scanner.nextLine();

            Account account = bank.getAccount(enteredNumber);

            if(account == null){
                System.out.println("Hesap bulunamadı. Lütfen tekrar deneyin.");
                continue;
            }

            System.out.print("Şifrenizi giriniz: ");
            String enteredPin = scanner.nextLine();


            if(account.validatePin(enteredPin)){
                return account;
            }else{
                System.out.println("Hatalı şifre! Lütfen tekrar deneyin.");
            }

        }
    }

}
