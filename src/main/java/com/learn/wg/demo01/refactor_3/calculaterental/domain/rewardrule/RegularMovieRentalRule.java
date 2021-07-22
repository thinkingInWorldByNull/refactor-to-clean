package com.learn.wg.demo01.refactor_3.calculaterental.domain.rewardrule;

import com.learn.wg.demo01.refactor_3.calculaterental.domain.rentalrule.MovieRentalRule;

/**
 * @author wanggang
 */
public class RegularMovieRentalRule implements MovieRentalRule {
    @Override
    public double calculateRentalPrice(double basePrice, int daysRented) {
        double thisAmount = basePrice;

        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }

        return thisAmount;
    }
}
