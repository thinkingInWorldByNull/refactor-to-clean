package com.learn.wg.demo01;

import com.learn.wg.demo01.refactor_1.report.domain.Customer;
import com.learn.wg.demo01.refactor_1.report.domain.Rental;
import com.learn.wg.demo01.refactor_1.report.domain.movie.*;
import com.learn.wg.demo01.refactor_1.report.application.CustomerMovieRentalReportUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerRefactorDemo1Test {
    /**
     * <pre>
     * Rental Record for Bob
     * 	银熊	30.0
     * 	杀破狼	30.0
     * 	熊出没	12.0
     * 	普通电影——黑狗	14.0
     * Amount owed is 86.0
     * You earned 6 frequent renter points
     * </pre>
     */
    @Test
    public void test_statement() {
        Customer customer = new Customer("Bob");

        customer.addRental(new Rental(new NewReleaseMovie("银熊"), 10));
        customer.addRental(new Rental(new NewReleaseMovie("杀破狼"), 10));
        customer.addRental(new Rental(new ChildrenMovie("熊出没"), 10));
        customer.addRental(new Rental(new RegularMovie("普通电影——黑狗"), 10));

        String customerMovieReport = CustomerMovieRentalReportUseCase.customerMovieReport(customer);

        Assertions.assertTrue(customerMovieReport.contains("银熊\t30.0"));
        Assertions.assertTrue(customerMovieReport.contains("杀破狼\t30.0"));
        Assertions.assertTrue(customerMovieReport.contains("熊出没\t12.0"));
        Assertions.assertTrue(customerMovieReport.contains("普通电影——黑狗\t14.0"));

        Assertions.assertTrue(customerMovieReport.contains("Amount owed is 86.0"));
        Assertions.assertTrue(customerMovieReport.contains("You earned 6 frequent renter points"));
        Assertions.assertTrue(customerMovieReport.contains("Rental Record for " + customer.getName()));
    }
}
