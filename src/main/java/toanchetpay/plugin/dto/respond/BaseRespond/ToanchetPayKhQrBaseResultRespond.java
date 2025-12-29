package toanchetpay.plugin.dto.respond.BaseRespond;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToanchetPayKhQrBaseResultRespond {
    @JsonProperty("TxDirection")
    private int TxDirection;
    private int code;
    private String errorDetails;
    private String sessionid;
    @JsonProperty("xTran")
    private toanchetpay.plugin.dto.respond.baseRespond.ToanchetBaseResultRespond xTran;
    private int purchaseAmount;

    public int getTxDirection() { return TxDirection; }
    public void setTxDirection(int txDirection) { TxDirection = txDirection; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getErrorDetails() { return errorDetails; }
    public void setErrorDetails(String errorDetails) { this.errorDetails = errorDetails; }

    public String getSessionid() { return sessionid; }
    public void setSessionid(String sessionid) { this.sessionid = sessionid; }

    public toanchetpay.plugin.dto.respond.baseRespond.ToanchetBaseResultRespond getXTran() { return xTran; }
    public void setXTran(toanchetpay.plugin.dto.respond.baseRespond.ToanchetBaseResultRespond xTran) { this.xTran = xTran; }


    public int getPurchaseAmount() { return purchaseAmount; }
    public void setPurchaseAmount(int purchaseAmount) { this.purchaseAmount = purchaseAmount; }
}
