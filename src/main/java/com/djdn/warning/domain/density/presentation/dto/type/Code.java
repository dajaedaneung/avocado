package com.djdn.warning.domain.density.presentation.dto.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Code {
    WARNING(85, 100),
    CAUTION(65, 84),
    NORMAL(40, 64),
    NICE(0, 39);

    private final int min;
    private final int max;
}
