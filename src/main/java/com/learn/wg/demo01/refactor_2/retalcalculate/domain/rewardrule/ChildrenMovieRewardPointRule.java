package com.learn.wg.demo01.refactor_2.retalcalculate.domain.rewardrule;

/**
 * @author wanggang
 */
public class ChildrenMovieRewardPointRule implements RewardPointRule {

    @Override
    public int rewardPoints(int daysRented) {
        return 1;
    }
}
