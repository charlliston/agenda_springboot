package br.com.adrianni.ch.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.adrianni.ch.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

	@Query(
			value="SELECT C from Contato as C where C.nome = ?1")
	public Contato findContatoByNome(String nome);
	
	public List<Contato> findByNomeContains(String nome);
	
	public boolean existsByNome(String nome);
	
	public Contato findContatoByTelefone(String telefone);
	
	public Contato deleteContatoByNome(String nome);	
}