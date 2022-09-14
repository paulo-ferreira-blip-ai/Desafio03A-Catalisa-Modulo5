package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.TipoRecebido;
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

    public Optional<com.api.gerenciadordecontas.model.ContasAReceber> buscarId(Long codigo) {
        return Optional.ofNullable(contasAReceberService.findById(codigo).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + codigo)));
    }

    public com.api.gerenciadordecontas.model.ContasAReceber cadastrar(com.api.gerenciadordecontas.model.ContasAReceber contasAReceber) {

        RecebimentoAlugueis resposta1 = Factory.mudarStatus(contasAReceber.getDataDeVencimento(),
                contasAReceber.getDataDeRecebimento());
        contasAReceber.setStatus(resposta1);

        BigDecimal resposta = (BigDecimal) Factory.getStatus(contasAReceber.getStatus(),
                contasAReceber.getTipoRecebido()).calculoFactory(contasAReceber);
        contasAReceber.setValorRecebimento(resposta);

        return this.contasAReceberService.save(contasAReceber);
    }

    public com.api.gerenciadordecontas.model.ContasAReceber alterar(com.api.gerenciadordecontas.model.ContasAReceber contasAReceber,
                                                                    Long codigo) {
        contasAReceberService.findById(codigo).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + codigo));
        return this.contasAReceberService.save(contasAReceber);
    }

    public void deletar(Long codigo) {
        contasAReceberService.deleteById(codigo);
    }

    public List<com.api.gerenciadordecontas.model.ContasAReceber> findByTipoRecebido(TipoRecebido tipoRecebido) {
        return contasAReceberService.findByTipoRecebido(tipoRecebido);
    }

    public List<com.api.gerenciadordecontas.model.ContasAReceber> findByStatus(RecebimentoAlugueis status) {
        return contasAReceberService.findByStatus(status);
    }
}
