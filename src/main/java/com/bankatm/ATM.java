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

            // Daha sonra değiştirilecek!
            return null;
        }
    }

}
