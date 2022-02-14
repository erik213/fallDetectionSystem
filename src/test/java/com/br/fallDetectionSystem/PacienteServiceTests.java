package com.br.fallDetectionSystem;

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
import com.br.fallDetectionSystem.repository.PacienteRepository;
import com.br.fallDetectionSystem.service.PacienteService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
public class PacienteServiceTests {

	@Mock
	private PacienteRepository mockPacienteRepository;
	@Mock
	private PacienteCuidadorRepository mockPacienteCuidadorRepository;
	@Mock
	private CuidadorRepository mockCuidadorRepository;

	private PacienteService pacienteService;
	
	private Paciente paciente;
	
	private AutoCloseable closeable;
	
	private SimpleDateFormat formato;
	
	@Before 
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
        
        pacienteService = new PacienteService(mockPacienteRepository, mockCuidadorRepository,mockPacienteCuidadorRepository);
        
        formato = new SimpleDateFormat("dd/MM/yyyy"); 
    }

    @After 
    public void releaseMocks() throws Exception {
        closeable.close();
    }
	
	@Test
	public void testSavePaciente() throws ParseException {	
		paciente = new Paciente(1, "Paciente Teste", formato.parse("13/04/1956"), "Rua do Paciente Teste, 123", "9876543212", "Teste");
		pacienteService.savePaciente(paciente);
		verify(mockPacienteRepository, times(1)).save(paciente);
	}
	
	@Test
	public void testFindPatcienteById() throws ParseException {
		final int id = 78;
		when(mockPacienteRepository.findById(78)).thenReturn(new Paciente(78, "Paciente Teste", formato.parse("13/04/1956"), "Rua Teste, 35", "40028922", "Masculino"));
		final Paciente result = pacienteService.findPatientById(id);
		assertEquals(id, result.getId_paciente());
	}
	
	@Test
    public void testAssociatePacienteCuidador() throws ParseException {
    	final String username = "admin";
    	when(mockCuidadorRepository.findByUsername(username)).thenReturn(new Cuidador(21, "admin", "Admin","teste@teste.com", "123456789", "Rua Teste", "ROLE_USER", "admin", true));
    	Cuidador cuidador = mockCuidadorRepository.findByUsername(username);
    	paciente = new Paciente(1, "Paciente Teste", formato.parse("13/04/1956"), "Rua do Paciente Teste, 123", "9876543212", "Teste");
    	mockPacienteCuidadorRepository.save(new PacienteCuidador(paciente.getId_paciente(), cuidador.getId_cuidador()));
    	verify(mockPacienteCuidadorRepository, times(1)).save(new PacienteCuidador(paciente.getId_paciente(), cuidador.getId_cuidador()));
    }
}
