package com.djdn.warning.domain.density.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GraphVo {

    private int x;
    private double y;

    @QueryProjection
    public GraphVo(int x, double y) {
        this.x = x;
        this.y = y;
    }
}