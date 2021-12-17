package com.eteration.simplebanking.controller;


import lombok.Data;

@Data
public class TransactionStatus {

    public final static String status = "OK";

    public String approvalCode;

    public String getStatus() {
        return status;
    }

}
