package toanchetpay.plugin.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import toanchetpay.plugin.app.EToanChetOperation;
import toanchetpay.plugin.app.ToanChetPayConst;
import toanchetpay.plugin.core.ApiClient;
import toanchetpay.plugin.dto.request.ToanChetGetTransactionStatusRequest;
import toanchetpay.plugin.dto.request.ToanChetMPGSRequest;
import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.request.ToanchetKhQrRequest;
import toanchetpay.plugin.dto.respond.*;
import toanchetpay.plugin.exception.ToanChetPayException;

public class ToanchetPayApiService {
    private final ApiClient apiClient;
    public ToanchetPayApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ToanchetKhQrRespond generateKhQr(ToanchetKhQrRequest openSessionRequest) throws JsonProcessingException {
        openSessionRequest.getXpayTransaction().setOperationType(EToanChetOperation.KHQR);
        return  apiClient.post(ToanChetPayConst.defalutEndPoint,openSessionRequest, ToanchetKhQrRespond.class);
    }

    public ToanchetKhQrWebViewRespond generateKhQrWebView(ToanchetKhQrRequest openSessionRequest) throws JsonProcessingException {
        openSessionRequest.getXpayTransaction().setOperationType(EToanChetOperation.KHQR_WEB_VIEW);
        return  apiClient.post(ToanChetPayConst.defalutEndPoint,openSessionRequest, ToanchetKhQrWebViewRespond.class);
    }

    public ToanChetDeepLinkRespond deeplink(ToanchetDeeplinkRequest toanchetDeeplinkRequest) throws JsonProcessingException {
        return  apiClient.post(ToanChetPayConst.defalutEndPoint,toanchetDeeplinkRequest, ToanChetDeepLinkRespond.class);
    }

    public  <T> T  checkTransactionStatus(ToanChetGetTransactionStatusRequest toachetCheckStatus,Class<T> type) throws JsonProcessingException {
        if(type.equals(ToanchetMPGSCheckTransctaionRespond.class) ||
                type.equals(ToanchetCheckTransactionRespond.class))
            return apiClient.post(ToanChetPayConst.endPointCheckStatus, toachetCheckStatus,type);
        throw new ToanChetPayException(-1," Invalid Class To Respond");
    }

    public ToanChetMPGSRespond mpgs(ToanChetMPGSRequest toanchetDeeplinkRequest) throws JsonProcessingException {
        return  apiClient.post(ToanChetPayConst.defalutEndPoint,toanchetDeeplinkRequest, ToanChetMPGSRespond.class);
    }

}
