package com.eteration.simplebanking.dto.account;

import com.eteration.simplebanking.model.Transaction;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class AccountAPIResponseDTO  {
    private String accountNumber;
    private String owner;
    private Date createDate;
}
