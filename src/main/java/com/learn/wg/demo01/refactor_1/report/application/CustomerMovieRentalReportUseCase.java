package com.learn.wg.demo01.refactor_1.report.application;

import com.learn.wg.demo01.refactor_1.report.domain.Customer;
import com.learn.wg.demo01.refactor_1.report.domain.CustomerMovieRentalReportDetail;

import java.util.Iterator;

/**
 * @author wanggang
 */
public class CustomerMovieRentalReportUseCase {
    public static String customerMovieReport(Customer customer) {
        Iterator<CustomerMovieRentalReportDetail> rentalItemReport = provideRentalItemReport(customer);

        RentalMovieReport rentalMovieReport = new RentalMovieReport();

        rentalMovieReport.addHeadReport(customer.getName());

        while (rentalItemReport.hasNext()) {
            CustomerMovieRentalReportDetail each = rentalItemReport.next();
            rentalMovieReport.addItemReport(each.getMovieName(),
                    each.getRentalPrice());
        }

        rentalMovieReport.addFootReport(customer.sumRentalPrice(), customer.sumRentalRewardPoints());

        return rentalMovieReport.getReportContent();
    }

    private static Iterator<CustomerMovieRentalReportDetail> provideRentalItemReport(Customer customer) {
        return customer.getRentals().stream()
                .map((r) -> new CustomerMovieRentalReportDetail(r.getMovie().getTitle(), r.calculateRentalPrice()))
                .iterator();
    }
}
