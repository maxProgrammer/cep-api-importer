package com.maxprogramer.api.cep.controllers;

import com.maxprogramer.api.cep.dtos.EnderecoDto;
import com.maxprogramer.api.cep.models.EnderecoModel;
import com.maxprogramer.api.cep.services.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;

    @GetMapping(value = "api/consulta/API")
    @Operation(summary = "Consulta um endereço por CEP na API")
    public EnderecoDto getEnderecoByCep(String cep) {
        return enderecoService.getEnderecoByCEPNaAPI(cep);
    }

    @GetMapping(value = "api/consulta/{cep}")
    @Operation(summary = "Consulta um endereço por CEP no DB")
    public EnderecoModel getEnderecoByCEPOnDB(String cep) {
        return enderecoService.getEnderecoByCEPOnDB(cep);
    }

    @GetMapping(value = "api/consulta/todos")
    @Operation(summary = "Consulta todos endereços no DB")
    public Page<EnderecoModel> getAllEnderecos(@PageableDefault(size = 10,page = 0, sort = "id",direction = Sort.Direction.ASC)Pageable page){
        return enderecoService.getAllEnderecos(page);
    }


    @PostMapping(value = "api/add/endereco")
    @Operation(summary = "Add endereço por CEP")
    public void adicionaEndereco(@RequestBody String cep) {
        enderecoService.saveEndereco(cep);
    }
}
