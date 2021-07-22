package com.learn.wg.demo01.refactor_2.retalcalculate.domain;

import com.learn.wg.demo01.refactor_2.report.domain.CustomerMovieRentalReportDetail;
import com.learn.wg.demo01.refactor_2.retalcalculate.application.CustomerMoviePriceSummarize;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author wanggang
 */
public class CustomerMovieRentalPriceSummarize implements CustomerMoviePriceSummarize {
    private final List<Rental> rentals;

    public CustomerMovieRentalPriceSummarize(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals(String customerId) {
        return Collections.unmodifiableList(rentals);
    }

    @Override
    public Iterator<CustomerMovieRentalReportDetail> rentalItemReport(String customerId) {
        return rentals.stream()
                .map((r) -> new CustomerMovieRentalReportDetail(r.getMovie().getTitle(), r.calculateRentalPrice()))
                .iterator();
    }

    @Override
    public int sumRentalRewardPoints(String customerId) {
        int rewardPoints = 0;
        Iterator<Rental> iterator = rentals.iterator();

        while (iterator.hasNext()) {
            rewardPoints += iterator.next().getRewardPoints();
        }

        return rewardPoints;
    }

    @Override
    public double sumRentalPrice(String customerId) {
        double totalAmount = 0D;
        Iterator<Rental> iterator = rentals.iterator();

        while (iterator.hasNext()) {
            totalAmount += iterator.next().calculateRentalPrice();
        }

        return totalAmount;
    }
}
