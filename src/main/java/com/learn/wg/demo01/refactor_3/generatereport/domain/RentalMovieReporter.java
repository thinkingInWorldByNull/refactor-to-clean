package com.learn.wg.demo01.refactor_3.generatereport.domain;

import java.util.List;

/**
 * @author wanggang
 */
public interface RentalMovieReporter {
    /**
     * 增加头信息
     * @param customerName
     */
    void addHeadReport(String customerName);

    /**
     * 增加明细信息
     * @param itemDescription
     */
    void addItemReport(List<MovieRentalItemDescription> movieRentalItemDescriptions);

    /**
     * 增加脚注
     * @param allRentalPrice
     * @param rewardPoints
     */
    void addFootReport(double allRentalPrice, int rewardPoints);

    /**
     * 获取内容
     * @return 报表
     */
    String getReportContent();
}
