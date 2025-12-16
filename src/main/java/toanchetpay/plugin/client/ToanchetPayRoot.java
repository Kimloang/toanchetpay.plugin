package toanchetpay.plugin.client;

public class ToanchetPayRoot {
    private final String baseUrl;
    private final String loginId;
    private final String password;
    private final String merchantId;
    private final String secretKey;
    public ToanchetPayRoot(String baseUrl,
                           String loginId,
                           String password,
                           String merchantId,
                           String secretKey
    ) {
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        this.loginId = loginId;
        this.password = password;
        this.merchantId = merchantId;
        this.secretKey = secretKey;

    }
    public String baseUrl() { return baseUrl; }
    public String loginId() { return loginId; }
    public String password() { return password; }
    public String merchantId() { return merchantId; }
    public String secretKey() { return secretKey; }
}
