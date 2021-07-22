package com.learn.wg.demo01.refactor_1.report.application.input;

import com.learn.wg.demo01.refactor_1.report.domain.CustomerMovieRentalReportDetail;

import java.util.Iterator;

/**
 * @author wanggang
 */
public interface CustomerRentalQuery {
    /**
     * 客户名字
     * @return
     */
    String provideCustomerName();

    /**
     * 租赁信息
     * @return
     */
    Iterator<CustomerMovieRentalReportDetail> provideRentalItemReport();

    /**
     * 总的租赁价格
     * @return
     */
    double provideSumRentalPrice();

    /**
     * 总的积分
     * @return
     */
    int provideSumRentalRewardPoints();
}
