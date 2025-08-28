package com.elcafetentacion.api.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.elcafetentacion.api.domain.model.Client;
import com.elcafetentacion.api.infrastructure.persistence.ClientEntity;
import com.elcafetentacion.api.infrastructure.web.dto.ClientRequestDTO;
import com.elcafetentacion.api.infrastructure.web.dto.ClientResponseDTO;

@Component
public class ClientMapper {
    // Domain <-> Entity
    public Client toDomain(ClientEntity entity) {
        return new Client(entity.getId(),
                entity.getName(),
                entity.getDocument(),
                entity.getDocumentType(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getCity(),
                entity.getCellphone());
    }

    public ClientEntity toEntity(Client client) {
        return new ClientEntity(client.getId(),
                client.getName(),
                client.getDocument(),
                client.getDocumentType(),
                client.getEmail(),
                client.getAddress(),
                client.getCity(),
                client.getCellphone());
    }

    // Domain <-> DTO

    public Client toDomain(ClientRequestDTO clientRequestDTO) {
        return new Client(
                null,
                clientRequestDTO.getName(),
                clientRequestDTO.getDocument(),
                clientRequestDTO.getDocumentType(),
                clientRequestDTO.getEmail(),
                clientRequestDTO.getAddress(),
                clientRequestDTO.getCity(),
                clientRequestDTO.getCellphone());
    }
    public ClientResponseDTO toResponseDTO(Client client) {
        return new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getDocument(),
                client.getDocumentType(),
                client.getEmail(),
                client.getAddress(),
                client.getCity(),
                client.getCellphone());
    }
}
