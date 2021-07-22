package com.learn.wg.demo01.refactor_2.report.domain;

/**
 * @author wanggang
 */
public class CustomerMovieRentalReportDetail {
    private final String movieName;

    private final double rentalPrice;

    public CustomerMovieRentalReportDetail(String movieName, double rentalPrice) {
        this.movieName = movieName;
        this.rentalPrice = rentalPrice;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }
}
