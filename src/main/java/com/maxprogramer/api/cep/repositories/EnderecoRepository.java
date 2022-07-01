package com.maxprogramer.api.cep.repositories;

import com.maxprogramer.api.cep.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel,Long> {
    public EnderecoModel getEnderecoBycep(String cep);
}
