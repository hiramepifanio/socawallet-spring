package br.com.soca.wallet.util;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.soca.wallet.model.Usuario;

public class ContextUtil {

	public static Usuario getUsuario() {
		return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
