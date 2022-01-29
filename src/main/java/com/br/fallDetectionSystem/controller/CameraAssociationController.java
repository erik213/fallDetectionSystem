package com.br.fallDetectionSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.fallDetectionSystem.model.Camera;
import com.br.fallDetectionSystem.service.CameraService;

@Controller
public class CameraAssociationController {
	
	@Autowired
	private CameraService cameraService;

	@RequestMapping(value="/associate-camera", method = RequestMethod.GET)
    public ModelAndView registerPatient(){
        ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("camera", new Camera());
        modelAndView.setViewName("associate-camera");
        return modelAndView;
    }
    
    @RequestMapping(value = "/associate-camera", method = RequestMethod.POST)
    public ModelAndView createPatient(Camera camera, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        cameraService.saveCamera(camera);
        modelAndView.addObject("successMessage", "Camera has been registered successfully");
        modelAndView.addObject("camera", new Camera());
        modelAndView.setViewName("associate-camera");
        return modelAndView;
    }
}
