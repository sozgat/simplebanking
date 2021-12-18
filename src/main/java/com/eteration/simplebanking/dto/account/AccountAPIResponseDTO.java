package com.eteration.simplebanking.dto.account;

import lombok.Data;

import java.util.Date;

@Data
public class AccountAPIResponseDTO  {
    private String accountNumber;
    private String owner;
    private Date createDate;
}
