package br.com.adrianni.ch.agenda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adrianni.ch.agenda.model.Contato;
import br.com.adrianni.ch.agenda.service.ContatoService;
import br.com.adrianni.ch.agenda.service.dto.ContatoDto;
import javassist.NotFoundException;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@GetMapping("/")
	public ResponseEntity<List<Contato>> findAllContatos() {
		List<Contato> todosContatos = contatoService.findAllContatos();

		return new ResponseEntity<List<Contato>>(todosContatos, HttpStatus.OK);
	}

	@GetMapping("/findByNome/{nome}")
	public ResponseEntity<?> findContatoByNome(@PathVariable("nome") String nome) throws Exception {
		return new ResponseEntity<>(contatoService.findContatoByNome(nome), HttpStatus.OK);
	}

	@GetMapping("/findByTelefone/{telefone}")
	public ResponseEntity<?> findContatoByTelefone(@PathVariable("telefone") String telefone) throws Exception {
		return new ResponseEntity<>(contatoService.findContatoByTelefone(telefone), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody @Valid Contato contato) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.saveContato(contato));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateContato(@Valid @PathVariable("id") Long id, @RequestBody ContatoDto contatoDto)
			throws NotFoundException {
		contatoService.updateContato(id, contatoDto);

		return new ResponseEntity<>("Contato atualizado com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/deletebyname/{nome}")
	public ResponseEntity<?> deleteContato(@PathVariable("nome") String nome) {
		contatoService.deleteContatoByNome(nome);

		return new ResponseEntity<>("Contato excluído com sucesso!", HttpStatus.OK);
	}

}
