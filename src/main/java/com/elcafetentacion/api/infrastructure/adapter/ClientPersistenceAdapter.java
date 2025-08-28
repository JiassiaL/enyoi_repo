package com.elcafetentacion.api.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.elcafetentacion.api.domain.model.Client;
import com.elcafetentacion.api.domain.ports.out.IClientPersistencePort;
import com.elcafetentacion.api.infrastructure.jpaRepository.JpaClientRepository;
import com.elcafetentacion.api.infrastructure.mapper.ClientMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientPersistenceAdapter implements IClientPersistencePort {
    private final JpaClientRepository clientRepository;
    private final ClientMapper mapper;
    @Override
    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id).map(mapper::toDomain);
    }
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll().stream().map(mapper::toDomain).toList();
    }
    @Override
    public Client save(Client client) {
        return mapper.toDomain(clientRepository.save(mapper.toEntity(client)));
    }
   
    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
       
    }

}
