package br.com.adrianni.ch.agenda.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.adrianni.ch.agenda.model.Contato;
import br.com.adrianni.ch.agenda.repository.ContatoRepository;
//import br.com.adrianni.ch.agenda.service.dto.ContatoDto;
import br.com.adrianni.ch.agenda.service.serviceImpl.ContatoServiceImpl;

public class ContatoServiceImplTest {

	@InjectMocks
	private ContatoServiceImpl contatoService;

	@Mock
	private ContatoRepository contatoRepository;

	private Contato contato;
	private List<Contato> lista;

	@BeforeEach
	void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		contato = new Contato();

		contato.setIdContato(1L);
		contato.setNome("Charlliston");
		contato.setEmail("charlliston@everis.com");
		contato.setTelefone("(048)98808-2031");		
	}

	@Test
	void testFindAllContatos() {
		lista = new ArrayList<>();

		Mockito.when(contatoRepository.findAll()).thenReturn(lista);
		lista.add(contato);
		lista.add(contato);
		lista.add(contato);
		assertEquals(lista, contatoService.findAllContatos());
	}

	@Test
	void testFindContatoByNome() throws Exception {
		List<Contato> lista = new ArrayList<>();

		lista.add(contato);
		lista.add(contato);
		lista.add(contato);
		lista.add(contato);
		
		
		Mockito.when(contatoRepository.findByNomeContains(contato.getNome())).thenReturn(lista);
		assertEquals(lista, contatoService.findContatoByNome(contato.getNome()));
	}

	@Test
	void testFindContatoByTelefone() {
		Mockito.when(contatoRepository.findContatoByTelefone(contato.getTelefone())).thenReturn(contato);
		assertEquals(contato, contatoService.findContatoByTelefone(contato.getTelefone()));
	}

	@Test
	void testSaveContato() {
		Mockito.when(contatoRepository.existsByNome(contato.getNome())).thenReturn(false);
		Mockito.when(contatoRepository.save(contato)).thenReturn(contato);
		assertEquals(contato, contatoService.saveContato(contato));
	}

//	@Test
//	void testUpdateContato() throws Exception {
//		Mockito.when(contatoRepository.existsByNome(contatoDto.getNome())).thenReturn(true);
//		Mockito.when(contatoRepository.save(contato)).thenReturn(contato);
//		assertEquals(contatoDto, contatoService.updateContato(1L, contatoDto));
//	}
}
