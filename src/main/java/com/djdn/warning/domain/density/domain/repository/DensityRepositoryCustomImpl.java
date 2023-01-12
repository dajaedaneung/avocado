package com.djdn.warning.domain.density.domain.repository;

import com.djdn.warning.domain.density.domain.Density;
import com.djdn.warning.global.common.response.GraphResponse;
import com.djdn.warning.global.common.response.QGraphResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.djdn.warning.domain.density.domain.QDensity.density;

@Repository
@RequiredArgsConstructor
public class DensityRepositoryCustomImpl implements DensityRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<GraphResponse> findMonthly(Long cameraId) {
        return queryFactory
                .select(new QGraphResponse(
                        density.createdAt.dayOfWeek().stringValue(),
                        density.people.avg()
                ))
                .from(density)
                .groupBy(density.createdAt.dayOfWeek())
                .where(density.camera.id.eq(cameraId))
                .fetch();
    }

    @Override
    public List<Density> findDaily(Long cameraId) {
        return null;
    }
}
