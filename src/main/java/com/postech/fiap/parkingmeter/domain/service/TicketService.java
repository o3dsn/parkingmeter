package com.postech.fiap.parkingmeter.domain.service;

import com.postech.fiap.parkingmeter.domain.model.dto.TicketDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    Page<TicketDTO> findAll(Pageable pageable);

    TicketDTO getById(String id);

    TicketDTO create(TicketDTO ticket);

    void deleteById(String id);
}
