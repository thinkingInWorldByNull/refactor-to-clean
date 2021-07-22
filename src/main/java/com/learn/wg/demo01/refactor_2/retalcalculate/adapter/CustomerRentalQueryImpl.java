package com.learn.wg.demo01.refactor_2.retalcalculate.adapter;

import com.learn.wg.demo01.refactor_2.retalcalculate.application.CustomerRentalQuery;
import com.learn.wg.demo01.refactor_2.retalcalculate.domain.Rental;
import com.learn.wg.demo01.refactor_2.retalcalculate.domain.movie.ChildrenMovie;
import com.learn.wg.demo01.refactor_2.retalcalculate.domain.movie.NewReleaseMovie;
import com.learn.wg.demo01.refactor_2.retalcalculate.domain.movie.RegularMovie;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wanggang
 */
public class CustomerRentalQueryImpl implements CustomerRentalQuery {
    @Override
    public boolean beExists(String customerId) {
        return true;
    }

    @Override
    public List<Rental> loadCustomerRental(String customerId) {
        List<Rental> memoryRental = new LinkedList<>();

        memoryRental.add(new Rental(new ChildrenMovie("c_1"), 10));
        memoryRental.add(new Rental(new ChildrenMovie("c_3"), 5));
        memoryRental.add(new Rental(new NewReleaseMovie("n_1"), 10));
        memoryRental.add(new Rental(new RegularMovie("r_1"), 10));

        return memoryRental;
    }
}
