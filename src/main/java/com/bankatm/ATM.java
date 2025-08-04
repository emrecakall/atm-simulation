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
            Account currentAccount = handleLogin();

            if(currentAccount != null){
                showMenuAndHandleActions(currentAccount);
            }

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
    
    private void showMenuAndHandleActions(Account currentAccount){
        while(true) {

            System.out.print("""
                    --- Menü ---
                    1. Bakiye Görüntüle
                    2. Para Yatır
                    3. Para Çek
                    4. Çıkış Yap
                    Lütfen bir işlem seçiniz:
                    """);


            int userChoise = scanner.nextInt();
            scanner.nextLine();

            switch (userChoise) {
                case 1 -> System.out.println(currentAccount.getBalance());
                case 2 -> {
                    System.out.println("Yatırmak istediğiniz tutarı giriniz:");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    currentAccount.deposit(balance);
                    System.out.println("Para yatırma işlemi başarılı.");
                }
                case 3 -> {
                    System.out.println("Çekmek istediğiniz tutarı giriniz:");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    if (currentAccount.withdraw(balance)) {
                        System.out.println("İşlem başarılı.");
                    } else {
                        System.out.println("Geçersiz tutar!");
                    }
                }
                case 4 -> {
                    System.out.println("Çıkış yapılıyor...");
                    return;
                }
                default -> System.out.println("Geçerli bir işle numarası giriniz!");
            }
        }

    }

}


