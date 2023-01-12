package com.djdn.warning.domain.density.presentation;

import com.djdn.warning.domain.density.presentation.dto.response.DensityListResponse;
import com.djdn.warning.domain.density.presentation.dto.response.DensityResponse;
import com.djdn.warning.domain.density.presentation.dto.type.Criteria;
import com.djdn.warning.domain.density.service.CreateDensityService;
import com.djdn.warning.domain.density.service.QueryAllDensityService;
import com.djdn.warning.domain.density.service.QueryDensityService;
import com.djdn.warning.domain.density.service.QueryStarDensityService;
import com.djdn.warning.global.common.response.GraphResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/density")
@RequiredArgsConstructor
@Slf4j
public class DensityController {

    private final CreateDensityService createDensityService;
    private final QueryDensityService queryDensityService;
    private final QueryStarDensityService queryStarDensityService;
    private final QueryAllDensityService queryAllDensityService;

    @GetMapping
    public List<GraphResponse> getStarDensity(
            @RequestParam(name = "camera") Long cameraId,
            @RequestParam(name = "criteria") Criteria criteria
    ) {
        return queryStarDensityService.execute(cameraId, criteria);
    }

    @GetMapping("/now")
    public DensityResponse getDensity(@RequestParam(name = "camera") Long cameraId) {
        return queryDensityService.execute(cameraId);
    }

    @GetMapping("/all")
    public DensityListResponse getAllDensity() {
        return queryAllDensityService.execute();
    }

    @PostMapping
    public void createDensity(
            @RequestParam(name = "camera") Long cameraId,
            @RequestParam(name = "people") int numberOfPeople
    ) {
        createDensityService.execute(cameraId, numberOfPeople);
    }
}
