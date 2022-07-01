package com.maxprogramer.api.cep.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String endereco;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private  String ddd;
    private String siafi;

    public EnderecoModel() {
    }

    public EnderecoModel(String cep, String endereco, String bairro, String localidade, String uf, String ibge, String ddd, String siafi) {
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.ddd = ddd;
        this.siafi = siafi;
    }
}
