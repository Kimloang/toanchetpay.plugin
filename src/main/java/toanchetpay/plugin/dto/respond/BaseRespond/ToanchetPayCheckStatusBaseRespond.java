package toanchetpay.plugin.dto.respond.baseRespond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import toanchetpay.plugin.dto.respond.ToanchetCheckTransactionRespond;

public class ToanchetPayCheckStatusBaseRespond {
    @JsonProperty("TxDirection")
    private int TxDirection;
    private int code;
    private String errorDetails;
    private String sessionid;
    @JsonProperty("xTran")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private ToanchetCheckStatusExtendRespond xTran;
    private int purchaseAmount;

    public int getTxDirection() { return TxDirection; }
    public void setTxDirection(int txDirection) { TxDirection = txDirection; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getErrorDetails() { return errorDetails; }
    public void setErrorDetails(String errorDetails) { this.errorDetails = errorDetails; }

    public String getSessionid() { return sessionid; }
    public void setSessionid(String sessionid) { this.sessionid = sessionid; }

    public ToanchetCheckStatusExtendRespond getXTran() { return xTran; }
    public void setXTran(ToanchetCheckStatusExtendRespond xTran) { this.xTran = xTran; }
}
