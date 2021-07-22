package com.learn.wg.demo01.refactor_1.report.domain.movie;

/**
 * @author wanggang
 */
public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public MovieCategory category() {
        return MovieCategory.REGULAR;
    }

    @Override
    public double basePrice() {
        return 2D;
    }
}
