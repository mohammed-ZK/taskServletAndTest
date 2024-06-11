package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class StoreMockitoTest {

    Store store;

    Product product = new Product();
    Customer customer = new Customer();


    @Test void test1() {
        // Arrange
        product.setQuantity(8);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        store = new StoreImpl(accountManager);

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(7, product.getQuantity());
    }

}
