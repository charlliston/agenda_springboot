package br.com.adrianni.ch.agenda.service;

import java.util.List;

import br.com.adrianni.ch.agenda.model.Contato;
import br.com.adrianni.ch.agenda.service.dto.ContatoDto;
import javassist.NotFoundException;

public interface ContatoService {
	public List<Contato> findAllContatos();

	public List<Contato> findContatoByNome(String nome) throws Exception;
	
	public Contato findContatoByTelefone(String telefone) throws Exception;
	
	public Contato saveContato(Contato contato);
	
	public Contato updateContato(Long id, ContatoDto contatoDto) throws NotFoundException;

	public void deleteContatoByNome(String nome);
	
}
