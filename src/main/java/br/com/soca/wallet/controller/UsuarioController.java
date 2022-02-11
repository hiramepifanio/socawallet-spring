package br.com.soca.wallet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.soca.wallet.UsuarioDTO;
import br.com.soca.wallet.model.Usuario;
import br.com.soca.wallet.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioDTO> list() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		
		for (Usuario u : usuarios) {
			usuariosDTO.add(new UsuarioDTO(u));
		}
		
		return usuariosDTO;
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
}
