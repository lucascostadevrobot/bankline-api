package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;
    public void save (NovaMovimentacao novaMovimentacao){
    Movimentacao movimentacao = new Movimentacao();

    Double  valor = novaMovimentacao.getValor();
    if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA)
        valor = valor * -1;

    movimentacao.setDataHora(LocalDateTime.now());
    movimentacao.setDescricao(novaMovimentacao.getDescricao());
    movimentacao.setIdConta(novaMovimentacao.getIdConta());
    movimentacao.setTipo(novaMovimentacao.getTipo());
    movimentacao.setValor(valor); //Valor passado do calculo de acordo com a receita da regra acima.

        /*Movimentação antes de você salvar, busque o Correntista e pede para o CorrentistaRepository dar um FindById pelo ID da Conta*/
        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() +valor); //Correntista pega o saldo que já esta na conta e soma com o valor
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao); //Ter operações de movimentação em nosso sistema
}

}
