package com.learn.wg.demo01.refactor_3.generatereport.infrastrcture;

import com.learn.wg.demo01.refactor_3.calculaterental.domain.Rental;
import com.learn.wg.demo01.refactor_3.calculaterental.infrastrcture.CustomerRentalQueryInMemory;
import com.learn.wg.demo01.refactor_3.calculaterental.usecase.RentalPriceCalculateResult;
import com.learn.wg.demo01.refactor_3.calculaterental.usecase.RentalPriceCalculateUseCase;
import com.learn.wg.demo01.refactor_3.generatereport.domain.MovieRentalItemDescription;
import com.learn.wg.demo01.refactor_3.generatereport.inerfaces.CustomerRentalReportQuery;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanggang
 */
public class CustomerRentalReportQueryInMemory implements CustomerRentalReportQuery {
    private final RentalPriceCalculateUseCase rentalPriceCalculateUseCase;
    private final CustomerRentalQueryInMemory customerRentalQueryInMemory;

    public CustomerRentalReportQueryInMemory(RentalPriceCalculateUseCase rentalPriceCalculateUseCase,
                                             CustomerRentalQueryInMemory customerRentalQueryInMemory) {
        this.rentalPriceCalculateUseCase = rentalPriceCalculateUseCase;
        this.customerRentalQueryInMemory = customerRentalQueryInMemory;
    }

    @Override
    public RentalPriceCalculateResult getRentalPriceCalculateResult(String customerId) {
        return rentalPriceCalculateUseCase.calculateRentalPrice(customerId);
    }

    @Override
    public List<MovieRentalItemDescription> loadCustomerRental(String customerId) {
        List<Rental> rentals = customerRentalQueryInMemory.queryAllCustomerRental(customerId);
        return rentals.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private MovieRentalItemDescription convert(Rental r) {
        return new MovieRentalItemDescription(r.getMovie().getTitle(), r.calculateRentalPrice());
    }
}
