package com.djdn.warning.domain.camera.presentation.dto.response;

import com.djdn.warning.domain.camera.domain.Camera;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CameraResponse {

    private Long id;
    private String place;

    public static CameraResponse of(Camera camera) {
        return new CameraResponse(
                camera.getId(),
                camera.getPlace()
        );
    }
}
