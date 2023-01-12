package com.djdn.warning.domain.density.domain.repository;

import com.djdn.warning.domain.density.domain.repository.vo.GraphVo;
import com.djdn.warning.domain.density.domain.repository.vo.QGraphVo;
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
    public List<GraphVo> findMonthly(Long cameraId) {
        return queryFactory
                .select(new QGraphVo(
                        density.createdAt.dayOfWeek(),
                        density.people.avg()
                ))
                .from(density)
                .groupBy(density.createdAt.dayOfWeek())
                .where(density.camera.id.eq(cameraId))
                .fetch();
    }

    @Override
    public List<GraphVo> findHourly(Long cameraId) {
        return queryFactory
                .select(new QGraphVo(
                        density.createdAt.hour(),
                        density.people.avg()
                ))
                .from(density)
                .groupBy(density.createdAt.hour())
                .where(density.camera.id.eq(cameraId))
                .fetch();
    }
}