package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount normalbank = new BankAccount();
        normalbank.acctNumber = "100";
        normalbank.balance = 1000;

        System.out.println("normalbank");
        System.out.println(normalbank.acctNumber);
        System.out.println(normalbank.balance);


        Checking checkingbank = new Checking();
        checkingbank.acctNumber = "101";
        checkingbank.balance = 2000;
        checkingbank.limit = 200000;
        System.out.println("Checking");
        System.out.println(checkingbank.acctNumber);
        System.out.println(checkingbank.balance);
        System.out.println(checkingbank.limit);


        SavingsAccount savingsbank = new SavingsAccount();
        savingsbank.acctNumber = "102";
        savingsbank.balance = 3000;
        savingsbank.protect = false;

        System.out.println("Savings");
        System.out.println(savingsbank.acctNumber);
        System.out.println(savingsbank.balance);
        System.out.println(savingsbank.protect);


        CertificateOfDeposit certificatebank = new CertificateOfDeposit();
        certificatebank.acctNumber = "103";
        certificatebank.balance = 4000;
        certificatebank.certified = true;

        System.out.println("certificate");
        System.out.println(certificatebank.acctNumber);
        System.out.println(certificatebank.balance);
        System.out.println(certificatebank.certified);



    }
}