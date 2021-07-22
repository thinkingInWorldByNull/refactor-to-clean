package com.learn.wg.demo01.refactor_1.report.adapter.output;

import com.learn.wg.demo01.refactor_1.report.adapter.domain.Customer;
import com.learn.wg.demo01.refactor_1.report.application.input.CustomerRentalQuery;
import com.learn.wg.demo01.refactor_1.report.domain.CustomerMovieRentalReportDetail;

import java.util.Iterator;

/**
 * @author wanggang
 */
public class CustomerRentalQueryImpl implements CustomerRentalQuery {
    private final Customer customer;

    public CustomerRentalQueryImpl(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String provideCustomerName() {
        return customer.getName();
    }

    @Override
    public Iterator<CustomerMovieRentalReportDetail> provideRentalItemReport() {
        return customer.getRentals().stream()
                .map((r) -> new CustomerMovieRentalReportDetail(r.getMovie().getTitle(), r.calculateRentalPrice()))
                .iterator();
    }

    @Override
    public double provideSumRentalPrice() {
        return customer.sumRentalPrice();
    }

    @Override
    public int provideSumRentalRewardPoints() {
        return customer.sumRentalRewardPoints();
    }
}
