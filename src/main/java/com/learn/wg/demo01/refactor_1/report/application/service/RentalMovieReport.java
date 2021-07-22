package com.learn.wg.demo01.refactor_1.report.application.service;

/**
 * @author wanggang
 */
class RentalMovieReport {
    private final StringBuffer description = new StringBuffer(300);

    public void addHeadReport(String customerName) {
        description.append("Rental Record for " + customerName + "\n");
    }

    public void addItemReport(String movieTitle, double rentalPrice) {
        description.append("\t" + movieTitle + "\t" + rentalPrice + "\n");
    }

    public void addFootReport(double allRentalPrice, int rewardPoints) {
        description.append("Amount owed is " + allRentalPrice + "\n");
        description.append("You earned " + rewardPoints + " frequent renter points");
    }

    public String getReportContent() {
        return description.toString();
    }
}
