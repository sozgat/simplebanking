package com.eteration.simplebanking.constant;

public abstract class ApplicationConstant {
    private ApplicationConstant() {
    }

    // db constants
    public static final String TABLE_PREFIX = "sb_";

    // Generic column names
    public static final String UUID = "uuid";
    public static final String UUID_STRATEGY = "org.hibernate.id.UUIDGenerator";
    public static final String ID_COLUMN_NAME = "id";
    public static final String CREATE_DATE = "create_date";
    public static final String UPDATE_DATE = "update_date";

    //Entity Names
    public static final String ACCOUNT_ENTITY = "Account";
    public static final String TRANSACTION_ENTITY = "Transaction";

    // Table names
    public static final String ACCOUNT = TABLE_PREFIX + "account";
    public static final String TRANSACTION = TABLE_PREFIX + "transaction";


    // Column Names for Account
    public static final String OWNER = "owner";
    public static final String ACCOUNT_NUMBER ="account_number";
    public static final String BALANCE = "balance";

    // Column Names for Transaction
    public static final String AMOUNT = "amount";
    public static final String TRANSACTION_TYPE = "type";
    public static final String APPROVAL_CODE = "approval_code";
    public static final String TRANSACTION_DATE = "date";

}
