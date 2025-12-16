package toanchetpay.plugin.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.contract.IToanchetPayBaseContract;
import toanchetpay.plugin.dto.request.BaseRequest.OpenSessionBaseRequest;

public class ToanchetDeeplinkRequest extends OpenSessionBaseRequest implements IToanchetPayBaseContract {
    @Override
    public void setCredentials(ToanchetPayRoot toanchetPayRoot) {
        super.setLoginId(toanchetPayRoot.loginId());
        super.setPassword(toanchetPayRoot.password());
        super.setMerchantID(toanchetPayRoot.merchantId());
    }
    private ToanchetDeeplinkRequest.XPayTransaction xpayTransaction;
    public ToanchetDeeplinkRequest.XPayTransaction getXpayTransaction() {
        return xpayTransaction;
    }
    public void setXpayTransaction(ToanchetDeeplinkRequest.XPayTransaction xpayTransaction) {
        this.xpayTransaction = xpayTransaction;
    }
    public static  class XPayTransaction {

        @JsonProperty("txid")
        private String txid;

        @JsonProperty("purchaseAmount")
        private String purchaseAmount;

        @JsonProperty("purchaseCurrency")
        private String purchaseCurrency;

        @JsonProperty("purchaseDate")
        private String purchaseDate;

        @JsonProperty("purchaseDesc")
        private String purchaseDesc;

        @JsonProperty("invoiceid")
        private String invoiceid;

        @JsonProperty("item")
        private String item;

        @JsonProperty("quantity")
        private String quantity;

        @JsonProperty("expiryTime")
        private String expiryTime;

        @JsonProperty("oprDevice")
        private String oprDevice;

        @JsonProperty("callBackUrl")
        private String callBackUrl;

        @JsonProperty("compName")
        private String compName;

        // Getters & Setters
        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
        }

        public String getPurchaseAmount() {
            return purchaseAmount;
        }

        public void setPurchaseAmount(String purchaseAmount) {
            this.purchaseAmount = purchaseAmount;
        }

        public String getPurchaseCurrency() {
            return purchaseCurrency;
        }

        public void setPurchaseCurrency(String purchaseCurrency) {
            this.purchaseCurrency = purchaseCurrency;
        }

        public String getPurchaseDate() {
            return purchaseDate;
        }

        public void setPurchaseDate(String purchaseDate) {
            this.purchaseDate = purchaseDate;
        }

        public String getPurchaseDesc() {
            return purchaseDesc;
        }

        public void setPurchaseDesc(String purchaseDesc) {
            this.purchaseDesc = purchaseDesc;
        }

        public String getInvoiceid() {
            return invoiceid;
        }

        public void setInvoiceid(String invoiceid) {
            this.invoiceid = invoiceid;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getExpiryTime() {
            return expiryTime;
        }

        public void setExpiryTime(String expiryTime) {
            this.expiryTime = expiryTime;
        }

        public String getOprDevice() {
            return oprDevice;
        }

        public void setOprDevice(String oprDevice) {
            this.oprDevice = oprDevice;
        }

        public String getCallBackUrl() {
            return callBackUrl;
        }

        public void setCallBackUrl(String callBackUrl) {
            this.callBackUrl = callBackUrl;
        }

        public String getCompName() {
            return compName;
        }

        public void setCompName(String compName) {
            this.compName = compName;
        }
    }
}
