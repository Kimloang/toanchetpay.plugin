package toanchetpay.plugin.dto.request.BaseRequest;

import toanchetpay.plugin.util.ToanChetUtil;

public class OpenSessionXpayTransactionBaseRequest {
    private String txid;
    private String purchaseAmount;
    private String purchaseCurrency;
    private String purchaseDate;
    private String purchaseDesc;
    private String invoiceid;
    private String item;
    private String quantity;
    private String expiryTime;
    private String paymentCard;



    public String getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(String paymentCard) {
        this.paymentCard = paymentCard;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(int expiryTime) {
        this.expiryTime = ToanChetUtil.toanchetCastValue(expiryTime);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity =  ToanChetUtil.toanchetCastValue(quantity);
    }

    public String getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item =  ToanChetUtil.toanchetCastValue(item);;
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
}
