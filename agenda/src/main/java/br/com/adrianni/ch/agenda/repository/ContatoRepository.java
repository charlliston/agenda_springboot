package br.com.adrianni.ch.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrianni.ch.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

	public Contato findContatoByNome(String nome);
	
	public boolean existsByNome(String nome);
	
	public Contato findContatoByTelefone(String telefone);
	
	public Contato deleteContatoByNome(String nome);
}