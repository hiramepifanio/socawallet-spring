package br.com.soca.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.soca.wallet.exception.ModelException;
import br.com.soca.wallet.form.UsuarioAtualizacaoForm;
import br.com.soca.wallet.form.UsuarioCadastroForm;
import br.com.soca.wallet.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ResponseEntity<?> detalhar() {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(usuarioService.detalhar());
		} catch (ModelException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody UsuarioCadastroForm form) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(usuarioService.cadastrar(form));
		} catch (ModelException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@PutMapping()
	public ResponseEntity<?> atualizar(@RequestBody UsuarioAtualizacaoForm form) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(usuarioService.atualizar(form));
		} catch (ModelException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
}
