package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.eteration.simplebanking.constant.ApplicationConstant.*;


@Data
@Entity(name = ACCOUNT_ENTITY)
@Table(name = ACCOUNT)
public class Account{

    @Id
    @GeneratedValue(generator = UUID)
    @GenericGenerator(name = UUID, strategy = UUID_STRATEGY)
    @Column(name = ID_COLUMN_NAME, insertable = false, updatable = false)
    private String id;

    @Column(name = OWNER)
    private String owner;

    @Column(name = ACCOUNT_NUMBER)
    private String accountNumber;

    @Column(name = BALANCE)
    private Double balance;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<Transaction> transactions;

    @Column(name = CREATE_DATE)
    private Date createDate;

    protected Account() {
    }

    public Account(String owner, String accountNumber) {
        this.id="1";
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.createDate = new Date();
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

    public void post(Transaction transaction) throws InsufficientBalanceException {
        try {
            transaction.doTransaction(this);
        } finally {
            transactions.add(transaction);
        }
    }


}
