package toanchetpay.plugin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenSessionResultDto {
    @JsonProperty("TxDirection")
    int txDirection;
    int code;
    String errorDetails;
    String sessionid;
//    OpenSessionXtransactionDto xTran;
    String qrValue;
    int purchaseAmount;

    public int getTxDirection() {
        return txDirection;
    }

    public void setTxDirection(int txDirection) {
        this.txDirection = txDirection;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

//    public OpenSessionXtransactionDto getxTran() {
//        return xTran;
//    }
//
//    public void setxTran(OpenSessionXtransactionDto xTran) {
//        this.xTran = xTran;
//    }

    public String getQrValue() {
        return qrValue;
    }

    public void setQrValue(String qrValue) {
        this.qrValue = qrValue;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

}
