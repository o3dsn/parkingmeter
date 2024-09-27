package com.postech.fiap.parkingmeter.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Ticket {
    @Id
    private String id;
    private double valorTotalCobrado;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;
    private StatusPagamento statusPagamento;
    @DBRef
    private ParkingMeter parquimetro;
    @DBRef
    private Vehicle veiculo;

    public enum StatusPagamento {
        CANCELADO,
        PENDENTE,
        PAGO
    }
}
