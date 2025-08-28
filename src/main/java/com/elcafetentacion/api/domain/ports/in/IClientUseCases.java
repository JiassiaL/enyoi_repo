package com.elcafetentacion.api.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.elcafetentacion.api.domain.model.Client;

public interface IClientUseCases {
    Optional<Client> getById(Long id);
    List<Client> findAll();
    Client save(Client client);
    void deleteById(Long id);
    Client update(Long id, Client client);
}
