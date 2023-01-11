package com.djdn.warning.domain.density.presentation;

import com.djdn.warning.domain.density.service.CreateDensityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/density")
@RequiredArgsConstructor
public class DensityController {

    private final CreateDensityService createDensityService;

    @PostMapping
    public void createDensity(
            @RequestParam(name = "camera") Long cameraId,
            @RequestParam(name = "people") int numberOfPeople
    ) {
        createDensityService.execute(cameraId, numberOfPeople);
    }
}
