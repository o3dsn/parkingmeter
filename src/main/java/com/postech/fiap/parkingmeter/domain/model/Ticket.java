package com.postech.fiap.parkingmeter.domain.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ticket")
@Data
public class Ticket {
  @Id private String id;

  @Valid
  @NotNull
  @Field("valor_total_cobrado")
  private double valorTotalCobrado;

  @Valid
  @NotNull
  @Indexed
  @Field("horario_inicio")
  private LocalDateTime horarioInicio;

  @Valid
  @Indexed
  @Field("horario_fim")
  private LocalDateTime horarioFim;

  @Valid
  @NotNull
  @Indexed
  @Field("status_pagamento")
  private StatusPagamento statusPagamento;

  @Valid
  @NotNull
  @Indexed
  private ParkingMeter parquimetro;

  @Valid
  @NotNull
  @Indexed
  private Vehicle veiculo;

  public enum StatusPagamento {
    CANCELADO,
    PENDENTE,
    PAGO
  }
}
