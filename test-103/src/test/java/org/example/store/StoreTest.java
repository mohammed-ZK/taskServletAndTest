package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StoreTest {
    private StoreImpl store;
    private AccountManager accountManager;
    private Customer customer;
    private Product product;

    @BeforeEach
    public void setUp() {
        accountManager = mock(AccountManager.class);
        store = new StoreImpl(accountManager);
        customer = new Customer();
        product = new Product();
    }

    @Test
    public void shouldBuyProductWhenOutOfStock() {
        product.setQuantity(0);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            store.buy(product, customer);
        });

        assertEquals("Product out of stock", exception.getMessage());
    }

    @Test
    public void shouldFailToBuyProductOnPaymentFailure() {
        product.setQuantity(1);
        product.setPrice(100);
        when(accountManager.withdraw(customer, 100)).thenReturn("insufficient account balance");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            store.buy(product, customer);
        });

        assertEquals("Payment failure: insufficient account balance", exception.getMessage());
    }

    @Test
    public void shouldSuccessfullyBuyProduct() {
        product.setQuantity(1);
        product.setPrice(100);
        when(accountManager.withdraw(customer, 100)).thenReturn("success");

        store.buy(product, customer);

        assertEquals(0, product.getQuantity());
        verify(accountManager, times(1)).withdraw(customer, 100);
    }
}
