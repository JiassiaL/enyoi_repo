package com.elcafetentacion.api.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elcafetentacion.api.domain.model.Client;
import com.elcafetentacion.api.domain.ports.in.IClientUseCases;
import com.elcafetentacion.api.domain.ports.out.IClientPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientUseCases {

    private final IClientPersistencePort clientPersistencePort;

    @Override
    public Optional<Client> getById(Long id) {
        return Optional.ofNullable(
                clientPersistencePort.getById(id)
                        .orElseThrow(() -> new RuntimeException("Client not found with id: " + id)));

    }

    @Override
    public List<Client> findAll() {
        return clientPersistencePort.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientPersistencePort.save(client);
    }

    @Override
    public void deleteById(Long id) {
        clientPersistencePort.deleteById(id);
    }

    @Override
    public Client update(Long id, Client client) {
        Client existingClient = clientPersistencePort.getById(id).orElseThrow(
                () -> new IllegalArgumentException("client not found"));
        existingClient.setAddress(client.getAddress());
        existingClient.setDocument(client.getDocument());
        existingClient.setCellphone(client.getCellphone());
        existingClient.setDocumentType(client.getDocumentType());
        existingClient.setEmail(client.getEmail());
        existingClient.setCity(client.getCity());
        return clientPersistencePort.save(existingClient);
    }

}
