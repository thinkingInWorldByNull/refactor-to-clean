package com.learn.wg.demo01.refactor_2.retalcalculate.domain.rentalrule;

/**
 * @author wanggang
 */
public class ChildrenMovieRentalRule implements MovieRentalRule {
    @Override
    public double calculateRentalPrice(double basePrice, int daysRented) {
        double thisAmount = basePrice;

        if (daysRented> 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }

        return thisAmount;
    }
}
