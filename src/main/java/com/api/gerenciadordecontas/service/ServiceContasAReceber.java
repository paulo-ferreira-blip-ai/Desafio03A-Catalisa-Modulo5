package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoRecebimento;
import com.api.gerenciadordecontas.exceptions.EntityNotFoundException;
import com.api.gerenciadordecontas.factory.Factory;
import com.api.gerenciadordecontas.repository.ContasAReceber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceContasAReceber {

    @Autowired
    private ContasAReceber contasAReceberService;

    public List<com.api.gerenciadordecontas.model.ContasAReceber> buscarTodos() {
        return contasAReceberService.findAll();
    }

    public Optional<com.api.gerenciadordecontas.model.ContasAReceber> buscarId(Long id) {
        return Optional.ofNullable(contasAReceberService.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id)));
    }

    public com.api.gerenciadordecontas.model.ContasAReceber cadastrar(com.api.gerenciadordecontas.model.ContasAReceber contasAReceber) {

        RecebimentoAlugueis resposta1 = Factory.mudarStatus(contasAReceber.getDataDeVencimento(),
                contasAReceber.getDataDeRecebimento());
        contasAReceber.setStatus(resposta1);

        BigDecimal resposta = (BigDecimal) Factory.getStatus(contasAReceber.getStatus(),
                contasAReceber.getTipoRecebimento()).calculoFactory(contasAReceber);
        contasAReceber.setValorRecebimento(resposta);

        return this.contasAReceberService.save(contasAReceber);
    }

    public com.api.gerenciadordecontas.model.ContasAReceber alterar(com.api.gerenciadordecontas.model.ContasAReceber contasAReceber,
                                                                    Long id) {
        contasAReceberService.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id));
        return this.contasAReceberService.save(contasAReceber);
    }

    public void deletar(Long id) {
        contasAReceberService.deleteById(id);
    }

    public List<com.api.gerenciadordecontas.model.ContasAReceber> findByTipoRecebimento(TipoRecebimento tipoRecebimento) {
        return contasAReceberService.findByTipoRecebimento(tipoRecebimento);
    }

    public List<com.api.gerenciadordecontas.model.ContasAReceber> findByStatus(RecebimentoAlugueis status) {
        return contasAReceberService.findByStatus(status);
    }
}
