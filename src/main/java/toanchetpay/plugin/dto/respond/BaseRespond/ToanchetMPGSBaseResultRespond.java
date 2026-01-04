package toanchetpay.plugin.dto.respond.baseRespond;

public class ToanchetMPGSBaseResultRespond {
    private String authorizationCode;

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public String getReceipt() {
        return receipt;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public String getOrderId() {
        return orderId;
    }

    private String receipt;
    private String cardBrand;
    private String orderId;
}
