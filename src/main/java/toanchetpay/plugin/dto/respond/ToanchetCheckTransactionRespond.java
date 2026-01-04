//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package toanchetpay.plugin.dto.respond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import toanchetpay.plugin.dto.respond.baseRespond.ToanchetPayCheckStatusBaseRespond;
import toanchetpay.plugin.dto.respond.baseRespond.ToanchetPayKhQrBaseResultRespond;

public class ToanchetCheckTransactionRespond {
    private Result result;
    public ToanchetCheckTransactionRespond() {
    }
    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result extends ToanchetPayCheckStatusBaseRespond {
        public Result() {
        }
        private String customerName;
        private String paymentMethod;
        private String bankName;
        private String mobileRef;

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

    }
}
