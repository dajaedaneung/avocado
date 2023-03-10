package com.djdn.warning.domain.density.presentation.dto.response;

import com.djdn.warning.domain.density.domain.Density;
import com.djdn.warning.domain.density.presentation.dto.type.Code;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DensityResponse {

    private Long cameraId;
    private int density;
    private Code code;

    public static DensityResponse of(Density density) {
        return new DensityResponse(
                density.getCamera().getId(),
                density.getDensity(),
                density.getCode()
        );
    }
}
