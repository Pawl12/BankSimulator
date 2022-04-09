package pl.bonus;

import java.util.Scanner;

public class Account implements AccountsThings{

    int balance;
    int previusTransaction;
    private String customerName;
    private String customerID;

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    Account(String customerName, String customerID)
    {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    //Pod testy
    Account()
    {

    }

    //Metoda do depozytu pieniedzy
    @Override
    public void deposit(int amount) throws IllegalArgumentException {
        if(amount > 0)
        {
            balance = balance + amount;
            previusTransaction = amount;
        }
        else
        {
            throw new IllegalArgumentException("U cannot deposit it!");
        }
    }

    //Metoda do wybierania pieniedzy
    @Override
    public void withdraw(int amount) throws IllegalArgumentException {
        if(amount > 0 )
        {
            balance = balance - amount;
            previusTransaction = -amount;
        }
        else
        {
            throw new IllegalArgumentException("U cannot withdraw a negative money amount");
        }
    }

    @Override
    public void getPreviousTransaction() {

        if(previusTransaction > 0){
            System.out.println("Deposited " + previusTransaction);
        }else if(previusTransaction < 0){
            System.out.println("Withdrawed" + Math.abs(previusTransaction));
        }else{
            System.out.println("No transactions there");
        }

    }

    @Override
    public void calculateInterests(int years) {
        double interestsRate = .0185;
        double newBalance = (balance * interestsRate * years) + balance;
        System.out.println("The current interests rate is " + (100 * interestsRate));
        System.out.println("After " + years + "years, you balance will be" + newBalance);
    }


    //MENU

    void showMenu(){
        char option = '\0';
        System.out.println("Welcome " + getCustomerName() + ".");
        System.out.println("Your id is " + getCustomerID() + ".");
        System.out.println();
        System.out.println("Choose an option.");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Deposit money.");
        System.out.println("C. Withdraw money.");
        System.out.println("D. View previous transaction.");
        System.out.println("E. Calculate interests.");
        System.out.println("F. Exit.");


        do{
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scan.next().charAt(0);
            option = Character.toUpperCase(option1);

            switch(option)
            {
                case 'A':
                    System.out.println("Your balance is " + balance);
                    break;

                case 'B':
                    System.out.println("How much do u like to deposite: ");
                    int depositMoney = scan.nextInt();
                    deposit(depositMoney);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("How much do u like to withdraw: ");
                    int withdrawMoney = scan.nextInt();
                    withdraw(withdrawMoney);
                    System.out.println();
                    break;

                case 'D':
                    getPreviousTransaction();
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("How many years of accured interests: ");
                    int years = scan.nextInt();
                    calculateInterests(years);
                    System.out.println();
                    break;

                case 'F':
                    System.out.println("**********");
                    break;

                default:
                    System.out.println("Wrong character!");
                    break;

            }


        }while(option != 'F');

    }

    Scanner scan = new Scanner(System.in);

}
