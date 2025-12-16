package toanchetpay.plugin;

import com.fasterxml.jackson.core.JsonProcessingException;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.respond.ToanChetDeepLinkRespond;

public class ToanchetPayClient {
    public static void main(String[] args) throws JsonProcessingException {
        

        ToanchetDeeplinkRequest openSessionRequest = new ToanchetDeeplinkRequest();
        openSessionRequest.setCredentials(client);
//        ToanchetKhQrRequest.XpayTransaction tx = new ToanchetKhQrRequest.XpayTransaction();
//        tx.setTxid("MPT00000003");
//        tx.setPurchaseAmount("100");
//        tx.setPurchaseCurrency("KHR");
//        tx.setPurchaseDesc("mobile");
//        tx.setPurchaseDate("09-12-2025");
//        tx.setItem("1");
//        tx.setQuantity("1");
//        tx.setExpiryTime("5");
//        tx.setInvoiceid("INV0000001");
//        tx.setOperationType("5");
//        tx.setExpiryTime("5");
//        openSessionRequest.setXpayTransaction(tx);
//        ToanchetPaySdk toanchetPaySdk = new ToanchetPaySdk(client);
//        ToanchetKhQrRespond khQrResponse = toanchetPaySdk.apiService.generateKhQr(openSessionRequest);

        ToanchetDeeplinkRequest.XPayTransaction tx = new ToanchetDeeplinkRequest.XPayTransaction();
        tx.setTxid("MPT00000003");
        tx.setPurchaseAmount("150");
        tx.setPurchaseCurrency("KHR");
        tx.setPurchaseDesc("mobile");
        tx.setPurchaseDate("09-12-2025");
        tx.setItem("1");
        tx.setQuantity("1");
        tx.setExpiryTime("5");
        tx.setInvoiceid("INV0000001");
        tx.setExpiryTime("5");
        tx.setOprDevice("android");
        tx.setCallBackUrl("appmobile://merchant.com.kh/callback");
        tx.setCompName("Hello World");

        openSessionRequest.setXpayTransaction(tx);
        ToanchetPaySdk toanchetPaySdk = new ToanchetPaySdk(client);
        ToanChetDeepLinkRespond deeplinkResponse  = toanchetPaySdk.apiService.deeplink(openSessionRequest);
        System.out.println("Detected Deeplink " + deeplinkResponse.getResult().getDeeplinkUrl());

    }
}
