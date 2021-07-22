package com.learn.wg.demo01.refactor_3.calculaterental.interfaces;

import com.learn.wg.demo01.refactor_3.calculaterental.domain.Rental;

import java.util.List;

/**
 * @author wanggang
 */
public interface CustomerRentalQuery {
    /**
     * 获取租赁信息
     * @param customerId
     * @return
     */
    List<Rental> queryAllCustomerRental(String customerId);
}
