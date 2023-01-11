package com.djdn.warning.domain.density.presentation.dto.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Code {
    WARNING(85, 100),
    NORMAL(40, 84),
    NICE(0, 39);

    private final int min;
    private final int max;
}
