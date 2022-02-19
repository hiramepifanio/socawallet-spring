package br.com.soca.wallet.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.soca.wallet.exception.FormException;

public class LoginForm implements Form {

	private String email;
	private String senha;
	
	@Override
	public void verificarEntradas() {
		if (email == null || email.isEmpty())
			throw new FormException("Informe seu email.");
		if (senha == null || senha.isEmpty())
			throw new FormException("Informe sua senha.");
		
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

}
