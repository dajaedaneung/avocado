package com.djdn.warning.domain.density.service;

import com.djdn.warning.domain.density.domain.repository.DensityRepository;
import com.djdn.warning.domain.density.presentation.dto.type.Criteria;
import com.djdn.warning.global.common.response.GraphResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryStarDensityService {

    private final DensityRepository densityRepository;

    public List<GraphResponse> execute(Long cameraId, Criteria criteria) {
        if (criteria.equals(Criteria.MONTH)) {
            return densityRepository.findMonthly(cameraId);
        }


        if (criteria.equals(Criteria.DAY)) {
            return getDailyData(cameraId);
        }

        return null;
    }

    private List<GraphResponse> getDailyData(Long cameraId) {
        return null;
    }
}
