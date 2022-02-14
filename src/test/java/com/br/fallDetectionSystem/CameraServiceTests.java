package com.br.fallDetectionSystem;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.fallDetectionSystem.model.Camera;
import com.br.fallDetectionSystem.model.Paciente;
import com.br.fallDetectionSystem.repository.CameraRepository;

@SpringBootTest
public class CameraServiceTests {

	@Mock
	private CameraRepository mockCameraRepository;
	
	private AutoCloseable closeable;
	
	private SimpleDateFormat formato;
	
	@Before 
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
        formato = new SimpleDateFormat("dd/MM/yyyy"); 
	}
	
	 @After 
	    public void releaseMocks() throws Exception {
	        closeable.close();
	 }
	 
	 @Test
	 public void saveCameraTest() throws ParseException {
		 Paciente paciente = new Paciente(1, "Paciente Teste", formato.parse("13/04/1956"), "Rua do Paciente Teste, 123", "9876543212", "Teste");
		 Camera camera = new Camera(paciente.getId_paciente());
		 mockCameraRepository.save(camera);
		 verify(mockCameraRepository, times(1)).save(camera);
	 }
}
