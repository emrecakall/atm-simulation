package com.bankatm;
import java.util.InputMismatchException;
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
            Account currentAccount = handleLogin();

            if(currentAccount != null){
                showMenuAndHandleActions(currentAccount);
            }
            System.out.println();

        }
    }

    private Account handleLogin(){
        while(true) {
            System.out.print("Hesap numaranızı giriniz: ");
            String enteredNumber = scanner.nextLine();

            Account account = bank.getAccount(enteredNumber);

            if(account == null){
                System.out.println("Hesap bulunamadı. Lütfen tekrar deneyin.");
                System.out.println();
                continue;
            }

            System.out.print("Şifrenizi giriniz: ");
            String enteredPin = scanner.nextLine();


            if(account.validatePin(enteredPin)){
                return account;
            }else{
                System.out.println("Hatalı şifre! Lütfen tekrar deneyin.");
                System.out.println();
            }

        }
    }
    
    private void showMenuAndHandleActions(Account currentAccount){
        while(true) {

            System.out.print("""
                    
                    --- Menü ---
                    1. Bakiye Görüntüle
                    2. Para Yatır
                    3. Para Çek
                    4. Çıkış Yap
                    """);
            System.out.print("Lütfen bir işlem seçiniz: ");

            try{
                int userChoise = scanner.nextInt();
                scanner.nextLine();

                switch (userChoise) {
                    case 1 -> System.out.println("\nBakiye: $" + currentAccount.getBalance());
                    case 2 -> {
                        System.out.print("\nYatırmak istediğiniz tutarı giriniz(İptal için 0'a basın): ");
                        double balance = scanner.nextDouble();
                        if (balance > 0) {
                            currentAccount.deposit(balance);
                            bank.saveAccountsToFile();
                            System.out.println("\nPara yatırma işlemi başarılı.");
                        }

                    }
                    case 3 -> {
                        System.out.print("\nÇekmek istediğiniz tutarı giriniz(İptal için 0'a basın): ");
                        double balance = scanner.nextDouble();
                        if (balance > 0) {
                            if (currentAccount.withdraw(balance)) {
                                bank.saveAccountsToFile();
                                System.out.println("\nİşlem başarılı.");
                            } else {
                                System.out.println("\nYetersiz bakiye veya geçersiz tutar.");
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Çıkış yapılıyor...");
                        return;
                    }
                    default -> System.out.println("Geçerli bir işlem numarası giriniz!");
                }
            }

            catch (InputMismatchException e){
                System.out.println("\nHata: Lütfen sadece 1-4 arasında bir sayı giriniz.");
                scanner.nextLine();
            }
        }

    }

}


