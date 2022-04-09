package pl.bonus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    @Test
    void depositTest() {
        //given
        Account account = new Account();
        account.setGetBalance(0);
        int moneyToDeposit = 10;
        int expectedResult = 10;
        //when
        account.deposit(moneyToDeposit);
        //then
        assertEquals(expectedResult, account.getGetBalance());
    }
}