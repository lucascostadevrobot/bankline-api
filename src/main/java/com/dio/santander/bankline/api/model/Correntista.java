package com.dio.santander.bankline.api.model;


/*
================Informações sobre as Classes Models===================
  Nas classes de modelo precisamos gerar nossos métodos Geters and Seters para acessos.
  Podemos realizar isso gerando manualmente ou
  Usar uma dependência chamada Lombook que gera esses geters and seters em tempo de execução.
=======================================================================

 */

import javax.persistence.*;

@Entity
@Table(name = "tab_correntista")
public class Correntista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String cpf;
    @Column(length = 60)
    private String nome;

    /*Informando que Correntista possui uma Conta->Classe*/

    /*Após realizar a criação das classes models é necessário criar nossas classes de Persistência
      Instalando Spring Boot Tools ou JPA BUDY.
     */

    /*EMBEDDED Diz que as mesmas informações que estão na Conta->Classe estarão na tabela principal correntista */
    @Embedded
    private Conta conta;

    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
