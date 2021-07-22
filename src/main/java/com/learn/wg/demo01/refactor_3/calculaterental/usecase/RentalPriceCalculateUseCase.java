package com.learn.wg.demo01.refactor_3.calculaterental.usecase;

import com.learn.wg.demo01.refactor_3.calculaterental.interfaces.CustomerRentalQuery;

/**
 * 计算电影租赁价格的案例 —— 是通向领域的逻辑的门户
 * @author wanggang
 */
public class RentalPriceCalculateUseCase {
    private final CustomerRentalQuery customerRentalQuery;

    public RentalPriceCalculateUseCase(CustomerRentalQuery customerRentalQuery) {
        this.customerRentalQuery = customerRentalQuery;
    }

    public RentalPriceCalculateResult calculateRentalPrice(String customerId) {
        return MovieRentalPriceCalculate.calculateRentalPrice(
                customerRentalQuery.queryAllCustomerRental(customerId)
        );
    }
}
