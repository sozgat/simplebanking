package com.eteration.simplebanking.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.eteration.simplebanking.constant.ApplicationConstant.*;

@Data
@Entity(name = TRANSACTION_ENTITY)
@Table(name = TRANSACTION)
public abstract class Transaction {

    @Id
    @GeneratedValue(generator = UUID)
    @GenericGenerator(name = UUID, strategy = UUID_STRATEGY)
    @Column(name = ID_COLUMN_NAME, insertable = false, updatable = false)
    private String id;

    @CreationTimestamp
    @Column(name = TRANSACTION_DATE)
    private LocalDateTime date;

    @Column(name = AMOUNT)
    public double amount;

    @Column(name = TRANSACTION_TYPE)
    private String type;

    @Column(name = APPROVAL_CODE)
    private String approvalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @UpdateTimestamp
    @Column(name = UPDATE_DATE)
    private LocalDateTime updatedDate;

    protected Transaction() {
    }

    @PrePersist
    public void setDate() {
        this.date = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateDate() {
        this.updatedDate = LocalDateTime.now();
    }

    protected Transaction(double amount) {
        this.id = java.util.UUID.randomUUID().toString();
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.type=this.getClass().getSimpleName();
    }

    public abstract void doTransaction(Account account) throws InsufficientBalanceException;

}
