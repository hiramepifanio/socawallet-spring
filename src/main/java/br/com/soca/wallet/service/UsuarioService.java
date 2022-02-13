package br.com.soca.wallet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soca.wallet.dto.UsuarioDTO;
import br.com.soca.wallet.form.AtualizarUsuarioForm;
import br.com.soca.wallet.form.CadastroNovoUsuarioForm;
import br.com.soca.wallet.model.Usuario;
import br.com.soca.wallet.repository.UsuarioRepository;
import br.com.soca.wallet.util.ModelException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public UsuarioDTO cadastrar(CadastroNovoUsuarioForm form) {
		
		if (form == null)
			throw new ModelException("Cadastro não informado.");
		
		form.verificarEntradas();

		Usuario novoUsuario = form.getNovoUsuario();

		Optional<Usuario> optional = usuarioRepository.findByEmail(novoUsuario.getEmail());

		if (optional.isPresent()) {
			throw new ModelException("Email já cadastrado.");
		}

		return new UsuarioDTO(usuarioRepository.save(novoUsuario));
	}

	public UsuarioDTO atualizar(Integer id, AtualizarUsuarioForm form) {
		
		if (form == null)
			throw new ModelException("Cadastro não informado.");
		
		form.verificarEntradas();
		
		Optional<Usuario> optional = usuarioRepository.findById(id);

		if (!optional.isPresent())
			throw new ModelException("Usuário inexistente.");
		
		Usuario usuarioAtualizado = form.atualizarUsuario(optional.get());
		
		return new UsuarioDTO(usuarioRepository.save(usuarioAtualizado));
	}
}
