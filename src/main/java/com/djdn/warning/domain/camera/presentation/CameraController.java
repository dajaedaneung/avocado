package com.djdn.warning.domain.camera.presentation;

import com.djdn.warning.domain.camera.presentation.dto.response.CameraListResponse;
import com.djdn.warning.domain.camera.service.QueryAllCameraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camera")
@RequiredArgsConstructor
public class CameraController {

    private final QueryAllCameraService queryAllCameraService;

    @GetMapping("/all")
    public CameraListResponse getAllCamera() {
        return queryAllCameraService.execute();
    }
}
