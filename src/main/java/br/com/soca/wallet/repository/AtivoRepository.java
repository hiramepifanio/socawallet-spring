package br.com.soca.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.soca.wallet.model.Ativo;

public interface AtivoRepository extends JpaRepository<Ativo, Integer> {

    List<Ativo> findAllByCarteiraId(Integer id);

    List<Ativo> findByCarteiraId(Integer idCarteira);
}
