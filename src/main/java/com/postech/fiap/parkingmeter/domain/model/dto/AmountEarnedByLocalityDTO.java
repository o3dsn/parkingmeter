package com.postech.fiap.parkingmeter.domain.model.dto;

import com.postech.fiap.parkingmeter.domain.model.parkingmeter.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmountEarnedByLocalityDTO {

  private String id;
  private Address endereco;
  private Double earned;
}
