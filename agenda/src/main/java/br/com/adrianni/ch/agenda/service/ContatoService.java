package br.com.adrianni.ch.agenda.service;

import java.util.List;

import br.com.adrianni.ch.agenda.model.Contato;
import javassist.NotFoundException;

public interface ContatoService {
	public List<Contato> findAllContatos();
	
	public Contato findContatoById(Long id);

	public List<Contato> findContatoByNome(String nome) throws Exception;
	
	public Contato findContatoByTelefone(String telefone) throws Exception;
	
	public Contato saveContato(Contato contato);
	
	public Contato updateContato(Contato contato) throws NotFoundException;

	public void deleteContatoByNome(String nome);
	
	public void deleteContatoById(Long id) throws NotFoundException;
	
	public boolean verificarContato(Contato contato);
	
}
