package br.com.adrianni.ch.agenda.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContatoTest {

	private Contato contato;
	private Contato contato2;

	@BeforeEach
	void setup() throws Exception {
		contato = new Contato();

		contato.setIdContato(1L);
		contato.setNome("Charlliston");
		contato.setEmail("charlliston@everis.com");
		contato.setTelefone("(048)98808-2031");
	}

	@Test
	void testSetIdContato() {
		assertEquals(1L, contato.getIdContato(), "Espera-se 1L");
	}

	@Test
	void testSetNome() {
		assertEquals("Charlliston", contato.getNome(), "Espera-se o retorno de Charlliston");
	}

	@Test
	void testSetTelefone() {
		assertEquals("(048)98808-2031", contato.getTelefone(), "Espera-se (048)98808-2031");
	}

	@Test
	void testSetEmail() {
		assertEquals("charlliston@everis.com", contato.getEmail(), "Espera-se charlliston@everis.com");
	}

	@Test
	void testEqualsObject() {
		contato2 = new Contato();

		contato2.setIdContato(1L);
		contato2.setNome("Charlliston");
		contato2.setEmail("charlliston@everis.com");
		contato2.setTelefone("(048)98808-2031");

		assertEquals(true, contato.equals(contato2));
	}

	@Test
	void testHashCode() {
		contato2 = new Contato();

		contato2.setIdContato(1L);
		contato2.setNome("Charlliston");
		contato2.setEmail("charlliston@everis.com");
		contato2.setTelefone("(048)98808-2031");

		assertEquals(contato.hashCode(), contato2.hashCode());
	}
}
