package com.postech.fiap.parkingmeter.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public record TicketDTO(
    String id,
    double valorTotalCobrado,
    LocalDateTime horarioInicio,
    LocalDateTime horarioFim,
    String statusPagamento,
    ParkingMeterDTO parquimetro,
    VehicleDTO veiculo
){}
