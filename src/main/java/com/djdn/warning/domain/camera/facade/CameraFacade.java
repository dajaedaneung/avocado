package com.djdn.warning.domain.camera.facade;


import com.djdn.warning.domain.camera.domain.Camera;
import com.djdn.warning.domain.camera.domain.repository.CameraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CameraFacade {

    private final CameraRepository cameraRepository;

    @Transactional(readOnly = true)
    public Camera getCamera(Long id) {
        return cameraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카메라입니다."));
    }
}
