package com.djdn.warning.global.common.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GraphResponse {

    private String x;
    private double y;

    @QueryProjection
    public GraphResponse(String x, double y) {
        this.x = x;
        this.y = y;
    }
}