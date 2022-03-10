package br.com.soca.wallet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soca.wallet.dto.AtivoDTO;
import br.com.soca.wallet.exception.ModelException;
import br.com.soca.wallet.form.AtivoAtualizacaoForm;
import br.com.soca.wallet.form.AtivoCadastroForm;
import br.com.soca.wallet.model.Ativo;
import br.com.soca.wallet.repository.AtivoRepository;
import br.com.soca.wallet.repository.CarteiraRepository;

@Service
public class AtivoService {

    @Autowired
    private AtivoRepository ativoRepository;
    
    @Autowired
    private CarteiraRepository carteiraRepository;

    public List<AtivoDTO> listarPorCarteira(Integer idCarteira){
        
        List<Ativo> ativos = ativoRepository.findByCarteiraId(idCarteira);
        
        List<AtivoDTO> ativosDTO = new ArrayList<>();
        for (Ativo ativo :  ativos){
            ativosDTO.add(new AtivoDTO(ativo));
        }

        return ativosDTO;
    }


    public AtivoDTO cadastrar(AtivoCadastroForm form){
        form.verificarEntradas();
        
        Ativo ativo = form.converter(carteiraRepository);
        return new AtivoDTO(ativoRepository.save(ativo));
    }

    public AtivoDTO atualizar(Integer id, AtivoAtualizacaoForm form){
        form.verificarEntradas();

        Optional<Ativo> optional = ativoRepository.findById(id);
        if (!optional.isPresent())
            throw new ModelException("Ativo não encontrado");

        Ativo ativo = optional.get();

        form.atualizarAtivo(ativo, carteiraRepository);

        return new AtivoDTO(ativoRepository.save(ativo));
    }

    public void remover(Integer id){
        Optional<Ativo> optional = ativoRepository.findById(id);
        if (!optional.isPresent())
            throw new ModelException("Ativo não encontrado");

        Ativo ativo = optional.get();

        ativoRepository.delete(ativo);
    }

}
