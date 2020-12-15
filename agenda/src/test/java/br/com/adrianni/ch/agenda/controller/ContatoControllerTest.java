package br.com.adrianni.ch.agenda.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.adrianni.ch.agenda.model.Contato;
import br.com.adrianni.ch.agenda.service.ContatoService;

@WebMvcTest
public class ContatoControllerTest {

	@Autowired
	private ContatoController contatoController;

	@MockBean
	private ContatoService contatoService;

	private Contato contato;

	private Optional<Contato> resultado;

	@BeforeEach
	public void setup() {
		contato = new Contato();
		
		contato.setIdContato(1L);
		contato.setNome("Charlliston");
		contato.setEmail("charlliston@everis.com");
		contato.setTelefone("(048)98808-2031");

		resultado = Optional.of(contato);
	}

	@Test
	void testfindAllContatos() {
		List<Contato> lista = new ArrayList<>();
		lista.add(contato);
		Mockito.when(contatoService.findAllContatos()).thenReturn(lista);

		assertNotNull(contatoController.findAllContatos());
	}

	@Test
	void testfindContatoByNome() throws Exception {
		List<Contato> lista = new ArrayList<>();
		lista.add(contato);

		Mockito.when(contatoService.findContatoByNome(contato.getNome())).thenReturn(lista);
		assertNotNull(contatoController.findContatoByNome(contato.getNome()));
	}
	
	@Test
	void testfindContatoByTelefone() throws Exception {
		Mockito.when(contatoService.findContatoByTelefone(contato.getTelefone())).thenReturn(contato);
		assertNotNull(contatoController.findContatoByTelefone(contato.getTelefone()));
	}

	@Test
	void testSave() {
		Mockito.when(contatoService.saveContato(contato)).thenReturn(contato);
		assertNotNull(contatoController.save(contato));
	}

//	@Test
//	void testUpdate() throws NotFoundException {
//		Mockito.when(contatoService.updateContato(1L, contatoDto)).thenReturn(contato);
//
//		assertNotNull(contatoController.updateContato(1L, contatoDto));
//	}

}
