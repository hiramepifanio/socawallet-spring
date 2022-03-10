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

import br.com.soca.wallet.form.AtivoAtualizacaoForm;
import br.com.soca.wallet.form.AtivoCadastroForm;
import br.com.soca.wallet.service.AtivoService;

@RestController
@RequestMapping("/ativo")
public class AtivoController {

    @Autowired
    private AtivoService ativoService;

    @GetMapping("/carteira/{idCarteira}")
    public ResponseEntity<?> listarPorCarteira(@PathVariable Integer idCarteira){
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(ativoService.listarPorCarteira(idCarteira));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody AtivoCadastroForm form){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(ativoService.cadastrar(form)); 
        } catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(e.getMessage());
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody AtivoAtualizacaoForm form){
        try{
            return ResponseEntity.status(HttpStatus.OK).
                    body(ativoService.atualizar(id, form));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id){
        try{
            ativoService.remover(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(e.getMessage());
        }
    }
}
