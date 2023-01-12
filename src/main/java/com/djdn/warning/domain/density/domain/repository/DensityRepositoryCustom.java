package com.djdn.warning.domain.density.domain.repository;

import com.djdn.warning.domain.density.domain.repository.vo.GraphVo;

import java.util.List;

public interface DensityRepositoryCustom {

    List<GraphVo> findMonthly(Long cameraId);
    List<GraphVo> findHourly(Long cameraId);
}

