package com.djdn.warning.domain.density.service;

import com.djdn.warning.domain.density.domain.repository.DensityRepository;
import com.djdn.warning.domain.density.presentation.dto.response.DensityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryDensityService {

    private final DensityRepository densityRepository;

    @Transactional(readOnly = true)
    public DensityResponse execute(Long cameraId) {
        return DensityResponse.of(
                densityRepository.findFirstByCameraIdOrderByCreatedAtDesc(Long.valueOf(cameraId))
        );
    }
}
