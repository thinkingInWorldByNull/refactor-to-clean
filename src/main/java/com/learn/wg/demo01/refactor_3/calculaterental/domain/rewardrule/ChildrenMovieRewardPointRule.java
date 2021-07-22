package com.learn.wg.demo01.refactor_3.calculaterental.domain.rewardrule;

/**
 * @author wanggang
 */
public class ChildrenMovieRewardPointRule implements RewardPointRule {

    @Override
    public int rewardPoints(int daysRented) {
        return 1;
    }
}
