package pl.bonus;

public interface AccountsThings {


    void deposit(int amount) throws IllegalArgumentException;

    void withdraw(int amount) throws IllegalArgumentException;

    void getPreviousTransaction();

    void calculateInterests(int years);
}
