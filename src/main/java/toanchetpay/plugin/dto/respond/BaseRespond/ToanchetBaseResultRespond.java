package toanchetpay.plugin.dto.respond.baseRespond;

public class ToanchetBaseResultRespond {
    private int purchaseAmount;
    private long purchaseDate;
    private int quantity;
    private String paymentTokenid;
    private int expiryTime;
    private long confirmDate;
    private int purchaseType;
    private int feeAmount;
    private int operationType;

    public int getPurchaseAmount() { return purchaseAmount; }
    public void setPurchaseAmount(int purchaseAmount) { this.purchaseAmount = purchaseAmount; }

    public long getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(long purchaseDate) { this.purchaseDate = purchaseDate; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getPaymentTokenid() { return paymentTokenid; }
    public void setPaymentTokenid(String paymentTokenid) { this.paymentTokenid = paymentTokenid; }

    public int getExpiryTime() { return expiryTime; }
    public void setExpiryTime(int expiryTime) { this.expiryTime = expiryTime; }

    public long getConfirmDate() { return confirmDate; }
    public void setConfirmDate(long confirmDate) { this.confirmDate = confirmDate; }

    public int getPurchaseType() { return purchaseType; }
    public void setPurchaseType(int purchaseType) { this.purchaseType = purchaseType; }

    public int getFeeAmount() { return feeAmount; }
    public void setFeeAmount(int feeAmount) { this.feeAmount = feeAmount; }

    public int getOperationType() { return operationType; }
    public void setOperationType(int operationType) { this.operationType = operationType; }
}
