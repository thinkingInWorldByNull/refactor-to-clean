package com.learn.wg.demo01.refactor_3.calculaterental.infrastrcture;

import com.learn.wg.demo01.refactor_3.calculaterental.domain.Rental;
import com.learn.wg.demo01.refactor_3.calculaterental.domain.movie.ChildrenMovie;
import com.learn.wg.demo01.refactor_3.calculaterental.domain.movie.NewReleaseMovie;
import com.learn.wg.demo01.refactor_3.calculaterental.domain.movie.RegularMovie;
import com.learn.wg.demo01.refactor_3.calculaterental.interfaces.CustomerRentalQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 获取用户的租赁数据
 * @author wanggang
 */
public class CustomerRentalQueryInMysql implements CustomerRentalQuery {
    @Override
    public List<Rental> queryAllCustomerRental(String customerId) {
        return Collections.emptyList();
    }
}
