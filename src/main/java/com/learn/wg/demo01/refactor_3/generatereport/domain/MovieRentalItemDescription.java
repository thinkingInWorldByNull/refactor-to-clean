package com.learn.wg.demo01.refactor_3.generatereport.domain;

/**
 * @author wanggang
 */
public class MovieRentalItemDescription {
    private final String movieName;

    private final double rentalPrice;

    public MovieRentalItemDescription(String movieName, double rentalPrice) {
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
