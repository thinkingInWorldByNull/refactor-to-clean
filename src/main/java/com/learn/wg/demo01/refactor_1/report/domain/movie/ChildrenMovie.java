package com.learn.wg.demo01.refactor_1.report.domain.movie;

/**
 * @author wanggang
 */
public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public MovieCategory category() {
        return MovieCategory.CHILDRENS;
    }

    @Override
    public double basePrice() {
        return 1.5D;
    }
}
