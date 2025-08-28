package com.elcafetentacion.api.infrastructure.web.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcafetentacion.api.domain.ports.in.IClientUseCases;
import com.elcafetentacion.api.infrastructure.mapper.ClientMapper;
import com.elcafetentacion.api.infrastructure.web.dto.ClientRequestDTO;
import com.elcafetentacion.api.infrastructure.web.dto.ClientResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientUseCases clientUseCases;
    private final ClientMapper mapper;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@Valid @RequestBody ClientRequestDTO requestDTO) {
        return ResponseEntity.ok(mapper.toResponseDTO(clientUseCases.save(mapper.toDomain(requestDTO))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getById(@PathVariable Long id) {
        return clientUseCases.getById(id)
                .map(client -> ResponseEntity.ok(mapper.toResponseDTO(client)))
                .orElse(ResponseEntity.notFound().build());
    }

}
