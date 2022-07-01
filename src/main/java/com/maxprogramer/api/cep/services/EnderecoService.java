package com.maxprogramer.api.cep.services;

import com.maxprogramer.api.cep.dtos.EnderecoDto;
import com.maxprogramer.api.cep.models.EnderecoModel;
import com.maxprogramer.api.cep.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import javax.transaction.Transactional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public EnderecoDto getEnderecoByCEPNaAPI(String cep){
        RestTemplate restTemplate = new RestTemplate();
        String urlResource = "https://viacep.com.br/ws/" + cep + "/json";
        EnderecoDto possivelEnderecoDto = restTemplate.getForObject(urlResource,EnderecoDto.class);
        return possivelEnderecoDto;
    }

    @Transactional
    public void saveEndereco(String cep){
        EnderecoDto enderecoDtoPesquisado = getEnderecoByCEPNaAPI(cep);
        EnderecoModel novoEndereco = enderecoDtoPesquisado.novoEndereco();
        if(novoEndereco.getCep() != null){
            enderecoRepository.save(novoEndereco);
            System.out.println("CEP " + novoEndereco.getCep() + " cadastrado com sucesso!");
        }else{
            System.err.println("CEP Inválido!");
        }
    }
    public EnderecoModel getEnderecoByCEPOnDB(String cep){
        return enderecoRepository.getEnderecoBycep(cep);
    }

    public Page<EnderecoModel> getAllEnderecos(Pageable page){
        return enderecoRepository.findAll(page);
    }
}
