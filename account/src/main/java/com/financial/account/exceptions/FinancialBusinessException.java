package com.financial.account.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinancialBusinessException extends RuntimeException {
    private  String errMsgKey;
    private  String errorCode;

    public FinancialBusinessException(ErrorCode code) {
        super(code.getErrMsgKey());
        this.errMsgKey = code.getErrMsgKey();
        this.errorCode = code.getErrCode();
    }

    public FinancialBusinessException(String message) {
        super(message);
    }
}
