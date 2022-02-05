package com.br.fallDetectionSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.fallDetectionSystem.model.Camera;

public interface CameraRepository extends CrudRepository<Camera, Integer>{
	public Camera findById(int id_camera);
}
