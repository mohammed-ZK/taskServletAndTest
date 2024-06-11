package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountManagerTest {

    Customer customer = new Customer();
    AccountManager accountManager = new AccountManagerImpl();

    @Test void givenAmountBelowMaxCreditForNormalCustomerWhenWithdrawThenSubtractFromBalance() {
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
    public void testWithdrawSufficientBalance() {
//        Customer customer = new Customer(1000, false, false);
        customer.setBalance(1000);

        String result = accountManager.withdraw(customer, 500);
        assertEquals("success", result);
        assertEquals(500, customer.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalanceNoCredit() {
//        Customer customer = new Customer(1000, false, false);
        customer.setBalance(1000);

        String result = accountManager.withdraw(customer, 1500);
        assertEquals("insufficient account balance", result);
        assertEquals(1000, customer.getBalance()); // Balance should remain unchanged
    }

    @Test
    public void testWithdrawInsufficientBalanceCreditExceeded() {
//        Customer customer = new Customer(1000, true, false);
        customer.setBalance(1000);

        String result = accountManager.withdraw(customer, 7000); // 1000 - 7000 = -6000 which is less than -5000
        assertEquals("insufficient account balance", result);
        assertEquals(1000, customer.getBalance()); // Balance should remain unchanged
    }

    @Test
    public void testWithdrawInsufficientBalanceCreditAllowedVip() {
//        Customer customer = new Customer(1000, true, true);
        customer.setBalance(1000);

        String result = accountManager.withdraw(customer, 7000); // 1000 - 7000 = -6000, but customer is VIP
        assertEquals("success", result);
        assertEquals(-6000, customer.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalanceCreditWithinLimit() {
//        Customer customer = new Customer(1000, true, false);
        customer.setBalance(1000);

        String result = accountManager.withdraw(customer, 4000); // 1000 - 4000 = -3000 which is within the limit
        assertEquals("insufficient account balance", result);
        assertEquals(1000, customer.getBalance());
    }

}
