package com.learn.wg.demo01.refactor_1.report.domain.rewardrule;

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
