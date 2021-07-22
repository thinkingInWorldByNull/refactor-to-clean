package com.learn.wg.demo01.refactor_1.report.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wanggang
 */
public class Customer {
    private String name;
    private List<Rental> rentals = new LinkedList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return Collections.unmodifiableList(rentals);
    }

    public int sumRentalRewardPoints() {
        int rewardPoints = 0;
        Iterator<Rental> iterator = rentals.iterator();

        while (iterator.hasNext()) {
            rewardPoints += iterator.next().getRewardPoints();
        }

        return rewardPoints;
    }

    public double sumRentalPrice() {
        double totalAmount = 0D;
        Iterator<Rental> iterator = rentals.iterator();

        while (iterator.hasNext()) {
            totalAmount += iterator.next().calculateRentalPrice();
        }

        return totalAmount;
    }
}
