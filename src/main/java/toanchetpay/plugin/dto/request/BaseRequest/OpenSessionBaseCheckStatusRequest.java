package toanchetpay.plugin.dto.request.baseRequest;

public class OpenSessionBaseCheckStatusRequest {
    private String loginId;
    private String password;
    private String merchantId;
    private String hash;

    public String getHash() {
        return hash;
    }

    protected void setHash(String hash) {
        this.hash = hash;
    }

    public String getMerchantId() {
        return merchantId;
    }

    protected void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public String getLoginId() {
        return loginId;
    }

    protected void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
