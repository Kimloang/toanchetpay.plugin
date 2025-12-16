package toanchetpay.plugin.dto.request;

import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.contract.IToanchetPayBaseContract;
import toanchetpay.plugin.dto.request.BaseRequest.OpenSessionBaseRequest;

public class ToanchetKhQrRequest extends OpenSessionBaseRequest implements IToanchetPayBaseContract {
    @Override
    public void setCredentials(ToanchetPayRoot toanchetPayRoot) {
        super.setLoginId(toanchetPayRoot.loginId());
        super.setPassword(toanchetPayRoot.password());
        super.setMerchantID(toanchetPayRoot.merchantId());
    }
    private XpayTransaction xpayTransaction;
    public XpayTransaction getXpayTransaction() {
        return xpayTransaction;
    }
    public void setXpayTransaction(XpayTransaction xpayTransaction) {
        this.xpayTransaction = xpayTransaction;
    }
    public static class XpayTransaction {
        private String txid;
        private String purchaseAmount;
        private String purchaseCurrency;

        public String getOperationType() {
            return operationType;
        }

        public void setOperationType(String operationType) {
            this.operationType = operationType;
        }

        private String operationType;

        public String getPaymentCard() {
            return paymentCard;
        }

        public void setPaymentCard(String paymentCard) {
            this.paymentCard = paymentCard;
        }

        public String getExpiryTime() {
            return expiryTime;
        }

        public void setExpiryTime(String expiryTime) {
            this.expiryTime = expiryTime;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getInvoiceid() {
            return invoiceid;
        }

        public void setInvoiceid(String invoiceid) {
            this.invoiceid = invoiceid;
        }

        public String getPurchaseDesc() {
            return purchaseDesc;
        }

        public void setPurchaseDesc(String purchaseDesc) {
            this.purchaseDesc = purchaseDesc;
        }

        public String getPurchaseDate() {
            return purchaseDate;
        }

        public void setPurchaseDate(String purchaseDate) {
            this.purchaseDate = purchaseDate;
        }

        public String getPurchaseCurrency() {
            return purchaseCurrency;
        }

        public void setPurchaseCurrency(String purchaseCurrency) {
            this.purchaseCurrency = purchaseCurrency;
        }

        public String getPurchaseAmount() {
            return purchaseAmount;
        }

        public void setPurchaseAmount(String purchaseAmount) {
            this.purchaseAmount = purchaseAmount;
        }

        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
        }

        private String purchaseDate;
        private String purchaseDesc;
        private String invoiceid;
        private String item;
        private String quantity;
        private String expiryTime;
        private String paymentCard;

        // getters & setters...
    }
}
