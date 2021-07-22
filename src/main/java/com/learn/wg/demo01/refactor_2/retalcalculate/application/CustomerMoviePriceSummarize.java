package com.learn.wg.demo01.refactor_2.retalcalculate.application;

import com.learn.wg.demo01.refactor_2.report.domain.CustomerMovieRentalReportDetail;

import java.util.Iterator;

/**
 * @author wanggang
 */
public interface CustomerMoviePriceSummarize {
    /**
     * 计算总的奖励点
     * @return
     */
    int sumRentalRewardPoints(String customerId);

    /**
     * 明细信息
     * @return
     */
    Iterator<CustomerMovieRentalReportDetail> rentalItemReport(String customerId);

    /**
     * 计算总的租金
     * @return
     */
    double sumRentalPrice(String customerId);
}
