package com.djdn.warning.domain.density.service;

import com.djdn.warning.domain.camera.facade.CameraFacade;
import com.djdn.warning.domain.density.domain.Density;
import com.djdn.warning.domain.density.domain.repository.DensityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateDensityService {

    private final DensityRepository densityRepository;
    private final CameraFacade cameraFacade;

    @Transactional
    public void execute(Long cameraId, int numberOfPeople) {
        densityRepository.save(
                Density.builder()
                        .camera(cameraFacade.getCamera(cameraId))
                        .people(numberOfPeople)
                        .build()
        );
    }
}
