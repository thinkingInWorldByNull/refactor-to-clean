package com.learn.wg.demo01.refactor_3.calculaterental.infrastrcture;

import com.learn.wg.demo01.refactor_3.calculaterental.domain.Rental;
import com.learn.wg.demo01.refactor_3.calculaterental.domain.movie.ChildrenMovie;
import com.learn.wg.demo01.refactor_3.calculaterental.domain.movie.NewReleaseMovie;
import com.learn.wg.demo01.refactor_3.calculaterental.domain.movie.RegularMovie;
import com.learn.wg.demo01.refactor_3.calculaterental.interfaces.CustomerRentalQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取用户的租赁数据
 * @author wanggang
 */
public class CustomerRentalQueryInMemory implements CustomerRentalQuery {
    @Override
    public List<Rental> queryAllCustomerRental(String customerId) {
        List<Rental> rentalList = new ArrayList<>();

        rentalList.add(new Rental(new NewReleaseMovie("银熊"), 10));
        rentalList.add(new Rental(new NewReleaseMovie("杀破狼"), 10));
        rentalList.add(new Rental(new ChildrenMovie("熊出没"), 10));
        rentalList.add(new Rental(new RegularMovie("普通电影——黑狗"), 10));

        return rentalList;
    }
}
