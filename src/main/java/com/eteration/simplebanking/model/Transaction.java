package com.eteration.simplebanking.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

import static com.eteration.simplebanking.constant.ApplicationConstant.*;

@Data
@Entity(name = TRANSACTION_ENTITY)
@Table(name = TRANSACTION)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Transaction {

    @Id
    @GeneratedValue(generator = UUID)
    @GenericGenerator(name = UUID, strategy = UUID_STRATEGY)
    @Column(name = ID_COLUMN_NAME, insertable = false, updatable = false)
    private String id;

    @Column(name = TRANSACTION_DATE)
    private Date date;

    @Column(name = AMOUNT)
    public double amount;

    @Column(name = TRANSACTION_TYPE, insertable = false, updatable = false)
    private String type;

    @Column(name = APPROVAL_CODE)
    private String approvalCode;

    protected Transaction() {
    }

    protected Transaction(double amount) {
        this.id = java.util.UUID.randomUUID().toString();
        this.amount = amount;
        this.date = new Date();
        this.type=this.getClass().getSimpleName();
        this.approvalCode = java.util.UUID.randomUUID().toString();
    }

    public abstract void doTransaction(Account account) throws InsufficientBalanceException;

}
