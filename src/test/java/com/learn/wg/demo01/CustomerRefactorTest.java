package com.learn.wg.demo01;

import com.learn.wg.demo01.refactor_2.report.adapter.output.CustomerNameQuery;
import com.learn.wg.demo01.refactor_2.report.adapter.output.CustomerRentalReportQueryImpl;
import com.learn.wg.demo01.refactor_2.report.application.input.CustomerRentalReportQuery;
import com.learn.wg.demo01.refactor_2.retalcalculate.adapter.CustomerRentalQueryImpl;
import com.learn.wg.demo01.refactor_2.report.application.service.CustomerMovieRentalReportUseCase;
import com.learn.wg.demo01.refactor_2.retalcalculate.application.CustomerRentalQuery;
import com.learn.wg.demo01.refactor_2.retalcalculate.application.MovieRentalCalculateUseCase;
import com.learn.wg.demo01.refactor_2.retalcalculate.domain.CustomerMovieRentalPriceSummarize;
import com.learn.wg.demo01.refactor_2.retalcalculate.domain.Rental;
import com.learn.wg.demo01.refactor_2.retalcalculate.domain.movie.ChildrenMovie;
import com.learn.wg.demo01.refactor_2.retalcalculate.domain.movie.NewReleaseMovie;
import com.learn.wg.demo01.refactor_2.retalcalculate.domain.movie.RegularMovie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerRefactorTest {
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
    public void test_rentalPriceCalculate() {
        CustomerRentalQuery customerRentalQuery = new CustomerRentalQueryImpl();
        MovieRentalCalculateUseCase calculateUseCase = new MovieRentalCalculateUseCase(customerRentalQuery);
        Assertions.assertEquals(5, calculateUseCase.sumRentalRewardPoints("bob"));
        Assertions.assertEquals(60.5, calculateUseCase.sumRentalPrice("bob"));
    }

    @Test
    public void test_rentalPriceReport() {
        CustomerRentalReportQuery reportQuery = mockReportQuery();
        CustomerMovieRentalReportUseCase rentalReportUseCase = new CustomerMovieRentalReportUseCase(reportQuery);

        String customerMovieReport = rentalReportUseCase.customerMovieReport("");
        Assertions.assertTrue(customerMovieReport.contains("银熊\t30.0"));
        Assertions.assertTrue(customerMovieReport.contains("杀破狼\t30.0"));
        Assertions.assertTrue(customerMovieReport.contains("熊出没\t12.0"));
        Assertions.assertTrue(customerMovieReport.contains("普通电影——黑狗\t14.0"));

        Assertions.assertTrue(customerMovieReport.contains("Amount owed is 86.0"));
        Assertions.assertTrue(customerMovieReport.contains("You earned 6 frequent renter points"));
    }

    private CustomerRentalReportQuery mockReportQuery() {
        CustomerNameQuery customerNameQuery = new CustomerNameQuery() {
            @Override
            public String queryCustomerName(String customerId) {
                return "Tester";
            }
        };
        List<Rental> rentalList = new ArrayList<>();

        rentalList.add(new Rental(new NewReleaseMovie("银熊"), 10));
        rentalList.add(new Rental(new NewReleaseMovie("杀破狼"), 10));
        rentalList.add(new Rental(new ChildrenMovie("熊出没"), 10));
        rentalList.add(new Rental(new RegularMovie("普通电影——黑狗"), 10));

        CustomerMovieRentalPriceSummarize priceSummarize = new CustomerMovieRentalPriceSummarize(rentalList);
        CustomerRentalReportQuery customerRentalQuery = new CustomerRentalReportQueryImpl(priceSummarize, customerNameQuery);

        return customerRentalQuery;
    }
}
