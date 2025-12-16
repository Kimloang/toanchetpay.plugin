package toanchetpay.plugin.dto.respond;

import com.fasterxml.jackson.annotation.JsonProperty;
import toanchetpay.plugin.dto.respond.BaseRespond.ToanchetBaseResultRespond;

public class ToanchetKhQrRespond {
    private Result result;

    public Result getResult() { return result; }
    public void setResult(Result result) { this.result = result; }
    public static class Result {
        @JsonProperty("TxDirection")
        private int TxDirection;
        private int code;
        private String errorDetails;
        private String sessionid;
        @JsonProperty("xTran")
        private ToanchetBaseResultRespond xTran;
        private String deeplinkUrl;
        private int purchaseAmount;

        public int getTxDirection() { return TxDirection; }
        public void setTxDirection(int txDirection) { TxDirection = txDirection; }

        public int getCode() { return code; }
        public void setCode(int code) { this.code = code; }

        public String getErrorDetails() { return errorDetails; }
        public void setErrorDetails(String errorDetails) { this.errorDetails = errorDetails; }

        public String getSessionid() { return sessionid; }
        public void setSessionid(String sessionid) { this.sessionid = sessionid; }

        public ToanchetBaseResultRespond getXTran() { return xTran; }
        public void setXTran(ToanchetBaseResultRespond xTran) { this.xTran = xTran; }

        public String getDeeplinkUrl() { return deeplinkUrl; }
        public void setDeeplinkUrl(String deeplinkUrl) { this.deeplinkUrl = deeplinkUrl; }

        public int getPurchaseAmount() { return purchaseAmount; }
        public void setPurchaseAmount(int purchaseAmount) { this.purchaseAmount = purchaseAmount; }
    }

}
