package toanchetpay.plugin.dto.respond;

import com.fasterxml.jackson.annotation.JsonProperty;
import toanchetpay.plugin.dto.respond.BaseRespond.ToanchetBaseResultRespond;

public class ToanChetDeepLinkRespond {
    private ToanchetKhQrRespond.Result result;

    public ToanchetKhQrRespond.Result getResult() { return result; }
    public void setResult(ToanchetKhQrRespond.Result result) { this.result = result; }

    public static class Result {
        public int getTxDirection() {
            return TxDirection;
        }

        public void setTxDirection(int txDirection) {
            TxDirection = txDirection;
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

        public ToanchetBaseResultRespond getxTran() {
            return xTran;
        }

        public void setxTran(ToanchetBaseResultRespond xTran) {
            this.xTran = xTran;
        }

        @JsonProperty("TxDirection")
        private int TxDirection;
        private int code;
        private String errorDetails;
        private String sessionid;
        @JsonProperty("xTran")
        private ToanchetBaseResultRespond xTran;
    }
}
