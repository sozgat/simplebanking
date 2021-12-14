package com.eteration.simplebanking.constant;

public abstract class ApplicationConstant {
    private ApplicationConstant() {
    }

    // db constants
    public static final String TABLE_PREFIX = "sb_";

    // Generic column names
    public static final String UUID = "uuid";
    public static final String UUID_STRATEGY = "org.hibernate.id.UUIDGenerator";
    public static final String CREATE_DATE = "create_date";
    public static final String UPDATE_DATE = "update_date";

    //Entity Names
    public static final String ACCOUNT_ENTITY = "Account";

    // Table names
    public static final String ACCOUNT = TABLE_PREFIX + "account";


    // Column Names
    public static final String OWNER = "owner";
    public static final String ACCOUNT_NUMBER ="accountNumber";
    public static final String BALANCE = "balance";

}
