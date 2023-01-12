package com.djdn.warning.domain.density.domain.repository;

import com.djdn.warning.domain.density.domain.Density;
import com.djdn.warning.global.common.response.GraphResponse;

import java.util.List;

public interface DensityRepositoryCustom {

    List<GraphResponse> findMonthly(Long cameraId);
    List<Density> findDaily(Long cameraId);
}
