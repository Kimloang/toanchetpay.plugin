package toanchetpay.plugin.util;

import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.request.ToanchetKhQrRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class HashUtil {
    public static String buildHashForOpenSession(
            String loginId,
            String password,
            String merchantId,
            String txtId,
            String secretKey
    ) {
        String raw = merchantId + loginId + password + txtId;
        return hmacHex(raw,secretKey).toUpperCase();
    }

    public static String buildHashForOpenSession(
            ToanchetKhQrRequest openSessionRequest,
            String secretKey
    ) {
        String raw = openSessionRequest.getMerchantID()  + openSessionRequest.getLoginId() + openSessionRequest.getPassword() + openSessionRequest.getXpayTransaction().getTxid();
        return hmacHex(raw,secretKey).toUpperCase();
    }
    public static String buildHashForOpenSession(
            ToanchetDeeplinkRequest openSessionRequest,
            String secretKey
    ) {
        String raw = openSessionRequest.getMerchantID()  + openSessionRequest.getLoginId() + openSessionRequest.getPassword() + openSessionRequest.getXpayTransaction().getTxid();
        return hmacHex(raw,secretKey).toUpperCase();
    }

    public static String hmacHex(String message, String key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA512");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA512");
            mac.init(secretKey);
            byte[] bytes = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));

            StringBuilder hex = new StringBuilder();
            for (byte b : bytes) hex.append(String.format("%02X", b));
            return hex.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
