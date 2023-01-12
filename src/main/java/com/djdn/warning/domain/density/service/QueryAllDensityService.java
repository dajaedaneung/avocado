package com.djdn.warning.domain.density.service;

import com.djdn.warning.domain.camera.domain.repository.CameraRepository;
import com.djdn.warning.domain.density.domain.repository.DensityRepository;
import com.djdn.warning.domain.density.presentation.dto.response.DensityListResponse;
import com.djdn.warning.domain.density.presentation.dto.response.DensityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllDensityService {

    private final CameraRepository cameraRepository;
    private final DensityRepository densityRepository;


    public DensityListResponse execute() {
        return new DensityListResponse(
                cameraRepository.findAll().stream()
                        .map(c -> DensityResponse.of(
                                densityRepository.findFirstByCameraIdOrderByCreatedAtDesc(c.getId())))
                        .collect(Collectors.toList())
        );
    }
}
