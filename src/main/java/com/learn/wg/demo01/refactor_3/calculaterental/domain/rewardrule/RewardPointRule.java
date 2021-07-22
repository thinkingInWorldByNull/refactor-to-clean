package com.learn.wg.demo01.refactor_3.calculaterental.domain.rewardrule;

/**
 * @author wanggang
 */
public interface RewardPointRule {
    /**
     * 获取租赁天数的奖励点
     * @param daysRented
     * @return
     */
    int rewardPoints(int daysRented);
}
