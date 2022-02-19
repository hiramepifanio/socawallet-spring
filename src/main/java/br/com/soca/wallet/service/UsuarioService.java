package br.com.soca.wallet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soca.wallet.dto.UsuarioDTO;
import br.com.soca.wallet.exception.ModelException;
import br.com.soca.wallet.form.UsuarioAtualizacaoForm;
import br.com.soca.wallet.form.UsuarioCadastroForm;
import br.com.soca.wallet.model.Usuario;
import br.com.soca.wallet.repository.UsuarioRepository;
import br.com.soca.wallet.util.ContextUtil;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public UsuarioDTO detalhar() {
		Usuario usuario = ContextUtil.getUsuario();
		
		return new UsuarioDTO(usuario);
	}

	public UsuarioDTO cadastrar(UsuarioCadastroForm form) {

		if (form == null)
			throw new ModelException("Cadastro não informado.");

		form.verificarEntradas();

		Usuario novoUsuario = form.getNovoUsuario();

		Optional<Usuario> optional = usuarioRepository.findByEmail(novoUsuario.getEmail());

		if (optional.isPresent())
			throw new ModelException("Email já cadastrado.");

		return new UsuarioDTO(usuarioRepository.save(novoUsuario));
	}

	public UsuarioDTO atualizar(UsuarioAtualizacaoForm form) {

		if (form == null)
			throw new ModelException("Cadastro não informado.");

		Usuario usuario = ContextUtil.getUsuario();

		if (!usuario.autenticarSenha(form.getSenha()))
			throw new ModelException("Senha incorreta.");

		form.atualizarUsuario(usuario);

		return new UsuarioDTO(usuarioRepository.save(usuario));
	}
}
