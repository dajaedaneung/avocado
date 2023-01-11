package com.djdn.warning.domain.density.presentation;

import com.djdn.warning.domain.density.domain.repository.DensityRepository;
import com.djdn.warning.domain.density.presentation.dto.response.DensityResponse;
import com.djdn.warning.domain.density.service.CreateDensityService;
import com.djdn.warning.domain.density.service.QueryDensityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/density")
@RequiredArgsConstructor
public class DensityController {

    private final CreateDensityService createDensityService;
    private final QueryDensityService queryDensityService;

    @GetMapping("/now")
    public DensityResponse getDensity(@RequestParam(name = "camera") Long cameraId) {
        return queryDensityService.execute(cameraId);
    }

    @PostMapping
    public void createDensity(
            @RequestParam(name = "camera") Long cameraId,
            @RequestParam(name = "people") int numberOfPeople
    ) {
        createDensityService.execute(cameraId, numberOfPeople);
    }
}
