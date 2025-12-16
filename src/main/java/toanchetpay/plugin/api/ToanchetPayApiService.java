package toanchetpay.plugin.api;
 
import com.fasterxml.jackson.core.JsonProcessingException;
import toanchetpay.plugin.app.ToanChetPayConst;
import toanchetpay.plugin.core.ApiClient;
import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.respond.ToanChetDeepLinkRespond;
import toanchetpay.plugin.dto.respond.ToanchetKhQrRespond;
import toanchetpay.plugin.dto.request.ToanchetKhQrRequest;
import toanchetpay.plugin.util.HashUtil;

public class ToanchetPayApiService {
    private final ApiClient apiClient;
    public ToanchetPayApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ToanchetKhQrRespond generateKhQr(ToanchetKhQrRequest openSessionRequest) throws JsonProcessingException {
        String hash = HashUtil.buildHashForOpenSession(openSessionRequest,apiClient.toanchetPayRoot.secretKey());
        openSessionRequest.setHash(hash);
        String path = ToanChetPayConst.defalutEndPoint;
        return  apiClient.post(path,openSessionRequest, ToanchetKhQrRespond.class);
    }

    public ToanChetDeepLinkRespond deeplink(ToanchetDeeplinkRequest toanchetDeeplinkRequest) throws JsonProcessingException {
        String hash = HashUtil.buildHashForOpenSession(toanchetDeeplinkRequest,apiClient.toanchetPayRoot.secretKey());
        toanchetDeeplinkRequest.setHash(hash);
        String path = ToanChetPayConst.defalutEndPoint;
        return  apiClient.post(path,toanchetDeeplinkRequest, ToanChetDeepLinkRespond.class);
    }
}
