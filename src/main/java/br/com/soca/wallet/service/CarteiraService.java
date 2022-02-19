package br.com.soca.wallet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soca.wallet.dto.CarteiraDTO;
import br.com.soca.wallet.exception.ModelException;
import br.com.soca.wallet.form.CarteiraAtualizacaoForm;
import br.com.soca.wallet.form.CarteiraCadastroForm;
import br.com.soca.wallet.model.Carteira;
import br.com.soca.wallet.model.Usuario;
import br.com.soca.wallet.repository.CarteiraRepository;
import br.com.soca.wallet.util.ContextUtil;

@Service
public class CarteiraService {

	@Autowired
	private CarteiraRepository carteiraRepositoy;

	public List<CarteiraDTO> listar() {
		Usuario usuario = ContextUtil.getUsuario();

		List<Carteira> carteiras = carteiraRepositoy.findAllByUsuarioId(usuario.getId());

		List<CarteiraDTO> carteirasDTO = new ArrayList<>();
		for (Carteira carteira : carteiras) {
			carteirasDTO.add(new CarteiraDTO(carteira));
		}

		return carteirasDTO;
	}

	public CarteiraDTO cadastrar(CarteiraCadastroForm form) {
		form.verificarEntradas();

		Carteira carteira = form.converter();

		return new CarteiraDTO(carteiraRepositoy.save(carteira));
	}

	public CarteiraDTO atualizar(Integer id, CarteiraAtualizacaoForm form) {
		form.verificarEntradas();
		
		Optional<Carteira> optional = carteiraRepositoy.findById(id);
		if (!optional.isPresent())
			throw new ModelException("Carteira não encontrada");

		Carteira carteira = optional.get();
		
		form.atualizarCarteira(carteira);

		return new CarteiraDTO(carteiraRepositoy.save(carteira));
	}

	public void remover(Integer id) {
		Optional<Carteira> optional = carteiraRepositoy.findById(id);
		if (!optional.isPresent())
			throw new ModelException("Carteira não encontrada");
		
		Carteira carteira = optional.get();
		
		carteiraRepositoy.delete(carteira);
	}

}
