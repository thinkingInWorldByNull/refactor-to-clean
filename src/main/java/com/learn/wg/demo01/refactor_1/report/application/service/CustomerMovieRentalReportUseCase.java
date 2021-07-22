package com.learn.wg.demo01.refactor_1.report.application.service;

import com.learn.wg.demo01.refactor_1.report.application.input.CustomerRentalQuery;
import com.learn.wg.demo01.refactor_1.report.domain.CustomerMovieRentalReportDetail;

import java.util.Iterator;

/**
 * @author wanggang
 */
public class CustomerMovieRentalReportUseCase {
    public static String customerMovieReport(CustomerRentalQuery customerRentalQuery) {
        Iterator<CustomerMovieRentalReportDetail> rentalItemReport = customerRentalQuery.provideRentalItemReport();

        RentalMovieReport rentalMovieReport = new RentalMovieReport();

        rentalMovieReport.addHeadReport(customerRentalQuery.provideCustomerName());

        while (rentalItemReport.hasNext()) {
            CustomerMovieRentalReportDetail each = rentalItemReport.next();
            rentalMovieReport.addItemReport(each.getMovieName(),
                    each.getRentalPrice());
        }

        rentalMovieReport.addFootReport(customerRentalQuery.provideSumRentalPrice(), customerRentalQuery.provideSumRentalRewardPoints());

        return rentalMovieReport.getReportContent();
    }
}
