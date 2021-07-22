package com.learn.wg.demo01.refactor_2.retalcalculate.domain.movie;

/**
 * @author wanggang
 */
public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public MovieCategory category() {
        return MovieCategory.NEW_RELEASE;
    }

    @Override
    public double basePrice() {
        return 0D;
    }
}
