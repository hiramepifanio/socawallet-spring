package br.com.soca.wallet.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.soca.wallet.form.CadastroForm;
import br.com.soca.wallet.model.Usuario;
import br.com.soca.wallet.repository.UsuarioRepository;

@RestController
@RequestMapping("/cadastrar")
public class CadastrarController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody CadastroForm form) {
		
		Usuario novoUsuario = form.convert();
		
		Optional<Usuario> optional = usuarioRepository.findByEmail(novoUsuario.getEmail());
		
		if(optional.isPresent()) {
			return ResponseEntity.badRequest().body("Já existe um usuário com este email.");
		}
		
		usuarioRepository.save(novoUsuario);
		
		return ResponseEntity.ok("Usuário cadastrado.");
	}
}
