package com.learn.wg.demo01.refactor_1.report.adapter.domain;

import com.learn.wg.demo01.refactor_1.report.adapter.domain.movie.Movie;

public class Rental {
    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double calculateRentalPrice() {
        return movie.category().movieRentalRule()
                .calculateRentalPrice(movie.basePrice(), getDaysRented());
    }

    /**
     * 不能作为全局变量：否则会因为调用多测而导致问题
     * @return
     */
    public int getRewardPoints() {
        return movie.category().rewardPointRule().rewardPoints(getDaysRented());
    }
}
