package br.com.soca.wallet.controller;

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

import br.com.soca.wallet.form.CarteiraAtualizacaoForm;
import br.com.soca.wallet.form.CarteiraCadastroForm;
import br.com.soca.wallet.service.CarteiraService;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {

	@Autowired
	private CarteiraService carteiraService;
	
	@GetMapping
	public ResponseEntity<?> Listar() {
		try {
			return ResponseEntity.status(HttpStatus.OK).
					body(carteiraService.listar());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody CarteiraCadastroForm form) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).
					body(carteiraService.cadastrar(form));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody CarteiraAtualizacaoForm form) {
		try {
			return ResponseEntity.status(HttpStatus.OK).
					body(carteiraService.atualizar(id, form));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		try {
			carteiraService.remover(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
}
