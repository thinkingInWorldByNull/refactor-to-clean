package com.learn.wg.demo01;

import com.learn.wg.demo01.origin.Customer;
import com.learn.wg.demo01.origin.Movie;
import com.learn.wg.demo01.origin.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.learn.wg.demo01.origin.Movie.*;

public class CustomerOriginalTest {
    @Test
    public void test_statement() {
        Customer customer = new Customer("Bob");

        customer.addRental(new Rental(new Movie("银熊", NEW_RELEASE), 10));
        customer.addRental(new Rental(new Movie("杀破狼", NEW_RELEASE), 10));
        customer.addRental(new Rental(new Movie("熊出没", CHILDRENS), 10));
        customer.addRental(new Rental(new Movie("普通电影——黑狗", REGULAR), 10));

        Assertions.assertTrue(customer.statement().contains("银熊\t30.0"));
        Assertions.assertTrue(customer.statement().contains("杀破狼\t30.0"));
        Assertions.assertTrue(customer.statement().contains("熊出没\t12.0"));
        Assertions.assertTrue(customer.statement().contains("普通电影——黑狗\t14.0"));
        Assertions.assertTrue(customer.statement().contains("You earned 6 frequent renter points"));
        Assertions.assertTrue(customer.statement().contains("Amount owed is 86.0"));
        Assertions.assertTrue(customer.statement().contains("Rental Record for " + customer.getName()));
    }
}
