package com.learn.wg.demo01.refactor_3.generatereport.usecase;

import com.learn.wg.demo01.refactor_3.calculaterental.usecase.RentalPriceCalculateResult;
import com.learn.wg.demo01.refactor_3.generatereport.domain.MovieRentalItemDescription;
import com.learn.wg.demo01.refactor_3.generatereport.domain.RentalMovieReportConsolePrint;
import com.learn.wg.demo01.refactor_3.generatereport.interfaces.CustomerNameQuery;
import com.learn.wg.demo01.refactor_3.generatereport.interfaces.CustomerRentalReportQuery;

import java.util.List;

/**
 * @author wanggang
 */
public class RentalPriceReportGenerateUseCase {
    private final CustomerRentalReportQuery rentalReportQuery;
    private final CustomerNameQuery customerNameQuery;

    public RentalPriceReportGenerateUseCase(CustomerRentalReportQuery rentalReportQuery,
                                            CustomerNameQuery customerNameQuery) {
        this.rentalReportQuery = rentalReportQuery;
        this.customerNameQuery = customerNameQuery;
    }

    public String generateReport(String customerId) {
        String customerName = customerNameQuery.findCustomerNameById(customerId);

        RentalPriceCalculateResult allCustomerRental = rentalReportQuery.getRentalPriceCalculateResult(customerId);
        List<MovieRentalItemDescription> rentalItemDescriptions = rentalReportQuery.loadCustomerRental(customerId);

        return generateReport(customerName,allCustomerRental, rentalItemDescriptions);
    }

    private String generateReport(String customerName,
                                  RentalPriceCalculateResult reportCalResult,
                                  List<MovieRentalItemDescription> rentalItemDescriptions) {
        RentalMovieReportConsolePrint rentalMovieReport = new RentalMovieReportConsolePrint();

        rentalMovieReport.addHeadReport(customerName);
        rentalMovieReport.addItemReport(rentalItemDescriptions);
        rentalMovieReport.addFootReport(reportCalResult.allRentalPrice(), reportCalResult.allRewardPoints());

        return rentalMovieReport.getReportContent();
    }
}
