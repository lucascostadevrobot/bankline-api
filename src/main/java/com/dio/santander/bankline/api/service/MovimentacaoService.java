package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
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
}

}
