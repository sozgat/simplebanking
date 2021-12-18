package com.eteration.simplebanking.constant;

public abstract class MappingConstant {

    public static final String API_VERSION = "/v1";

    public static final String ACCOUNT_PATH = "/account";
    public static final String TRANSACTION_PATH = "/transaction";

    public static final String ACCOUNT_CONTROLLER_PATH = ACCOUNT_PATH + API_VERSION;
    public static final String TRANSACTION_CONTROLLER_PATH = TRANSACTION_PATH + API_VERSION;


    public static final String ACCOUNT_POST_CREDIT = "/credit";
    public static final String ACCOUNT_POST_DEBIT = "/debit";
    public static final String NEW_ACCOUNT_POST = "/new";


    private MappingConstant(){
        throw new IllegalStateException("MappingConstant class");
    }

}
