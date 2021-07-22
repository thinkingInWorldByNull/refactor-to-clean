package com.learn.wg.demo01.refactor_2.report.application.input;

import com.learn.wg.demo01.refactor_2.report.domain.CustomerMovieRentalReportDetail;

import java.util.Iterator;

/**
 * @author wanggang
 */
public interface CustomerRentalReportQuery {
    /**
     * 客户名字
     * @return
     */
    String customerName(String customerId);

    /**
     * 租赁信息
     * @return
     */
    Iterator<CustomerMovieRentalReportDetail> rentalItemReport(String customerId);

    /**
     * 总的租赁价格
     * @return
     */
    double sumRentalPrice(String customerId);

    /**
     * 总的积分
     * @return
     */
    int sumRentalRewardPoints(String customerId);
}
