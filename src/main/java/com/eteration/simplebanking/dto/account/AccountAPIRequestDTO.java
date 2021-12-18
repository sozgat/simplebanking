package com.eteration.simplebanking.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AccountAPIRequestDTO {

    @NotEmpty(message = "Owner field is mandatory.")
    @JsonProperty(value = "owner")
    private String owner;

    @NotNull(message = "Balance field is mandatory.")
    @JsonProperty(value = "balance")
    private BigDecimal balance;
}
