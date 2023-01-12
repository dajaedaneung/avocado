package com.djdn.warning.domain.density.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DensityListResponse {

    private List<DensityResponse> densityList;
}
