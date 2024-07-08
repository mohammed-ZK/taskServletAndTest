package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountManagerTest {

    Customer customer = new Customer();
    AccountManager accountManager = new AccountManagerImpl();

    @Test
    void givenAmountBelowMaxCreditForNormalCustomerWhenWithdrawThenSubtractFromBalance() {
        // Arrange
        customer.setBalance(100);

        // Act
        String result = accountManager.withdraw(customer, 80);

        // Assert
        int expectedBalance = customer.getBalance();
        Assertions.assertEquals(20, expectedBalance);
        Assertions.assertEquals("success", result);
    }


    @Test
    public void givenInsufficientBalanceAndNoCreditAllowedWhenWithdrawThenReturnInsufficientAccountBalance() {
        Customer customer = new Customer();
        customer.setBalance(50);
        customer.setCreditAllowed(false);
        customer.setVip(false);

        String result = accountManager.withdraw(customer, 100);
        assertEquals("insufficient account balance", result);
    }

    @Test
    public void givenInsufficientBalanceAndCreditAllowedAndBelowMaxCreditWhenWithdrawThenReturnSuccess() {
        Customer customer = new Customer();
        customer.setBalance(50);
        customer.setCreditAllowed(true);
        customer.setMaxCredit(100);
        customer.setVip(false);

        String result = accountManager.withdraw(customer, 100);
        assertEquals("success", result);
    }

    @Test
    public void givenInsufficientBalanceAndCreditAllowedAndExceedMaxCreditForNonVipWhenWithdrawThenReturnMaximumCreditExceeded() {
        Customer customer = new Customer();
        customer.setBalance(50);
        customer.setCreditAllowed(true);
        customer.setMaxCredit(100);
        customer.setVip(false);

        String result = accountManager.withdraw(customer, 200);
        assertEquals("maximum credit exceeded", result);
    }

    @Test
    public void givenInsufficientBalanceAndCreditAllowedAndExceedMaxCreditForVipWhenWithdrawThenReturnSuccess() {
        Customer customer = new Customer();
        customer.setBalance(50);
        customer.setCreditAllowed(true);
        customer.setMaxCredit(100);
        customer.setVip(true);

        String result = accountManager.withdraw(customer, 200);
        assertEquals("success", result);
    }

    @Test
    public void givenZeroBalanceAndNoCreditAllowedWhenWithdrawThenReturnInsufficientAccountBalance() {
        Customer customer = new Customer();
        customer.setBalance(0);
        customer.setCreditAllowed(false);
        customer.setVip(false);

        String result = accountManager.withdraw(customer, 50);
        assertEquals("insufficient account balance", result);
    }

    @Test
    public void givenExactBalanceAndNoCreditAllowedWhenWithdrawThenReturnSuccess() {
        Customer customer = new Customer();
        customer.setBalance(100);
        customer.setCreditAllowed(false);
        customer.setVip(false);

        String result = accountManager.withdraw(customer, 100);
        assertEquals("success", result);
    }
}
