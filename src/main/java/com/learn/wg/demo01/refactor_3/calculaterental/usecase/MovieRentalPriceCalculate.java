package com.learn.wg.demo01.refactor_3.calculaterental.usecase;

import com.learn.wg.demo01.refactor_3.calculaterental.domain.Rental;

import java.util.List;
import java.util.Objects;

/**
 * 计算租赁价格信息
 * @author wanggang
 */
class MovieRentalPriceCalculate {
    private MovieRentalPriceCalculate() {
    }

    static RentalPriceCalculateResult calculateRentalPrice(List<Rental> allCustomerRental) {
        if (Objects.isNull(allCustomerRental) || allCustomerRental.isEmpty()) {
            return RentalPriceCalculateResultDto.DEFAULT;
        }

        double allRentalPrice = 0D;
        int allRewardPoints = 0;

        for (Rental rental : allCustomerRental) {
            allRentalPrice += rental.calculateRentalPrice();
            allRewardPoints += rental.getRewardPoints();
        }

        return new RentalPriceCalculateResultDto(allRentalPrice, allRewardPoints);
    }

    private static class RentalPriceCalculateResultDto
            implements RentalPriceCalculateResult {
        private final double allRentalPrice;
        private final int allRewardPoints;

        private static final RentalPriceCalculateResultDto DEFAULT
                = new RentalPriceCalculateResultDto(0D,0);

        public RentalPriceCalculateResultDto(double allRentalPrice, int allRewardPoints) {
            this.allRentalPrice = allRentalPrice;
            this.allRewardPoints = allRewardPoints;
        }

        @Override
        public double allRentalPrice() {
            return allRentalPrice;
        }

        @Override
        public int allRewardPoints() {
            return allRewardPoints;
        }
    }
}
