package com.djdn.warning.domain.camera.domain.repository;

import com.djdn.warning.domain.camera.domain.Camera;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CameraRepository extends CrudRepository<Camera, Long> {

    public List<Camera> findAll();
}
