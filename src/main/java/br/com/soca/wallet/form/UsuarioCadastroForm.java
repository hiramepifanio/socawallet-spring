package br.com.soca.wallet.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.soca.wallet.exception.FormException;
import br.com.soca.wallet.model.Usuario;

public class UsuarioCadastroForm implements Form {

	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String confirmacaoDeSenha;

	public Usuario getNovoUsuario() {
		Usuario u = new Usuario();
		u.setNome(nome);
		u.setSobrenome(sobrenome);
		u.setEmail(email);
		u.setSenha(new BCryptPasswordEncoder().encode(senha));

		return u;
	}

	public void verificarEntradas() {
		if (nome == null || nome.isEmpty())
			throw new FormException("Informe seu nome.");
		if (sobrenome == null || sobrenome.isEmpty())
			throw new FormException("Informe seu sobrenome.");
		if (email == null || email.isEmpty())
			throw new FormException("Informe seu email.");
		if (senha == null || senha.isEmpty())
			throw new FormException("Informe sua senha.");
		if (confirmacaoDeSenha == null || confirmacaoDeSenha.isEmpty())
			throw new FormException("Confirme sua senha.");
		if (!confirmacaoDeSenha.equals(senha))
			throw new FormException("Confirmação de senha incorreta.");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmacaoDeSenha() {
		return confirmacaoDeSenha;
	}

	public void setConfirmacaoDeSenha(String confirmacaoDeSenha) {
		this.confirmacaoDeSenha = confirmacaoDeSenha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
