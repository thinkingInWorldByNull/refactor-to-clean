package com.learn.wg.demo01.refactor_3.generatereport.infrastrcture;

import com.learn.wg.demo01.refactor_2.report.adapter.output.CustomerNameQuery;

/**
 * @author wanggang
 */
public class CustomerNameQueryInFixed implements CustomerNameQuery {
    @Override
    public String queryCustomerName(String customerId) {
        return "Bob";
    }
}
