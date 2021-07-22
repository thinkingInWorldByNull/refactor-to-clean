package com.learn.wg.demo01.refactor_1.report.domain.rewardrule;

/**
 * @author wanggang
 */
public class ChildrenMovieRewardPointRule implements RewardPointRule {

    @Override
    public int rewardPoints(int daysRented) {
        return 1;
    }
}
