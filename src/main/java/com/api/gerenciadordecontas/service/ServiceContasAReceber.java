package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.TipoRecebimento;
import com.api.gerenciadordecontas.factory.Factory;
import com.api.gerenciadordecontas.repository.ContasAReceber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceContasAReceber {

    @Autowired
    private ContasAReceber contasAReceber;

    public List<com.api.gerenciadordecontas.model.ContasAReceber> buscarTodos() {
        return contasAReceber.findAll();
    }

    public Optional<com.api.gerenciadordecontas.model.ContasAReceber> buscarId(Long id) {
        return contasAReceber.findById(id);
    }

    public com.api.gerenciadordecontas.model.ContasAReceber cadastrar(com.api.gerenciadordecontas.model.ContasAReceber contasAReceber) {
        if (contasAReceber.getTipoRecebimento() == TipoRecebimento.ALUGUEIS &&
                contasAReceber.getDataDeVencimento().isAfter(contasAReceber.getDataDeRecebimento())) {

            contasAReceber.setRecebimentoAlugueis(RecebimentoAlugueis.ADIANTADO);

        } else if (contasAReceber.getTipoRecebimento() == TipoRecebimento.ALUGUEIS &&
                contasAReceber.getDataDeVencimento().equals(LocalDateTime.now(ZoneId.of("UTC-03:00")))) {

            contasAReceber.setRecebimentoAlugueis(RecebimentoAlugueis.EM_DIA);

        } else if (contasAReceber.getTipoRecebimento() == TipoRecebimento.ALUGUEIS &&
                contasAReceber.getDataDeVencimento().isBefore(contasAReceber.getDataDeRecebimento())) {

            contasAReceber.setRecebimentoAlugueis(RecebimentoAlugueis.EM_ATRASO);
        }


        BigDecimal resposta = (BigDecimal) Factory.getStatus(contasAReceber.getRecebimentoAlugueis(), contasAReceber.getTipoRecebimento()).calculoFactory(contasAReceber);
        contasAReceber.setValorRecebimento(resposta);

        return this.contasAReceber.save(contasAReceber);
    }

    public com.api.gerenciadordecontas.model.ContasAReceber alterar(com.api.gerenciadordecontas.model.ContasAReceber contasAReceber) {
        return this.contasAReceber.save(contasAReceber);
    }

    public void deletar(Long id) {
        contasAReceber.deleteById(id);
    }
}
