package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoContas;
import com.api.gerenciadordecontas.model.ModelRequest;
import com.api.gerenciadordecontas.model.ModelResponse;
import com.api.gerenciadordecontas.repository.GerenciadorRepository;
import com.api.gerenciadordecontas.repository.ModelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import static com.api.gerenciadordecontas.enums.StatusContas.PAGO;

@Service
public class GerenciadorService {
    @Autowired
    private GerenciadorRepository gerenciadorRepository;

    public ModelResponse cadastrar(ModelRequest modelRequest) {
        StatusContas resposta1 = StatusContas.condicoes(modelRequest.getDataDeVencimento(), modelRequest.getDataDeCadastro());
        modelRequest.setStatusContas(resposta1);

        modelRequest.setDataDePagamento(null);

        ModelEntity entidade = new ModelEntity(null, modelRequest.getNome(), modelRequest.getValor(), modelRequest.getDataDeVencimento(), modelRequest.getDataDePagamento(), modelRequest.getDataDeCadastro(), modelRequest.getStatusContas(), modelRequest.getTipoContas());
        gerenciadorRepository.save(entidade);

        ModelResponse retorno = new ModelResponse(entidade.getId(), entidade.getNome(), entidade.getValor(), entidade.getStatusContas());
        return retorno;
    }

    public ModelEntity buscarPorId(Long id) {
        return gerenciadorRepository.findById(id).get();
    }

    public List<ModelResponse> buscarTodos() {
        List<ModelEntity> campos = gerenciadorRepository.findAll();

        return campos.stream().map(campo -> new ModelResponse(campo.getId(), campo.getNome(), campo.getValor(), campo.getStatusContas())).collect(Collectors.toList());
    }

    public ModelEntity alterarCadastro(ModelEntity modelEntity) {
        //foi criada uma variável para armanezar os dados do ID que foi indicado no Json para que ao atualizar o status da conta
        //permanecesse salvo os dados que ja foram cadastrados.
        ModelEntity entity = gerenciadorRepository.findById(modelEntity.getId()).get();
        if (modelEntity.getStatusContas() == PAGO) {
            entity.setDataDePagamento(LocalDateTime.now(ZoneId.of("UTC-03:00")));
            //após a verificação se o usuario digitou que sua conta foi paga
            //o sistema vai setar a data de pagamento e atualizar o status da conta para paga
            entity.setStatusContas(PAGO);
        }
        //por fim, foi salvo no banco de dados a variável que armazenou os dados antigo junto com os dados novos.
        return gerenciadorRepository.save(entity);
    }

    public void deletar(Long id) {
        gerenciadorRepository.deleteById(id);
    }

    public List<ModelEntity> findByStatuContas(StatusContas statusContas) {
        return gerenciadorRepository.findByStatusContas(statusContas);
    }

    public List<ModelEntity> findByTipoContas(TipoContas tipoContas) {
        return gerenciadorRepository.findByTipoContas(tipoContas);
    }

    public boolean existsByNome(String nome) {
        return gerenciadorRepository.existsByNome(nome);
    }
}
