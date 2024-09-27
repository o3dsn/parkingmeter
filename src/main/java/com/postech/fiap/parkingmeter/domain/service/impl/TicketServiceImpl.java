package com.postech.fiap.parkingmeter.domain.service.impl;

import com.postech.fiap.parkingmeter.domain.model.Ticket;
import com.postech.fiap.parkingmeter.domain.model.dto.TicketDTO;
import com.postech.fiap.parkingmeter.domain.repository.TicketRepository;
import com.postech.fiap.parkingmeter.domain.service.TicketService;
import com.postech.fiap.parkingmeter.domain.util.ConverterToDTO;
import com.postech.fiap.parkingmeter.infrastructure.exception.ParkingMeterException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
@ImportAutoConfiguration(TransactionAutoConfiguration.class)
public class TicketServiceImpl implements TicketService {
  @Autowired private final TicketRepository ticketRepository;

  private final ConverterToDTO converterToDTO;

  @Override
  public Page<TicketDTO> findAll(Pageable pageable) {
    log.info("Find all tickets");
    return this.ticketRepository.findAll(pageable).map(this.converterToDTO::toDto);
  }

  @Override
  public TicketDTO getById(String id) {
    log.info("Find one ticket");
    var ticket =
        this.ticketRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ParkingMeterException("Ticket code does not exist", HttpStatus.NOT_FOUND));
    return converterToDTO.toDto(ticket);
  }

  @Override
  public TicketDTO create(TicketDTO ticketDTO) {
    Ticket ticket = new Ticket();

    var created = this.ticketRepository.save(ticket);
    return converterToDTO.toDto(created);
  }

  @Override
  public void deleteById(String id) {
    log.info("Delete ticket by id: {}", id);
    this.ticketRepository.deleteById(id);
  }
}
