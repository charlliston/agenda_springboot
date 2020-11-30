package br.com.adrianni.ch.agenda.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adrianni.ch.agenda.model.Contato;
import br.com.adrianni.ch.agenda.repository.ContatoRepository;
import br.com.adrianni.ch.agenda.service.ContatoService;
import br.com.adrianni.ch.agenda.service.dto.ContatoDto;
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
	public List<Contato> findContatoByNome(String nome) throws Exception {
		List<Contato> contatos = new ArrayList<Contato>();

		findAllContatos().forEach(c -> {
			if (c.getNome().equals(nome)) {
				contatos.add(c);
			}
		});

		if (contatos.isEmpty()) {
			throw new Exception("Nenhum contato encontrado para o nome: " + nome);
		}
		return contatos;
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
		var c = new Contato();

		c.setNome(contato.getNome());
		c.setTelefone(contato.getTelefone());
		c.setEmail(contato.getEmail());

		contatoRepository.save(c);
		return c;
	}

	@Override
	public Contato updateContato(Long id, ContatoDto contatoDto) throws NotFoundException {
		var c = contatoRepository.findById(id);

		if (c.isPresent()) {
			var contatoSave = c.get();
			contatoSave.setNome(contatoDto.getNome());
			contatoSave.setTelefone(contatoDto.getTelefone());
			contatoSave.setEmail(contatoDto.getEmail());

			contatoRepository.save(contatoSave);

			return contatoSave;
		} else {
			throw new NotFoundException("Contato não encontrado");
		}
	}

	@Override
	public void deleteContatoByNome(String nome) {
		Contato Contato = contatoRepository.findContatoByNome(nome);

		contatoRepository.delete(Contato);
	}

}
