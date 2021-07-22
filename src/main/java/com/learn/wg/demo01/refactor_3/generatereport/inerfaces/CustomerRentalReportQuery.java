package com.learn.wg.demo01.refactor_3.generatereport.inerfaces;

import com.learn.wg.demo01.refactor_3.calculaterental.usecase.RentalPriceCalculateResult;
import com.learn.wg.demo01.refactor_3.generatereport.domain.MovieRentalItemDescription;

import java.util.List;

public interface CustomerRentalReportQuery {
    RentalPriceCalculateResult getRentalPriceCalculateResult(String customerId);

    List<MovieRentalItemDescription> loadCustomerRental(String customerId);
}
