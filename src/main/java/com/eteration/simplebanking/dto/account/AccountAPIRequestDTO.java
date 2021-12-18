package com.eteration.simplebanking.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AccountAPIRequestDTO {

    @NotEmpty(message = "Owner field is mandatory.")
    @JsonProperty(value = "owner")
    private String owner;
}
