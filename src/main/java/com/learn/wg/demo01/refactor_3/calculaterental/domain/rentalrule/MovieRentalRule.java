package com.learn.wg.demo01.refactor_3.calculaterental.domain.rentalrule;

/**
 * @author wanggang
 */
public interface MovieRentalRule {
    /**
     * 计算电影费用
     * @param basePrice
     * @param daysRented
     * @return 返回最终的而价格
     */
    double calculateRentalPrice(double basePrice, int daysRented);
}
