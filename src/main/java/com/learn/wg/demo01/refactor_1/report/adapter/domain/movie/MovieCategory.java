package com.learn.wg.demo01.refactor_1.report.adapter.domain.movie;

import com.learn.wg.demo01.refactor_1.report.adapter.domain.rentalrule.ChildrenMovieRentalRule;
import com.learn.wg.demo01.refactor_1.report.adapter.domain.rentalrule.MovieRentalRule;
import com.learn.wg.demo01.refactor_1.report.adapter.domain.rentalrule.NewReleaseMovieRentalRule;
import com.learn.wg.demo01.refactor_1.report.adapter.domain.rewardrule.ChildrenMovieRewardPointRule;
import com.learn.wg.demo01.refactor_1.report.adapter.domain.rewardrule.NewReleaseRewardPointRule;
import com.learn.wg.demo01.refactor_1.report.adapter.domain.rewardrule.RegularMovieRentalRule;
import com.learn.wg.demo01.refactor_1.report.adapter.domain.rewardrule.RewardPointRule;

/**
 * @author wanggang
 */
public enum MovieCategory {
    /** 普通电影 */
    REGULAR {
        @Override
        public MovieRentalRule movieRentalRule() {
            return new RegularMovieRentalRule();
        }

        @Override
        public RewardPointRule rewardPointRule() {
            return new ChildrenMovieRewardPointRule();
        }
    },

    /** 新发布的电影 */
    NEW_RELEASE {
        @Override
        public MovieRentalRule movieRentalRule() {
            return new NewReleaseMovieRentalRule();
        }

        @Override
        public RewardPointRule rewardPointRule() {
            return new NewReleaseRewardPointRule();
        }
    },

    /** 儿童分类 */
    CHILDRENS {
        @Override
        public MovieRentalRule movieRentalRule() {
            return new ChildrenMovieRentalRule();
        }

        @Override
        public RewardPointRule rewardPointRule() {
            return new ChildrenMovieRewardPointRule();
        }
    };

    public abstract MovieRentalRule movieRentalRule();

    public abstract RewardPointRule rewardPointRule();
}
