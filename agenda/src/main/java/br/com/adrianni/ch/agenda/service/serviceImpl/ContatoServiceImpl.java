package br.com.adrianni.ch.agenda.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adrianni.ch.agenda.model.Contato;
import br.com.adrianni.ch.agenda.repository.ContatoRepository;
import br.com.adrianni.ch.agenda.service.ContatoService;
import javassist.NotFoundException;

@Service
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public List<Contato> findAllContatos() {
		List<Contato> todosContatos = contatoRepository.findAll();

		return todosContatos;
	}
	
	@Override
	public Contato findContatoById(Long id) {
		Contato contato = contatoRepository.findById(id).get();

		return contato;
	}

	@Override
	public List<Contato> findContatoByNome(String nome) throws Exception {
		
		return this.contatoRepository.findByNomeContains(nome);
	}

	@Override
	public Contato findContatoByTelefone(String telefone) {
		Contato contato = contatoRepository.findContatoByTelefone(telefone);
		if (contato != null) {
			return contato;
		} else {
			throw new NullPointerException("Contato não encontrado");
		}
	}

	@Override
	public Contato saveContato(Contato contato) {
		contatoRepository.save(contato);
		return contato;
	}

	@Override
	public Contato updateContato(Contato contato) throws NotFoundException {
		
		if (verificarContato(contato)) {
			return contatoRepository.save(contato);
		} else {
			throw new NotFoundException("Contato não encontrado");
		}
	}

	@Override
	public void deleteContatoByNome(String nome) {
		Contato Contato = contatoRepository.findContatoByNome(nome);

		contatoRepository.delete(Contato);
	}
	
	@Override
	public void deleteContatoById(Long id) throws NotFoundException {
		var c = contatoRepository.findById(id);

		if (c.isPresent()) {
			contatoRepository.deleteById(id);
		} else {
			throw new NotFoundException("Contato não encontrado");
		}
	}
	
	@Override
	public boolean verificarContato(Contato contato) {

		if (contatoRepository.existsByNome(contato.getNome())) {
			return true;
		} else {
			return false;
		}
	}
}
