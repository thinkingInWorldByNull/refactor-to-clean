package com.learn.wg.demo01.refactor_2.report.adapter.output;

import com.learn.wg.demo01.refactor_2.report.application.input.CustomerRentalReportQuery;
import com.learn.wg.demo01.refactor_2.report.domain.CustomerMovieRentalReportDetail;
import com.learn.wg.demo01.refactor_2.retalcalculate.application.CustomerMoviePriceSummarize;

import java.util.Iterator;

/**
 * @author wanggang
 */
public class CustomerRentalReportQueryImpl implements CustomerRentalReportQuery {
    private final CustomerMoviePriceSummarize customerMoviePriceSummarize;
    private final CustomerNameQuery customerNameQuery;

    public CustomerRentalReportQueryImpl(CustomerMoviePriceSummarize customerMoviePriceSummarize,
                                         CustomerNameQuery customerNameQuery) {
        this.customerMoviePriceSummarize = customerMoviePriceSummarize;
        this.customerNameQuery = customerNameQuery;
    }

    @Override
    public String customerName(String customerId) {
        return customerNameQuery.queryCustomerName(customerId);
    }

    @Override
    public Iterator<CustomerMovieRentalReportDetail> rentalItemReport(String customerId) {
        return customerMoviePriceSummarize.rentalItemReport(customerId);
    }

    @Override
    public double sumRentalPrice(String customerId) {
        return customerMoviePriceSummarize.sumRentalPrice(customerId);
    }

    @Override
    public int sumRentalRewardPoints(String customerId) {
        return customerMoviePriceSummarize.sumRentalRewardPoints(customerId);
    }
}
