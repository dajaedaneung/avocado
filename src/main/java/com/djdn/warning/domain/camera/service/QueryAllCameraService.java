package com.djdn.warning.domain.camera.service;

import com.djdn.warning.domain.camera.domain.repository.CameraRepository;
import com.djdn.warning.domain.camera.presentation.dto.response.CameraListResponse;
import com.djdn.warning.domain.camera.presentation.dto.response.CameraResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllCameraService {

    private final CameraRepository cameraRepository;

    public CameraListResponse execute() {
        return new CameraListResponse(
                cameraRepository.findAll().stream()
                        .map(CameraResponse::of)
                        .collect(Collectors.toList())
        );
    }
}
