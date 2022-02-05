package com.br.fallDetectionSystem.model;

public class MessageResponse {

	private String message;
	
	public MessageResponse() {
	}
	
	public MessageResponse(String message) {
		this.message = message;
	}
	
	public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
    
}