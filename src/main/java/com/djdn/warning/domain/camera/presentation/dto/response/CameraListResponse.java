package com.djdn.warning.domain.camera.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CameraListResponse {

    private List<CameraResponse> cameraList;
}
