package toanchetpay.plugin.dto.respond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import toanchetpay.plugin.dto.respond.baseRespond.ToanchetMPGSBaseResultRespond;
import toanchetpay.plugin.dto.respond.baseRespond.ToanchetPayCheckStatusBaseRespond;

public class ToanchetMPGSCheckTransctaionRespond {
    private ToanchetMPGSCheckTransctaionRespond.Result result;
    public ToanchetMPGSCheckTransctaionRespond() {
    }
    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public ToanchetMPGSCheckTransctaionRespond.Result getResult() {
        return this.result;
    }

    public void setResult(ToanchetMPGSCheckTransctaionRespond.Result result) {
        this.result = result;
    }

    public static class Result extends ToanchetPayCheckStatusBaseRespond {
        public Result() {
        }
        private String customerName;
        private String paymentMethod;
        private String bankName;
        private String mobileRef;
        @JsonProperty("getTxnStatusMPGS")
        private ToanchetMPGSBaseResultRespond getTxnStatusMPGS;

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getMobileRef() {
            return mobileRef;
        }

        public void setMobileRef(String mobileRef) {
            this.mobileRef = mobileRef;
        }
        public String getCustomerName() {
            return this.customerName;
        }
        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }
        public String getPaymentMethod() {
            return this.paymentMethod;
        }
        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }
        public ToanchetMPGSBaseResultRespond getGetTxnStatusMPGS() {return getTxnStatusMPGS;}
        public void setGetTxnStatusMPGS(ToanchetMPGSBaseResultRespond getTxnStatusMPGS) {this.getTxnStatusMPGS = getTxnStatusMPGS;}


    }
}
