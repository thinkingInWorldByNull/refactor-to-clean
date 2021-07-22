package com.learn.wg.demo01.refactor_1.report.domain.rewardrule;

/**
 * @author wanggang
 */
public class NewReleaseRewardPointRule implements RewardPointRule {
    @Override
    public int rewardPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
