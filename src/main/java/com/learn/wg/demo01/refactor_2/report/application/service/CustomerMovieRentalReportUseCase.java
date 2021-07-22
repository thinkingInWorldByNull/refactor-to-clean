package com.learn.wg.demo01.refactor_2.report.application.service;

import com.learn.wg.demo01.refactor_2.report.application.input.CustomerRentalReportQuery;
import com.learn.wg.demo01.refactor_2.report.domain.CustomerMovieRentalReportDetail;

import java.util.Iterator;


/**
 * @author wanggang
 */
public class CustomerMovieRentalReportUseCase {
    private final CustomerRentalReportQuery customerRentalReportQuery;

    public CustomerMovieRentalReportUseCase(CustomerRentalReportQuery customerRentalReportQuery) {
        this.customerRentalReportQuery = customerRentalReportQuery;
    }

    public String customerMovieReport(String customerId) {
        Iterator<CustomerMovieRentalReportDetail> rentalItemReport = customerRentalReportQuery.rentalItemReport(customerId);

        RentalMovieReport rentalMovieReport = new RentalMovieReport();

        rentalMovieReport.addHeadReport(customerRentalReportQuery.customerName(customerId));

        while (rentalItemReport.hasNext()) {
            CustomerMovieRentalReportDetail each = rentalItemReport.next();
            rentalMovieReport.addItemReport(each.getMovieName(),
                    each.getRentalPrice());
        }

        rentalMovieReport.addFootReport(customerRentalReportQuery.sumRentalPrice(customerId),
                customerRentalReportQuery.sumRentalRewardPoints(customerId));

        return rentalMovieReport.getReportContent();
    }
}
