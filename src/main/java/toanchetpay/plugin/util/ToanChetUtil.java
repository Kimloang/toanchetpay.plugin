package toanchetpay.plugin.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import toanchetpay.plugin.ToanchetPaySdk;
import toanchetpay.plugin.app.EToanchetCurrency;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.dto.request.ToanChetGetTransactionStatusRequest;
import toanchetpay.plugin.dto.request.ToanChetMPGSRequest;
import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.request.ToanchetKhQrRequest;
import toanchetpay.plugin.dto.respond.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToanChetUtil {
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

    public static String buildHashForOpenSessionCheckStatus(
            String loginId,
            String password,
            String merchantId,
            String txtId,
            String secretKey
    ) {
        String raw = merchantId + loginId + password + txtId;
        return hmacHex(raw,secretKey).toUpperCase();
    }
    private static String hmacHex(String message, String key) {
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
    public  static String toanchetCastValue(int data)
    {
        return  data <=0? "5": String.valueOf(data);
    }
    public  static String toanchetCastValueToEmpty(int data) {
        return  data <=0? "" : String.valueOf(data);
    }
}
