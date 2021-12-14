package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.eteration.simplebanking.constant.ApplicationConstant.*;


@Data
@Entity(name = ACCOUNT_ENTITY)
@Table(name = ACCOUNT)
public class Account{

    @Id
    @GeneratedValue(generator = UUID)
    @GenericGenerator(name = UUID, strategy = UUID_STRATEGY)
    @Column(name = "id", insertable = false, updatable = false)
    private String id;

    @Column(name = OWNER)
    private String owner;

    @Column(name = ACCOUNT_NUMBER)
    private String accountNumber;

    @Column(name = BALANCE)
    private Double balance;

    @CreationTimestamp
    @Column(name = CREATE_DATE)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = UPDATE_DATE)
    private LocalDateTime updatedDate;

    @PrePersist
    public void setCreateDate() {
        this.createDate = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateDate() {
        this.updatedDate = LocalDateTime.now();
    }

    protected Account() {
    }

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double credit) {
        balance += credit;
    }

    public void withdraw(double debit) throws InsufficientBalanceException {
        if (balance < debit ) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance -= debit;

    }


}
