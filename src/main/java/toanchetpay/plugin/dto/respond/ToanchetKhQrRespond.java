package toanchetpay.plugin.dto.respond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import toanchetpay.plugin.dto.respond.baseRespond.ToanchetPayKhQrBaseResultRespond;

public class ToanchetKhQrRespond {
    private Result result;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Result getResult() { return result; }
    public void setResult(Result result) { this.result = result; }
    public static class Result  extends ToanchetPayKhQrBaseResultRespond {
        private String qrValue;
        public String getQrValue() {
            return qrValue;
        }
        public void setQrValue(String qrValues) {
            this.qrValue = qrValues;
        }
    }

}
