package com.learn.wg.demo01.refactor_3.generatereport.domain;

import java.util.List;

/**
 * @author wanggang
 */
public class RentalMovieReportPrint implements RentalMovieReporter {
    private final StringBuffer description = new StringBuffer(300);

    @Override
    public void addHeadReport(String customerName) {
        description.append("Rental Record for " + customerName + "\n");
    }

    @Override
    public void addItemReport(List<MovieRentalItemDescription> rentalItemDescriptions) {
        for (MovieRentalItemDescription itemDescription : rentalItemDescriptions) {
            description.append("\t" + itemDescription.getMovieName() + "\t" + itemDescription.getRentalPrice() + "\n");
        }
    }

    @Override
    public void addFootReport(double allRentalPrice, int rewardPoints) {
        description.append("Amount owed is " + allRentalPrice + "\n");
        description.append("You earned " + rewardPoints + " frequent renter points");
    }

    @Override
    public String getReportContent() {
        return description.toString();
    }
}
