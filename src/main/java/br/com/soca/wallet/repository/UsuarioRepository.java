package br.com.soca.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.soca.wallet.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
