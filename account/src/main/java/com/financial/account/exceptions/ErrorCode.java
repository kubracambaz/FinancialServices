package com.financial.account.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INITIAL_CREDIT_EXCEPTION("ERR-001", "Initial credit should not be less than zero!"),
    NO_CUSTOMER_EXCEPTION("ERR-002", "Customer not found!");

    private String errCode;
    private String errMsgKey;

    private ErrorCode(final String errCode, final String errMsgKey) {
        this.errCode = errCode;
        this.errMsgKey = errMsgKey;
    }
}
