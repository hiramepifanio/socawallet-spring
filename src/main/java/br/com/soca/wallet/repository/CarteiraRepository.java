package br.com.soca.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.soca.wallet.model.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Integer> {

	List<Carteira> findAllByUsuarioId(Integer id);

}
