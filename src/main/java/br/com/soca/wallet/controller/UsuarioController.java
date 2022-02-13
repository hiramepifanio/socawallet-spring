package br.com.soca.wallet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.soca.wallet.dto.UsuarioDTO;
import br.com.soca.wallet.form.AtualizarUsuarioForm;
import br.com.soca.wallet.form.CadastroNovoUsuarioForm;
import br.com.soca.wallet.model.Usuario;
import br.com.soca.wallet.repository.UsuarioRepository;
import br.com.soca.wallet.service.UsuarioService;
import br.com.soca.wallet.util.ModelException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioDTO> list() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		
		for (Usuario u : usuarios) {
			usuariosDTO.add(new UsuarioDTO(u));
		}
		
		return usuariosDTO;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody CadastroNovoUsuarioForm form) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(usuarioService.cadastrar(form));
		} catch (ModelException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public UsuarioDTO detalhar(@PathVariable("id") Integer id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		
		if(optional.isPresent()) {
			Usuario usuario = optional.get();
			return new UsuarioDTO(usuario);
		} else {
			return null;
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@RequestBody AtualizarUsuarioForm form, @PathVariable("id") Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(usuarioService.atualizar(id, form));
		} catch (ModelException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
}
