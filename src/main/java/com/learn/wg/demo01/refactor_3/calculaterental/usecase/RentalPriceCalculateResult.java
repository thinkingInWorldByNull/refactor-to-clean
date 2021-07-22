package com.learn.wg.demo01.refactor_3.calculaterental.usecase;

/**
 * 获取总的租赁价格汇总
 * @author wanggang
 */
public interface RentalPriceCalculateResult {
    /**
     * 获取租赁价格
     * @return
     */
    double allRentalPrice();

    /**
     * 获取租赁获得的奖励点
     * @return
     */
    int allRewardPoints();
}
