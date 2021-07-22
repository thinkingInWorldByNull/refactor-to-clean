package com.learn.wg.demo01.refactor_2.retalcalculate.application;

import com.learn.wg.demo01.refactor_2.retalcalculate.domain.CustomerMovieRentalPriceSummarize;
import com.learn.wg.demo01.refactor_2.retalcalculate.exception.BusinessException;

/**
 * @author wanggang
 */
public class MovieRentalCalculateUseCase {
    private final CustomerRentalQuery customerRentalQuery;

    public MovieRentalCalculateUseCase(CustomerRentalQuery customerRentalQuery) {
        this.customerRentalQuery = customerRentalQuery;
    }

    public int sumRentalRewardPoints(String customerId) {
        requireCustomerExists(customerId);

        CustomerMovieRentalPriceSummarize customerMovieRentalPriceSummarize = new CustomerMovieRentalPriceSummarize(customerRentalQuery.loadCustomerRental(customerId));

        return customerMovieRentalPriceSummarize.sumRentalRewardPoints(customerId);
    }

    private void requireCustomerExists(String customerId) {
        if (customerRentalQuery.beExists(customerId)) {
            return;
        }

        throw new BusinessException("customerId error");
    }

    public double sumRentalPrice(String customerId) {
        requireCustomerExists(customerId);

        CustomerMovieRentalPriceSummarize customerMovieRentalPriceSummarize = new CustomerMovieRentalPriceSummarize(customerRentalQuery.loadCustomerRental(customerId));

        return customerMovieRentalPriceSummarize.sumRentalPrice(customerId);
    }
}
