package pl.bonus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertionsTest {

    Account account = new Account();

    @Test
    void deposit() {
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    account.deposit(0);
                });}

    @Test
    void withdraw() {

        assertThrows(IllegalArgumentException.class,
                ()-> {
                    account.withdraw(-1);
                });}

}