package com.learn.wg.demo01.refactor_2.retalcalculate.application;

import com.learn.wg.demo01.refactor_2.retalcalculate.domain.Rental;

import java.util.List;

public interface CustomerRentalQuery {
    boolean beExists(String customerId);

    List<Rental> loadCustomerRental(String customerId);
}
