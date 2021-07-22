package com.learn.wg.demo01.refactor_1.report.domain.movie;

/**
 * @author wanggang
 */
public abstract class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }
    public abstract MovieCategory category();

    public String getTitle() {
        return title;
    }

    /**
     * 返回电影的基本价格
     * @return
     */
    abstract public double basePrice();
}
