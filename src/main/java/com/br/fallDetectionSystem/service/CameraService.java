package com.br.fallDetectionSystem.service;

import org.springframework.stereotype.Service;

import com.br.fallDetectionSystem.model.Camera;
import com.br.fallDetectionSystem.repository.CameraRepository;

@Service
public class CameraService {

	private CameraRepository cameraRepository;
	
	public CameraService(CameraRepository cameraRepository) {
		this.cameraRepository = cameraRepository;
	}
	
	public Camera saveCamera(Camera camera) { 	
        return cameraRepository.save(camera);
    }
}
