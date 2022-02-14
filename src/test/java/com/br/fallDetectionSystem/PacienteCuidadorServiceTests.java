package com.br.fallDetectionSystem;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.model.Paciente;
import com.br.fallDetectionSystem.model.PacienteCuidador;
import com.br.fallDetectionSystem.repository.CuidadorRepository;
import com.br.fallDetectionSystem.repository.PacienteCuidadorRepository;

@SpringBootTest
public class PacienteCuidadorServiceTests {

	@Mock
	private CuidadorRepository mockCuidadorRepository;
	@Mock
	private PacienteCuidadorRepository mockPacienteCuidadorRepository;
	
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
	 public void associatePacienteCuidadorTest() throws ParseException {
		 when(mockCuidadorRepository.findByUsername("admin")).thenReturn(new Cuidador(21, "admin", "Admin","teste@teste.com", "123456789", "Rua Teste", "ROLE_USER", "admin", true));
		 Cuidador cuidador = mockCuidadorRepository.findByUsername("admin");
		 Paciente paciente = new Paciente(1, "Paciente Teste", formato.parse("13/04/1956"), "Rua do Paciente Teste, 123", "9876543212", "Teste");
		 mockPacienteCuidadorRepository.save(new PacienteCuidador(paciente.getId_paciente(), cuidador.getId_cuidador()));
		 verify(mockPacienteCuidadorRepository, times(1)).save(new PacienteCuidador(paciente.getId_paciente(), cuidador.getId_cuidador()));
	 }
}
