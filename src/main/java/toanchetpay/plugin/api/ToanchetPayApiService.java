package toanchetpay.plugin.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import toanchetpay.plugin.app.EToanChetOperation;
import toanchetpay.plugin.app.ToanChetPayConst;
import toanchetpay.plugin.core.ApiClient;
import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.request.ToanchetKhQrRequest;
import toanchetpay.plugin.dto.respond.ToanChetDeepLinkRespond;
import toanchetpay.plugin.dto.respond.ToanchetKhQrRespond;
import toanchetpay.plugin.dto.respond.ToanchetKhQrWebViewRespond;
import toanchetpay.plugin.util.ToanChetUtil;

public class ToanchetPayApiService {
    private final ApiClient apiClient;
    public ToanchetPayApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ToanchetKhQrRespond generateKhQr(ToanchetKhQrRequest openSessionRequest) throws JsonProcessingException {
        String hash = ToanChetUtil.buildHashForOpenSession(openSessionRequest,apiClient.toanchetPayRoot.secretKey());
        openSessionRequest.setHash(hash);
        openSessionRequest.getXpayTransaction().setOperationType(EToanChetOperation.KHQR);
        return  apiClient.post(ToanChetPayConst.defalutEndPoint,openSessionRequest, ToanchetKhQrRespond.class);
    }

    public ToanchetKhQrWebViewRespond generateKhQrWebView(ToanchetKhQrRequest openSessionRequest) throws JsonProcessingException {
        String hash = ToanChetUtil.buildHashForOpenSession(openSessionRequest,apiClient.toanchetPayRoot.secretKey());
        openSessionRequest.setHash(hash);
        openSessionRequest.getXpayTransaction().setOperationType(EToanChetOperation.KHQR_WEB_VIEW);
        return  apiClient.post(ToanChetPayConst.defalutEndPoint,openSessionRequest, ToanchetKhQrWebViewRespond.class);
    }

    public ToanChetDeepLinkRespond deeplink(ToanchetDeeplinkRequest toanchetDeeplinkRequest) throws JsonProcessingException {
        String hash = ToanChetUtil.buildHashForOpenSession(toanchetDeeplinkRequest,apiClient.toanchetPayRoot.secretKey());
        toanchetDeeplinkRequest.setHash(hash);
        String path = ToanChetPayConst.defalutEndPoint;
        return  apiClient.post(ToanChetPayConst.defalutEndPoint,toanchetDeeplinkRequest, ToanChetDeepLinkRespond.class);
    }
}
