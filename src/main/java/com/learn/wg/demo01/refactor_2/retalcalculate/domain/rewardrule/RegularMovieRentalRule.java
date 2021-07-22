package com.learn.wg.demo01.refactor_2.retalcalculate.domain.rewardrule;

import com.learn.wg.demo01.refactor_2.retalcalculate.domain.rentalrule.MovieRentalRule;

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
