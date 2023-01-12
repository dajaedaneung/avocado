package com.djdn.warning.domain.density.service;

import com.djdn.warning.domain.density.domain.repository.DensityRepository;
import com.djdn.warning.domain.density.domain.repository.vo.GraphVo;
import com.djdn.warning.domain.density.presentation.dto.type.Criteria;
import com.djdn.warning.global.common.response.GraphResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryStarDensityService {

    private final DensityRepository densityRepository;

    public List<GraphResponse> execute(Long cameraId, Criteria criteria) {
        if (criteria.equals(Criteria.MONTH)) {
            return densityRepository.findMonthly(cameraId).stream()
                    .map(this::createGraphResponseFromMonthly)
                    .collect(Collectors.toList());
        }


        if (criteria.equals(Criteria.HOUR)) {
            return densityRepository.findHourly(cameraId).stream()
                    .map(this::createGraphResponseFrom)
                    .collect(Collectors.toList());
        }

        return null;
    }

    private GraphResponse createGraphResponseFromMonthly(GraphVo vo) {
        return new GraphResponse(
                DayOfWeek.of(vo.getX()).getDisplayName(TextStyle.SHORT, Locale.KOREAN),
                vo.getY()
        );
    }

    private GraphResponse createGraphResponseFrom(GraphVo vo) {
        return new GraphResponse(
                String.valueOf(vo.getX()),
                vo.getY()
        );
    }
}
