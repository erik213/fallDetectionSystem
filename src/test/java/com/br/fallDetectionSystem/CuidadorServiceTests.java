package com.br.fallDetectionSystem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.repository.CuidadorRepository;
import com.br.fallDetectionSystem.service.CuidadorService;

@SpringBootTest
public class CuidadorServiceTests {

	@Mock
	private CuidadorRepository mockCuidadorRepository;
	
	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private CuidadorService cuidadorService;
	
	private AutoCloseable closeable;

    @Before 
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
        
        cuidadorService = new CuidadorService(mockCuidadorRepository);
    }

    @After 
    public void releaseMocks() throws Exception {
        closeable.close();
    }
	
	@Test
	public void testFindUserByUsername() {
		final String username = "admin";
		when(mockCuidadorRepository.findById(21)).thenReturn(new Cuidador(21, "admin", "Admin","teste@teste.com", "123456789", "Rua Teste", "ROLE_USER", "admin", true));
		final Cuidador result = mockCuidadorRepository.findById(21);
		assertEquals(username, result.getUsername());
	}
	
	@Test
	public void testSaveCuidador() {
		Cuidador cuidador = new Cuidador(1, "testUser", "Test", "teste@teste.com", "40028922", "Rua Teste", "ROLE_USER", "testpass", true);
		cuidadorService.saveCuidador(cuidador);
		verify(mockCuidadorRepository, times(1)).save(cuidador);
	}
	
}
