package com.eteration.simplebanking.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AccountAPIRequestDTO {

    @NotEmpty(message = "Amount field is mandatory.")
    @JsonProperty(value = "amount")
    private double amount;
}
