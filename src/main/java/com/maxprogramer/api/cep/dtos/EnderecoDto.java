package com.maxprogramer.api.cep.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.maxprogramer.api.cep.models.EnderecoModel;
import lombok.Data;

@Data
public class EnderecoDto {
    private String cep;
    @JsonProperty("logradouro")
    private String endereco;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public EnderecoModel novoEndereco(){
        return new EnderecoModel(cep,endereco,bairro,localidade,uf,ibge,ddd,siafi);
    }
}
