package com.djdn.warning.domain.density.domain.repository;

import com.djdn.warning.domain.density.domain.Density;
import org.springframework.data.repository.CrudRepository;

public interface DensityRepository extends CrudRepository<Density, Long> {

    Density findFirstByCameraIdOrderByCreatedAtDesc(Long cameraId);
}
