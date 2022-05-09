package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    /*Criando Metodo para listar correntistas*/
    @Autowired
    private CorrentistaRepository repository;


    @GetMapping /*Dizemos que nosso metodo é uma requisição do endpoint ("/correntistas")*/
    public List<Correntista> findAll(){
        return repository.findAll();

    }
}
