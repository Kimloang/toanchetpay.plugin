package toanchetpay.plugin.dto.respond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import toanchetpay.plugin.dto.respond.baseRespond.ToanchetPayKhQrBaseResultRespond;

public class ToanChetDeepLinkRespond {
    private ToanChetDeepLinkRespond.Result result;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public ToanChetDeepLinkRespond.Result getResult() { return result; }
    public void setResult(ToanChetDeepLinkRespond.Result result) { this.result = result; }

    public static class Result  extends ToanchetPayKhQrBaseResultRespond {
        private String deeplinkUrl;
        public String getDeeplinkUrl() {
            return deeplinkUrl;
        }
        public void setDeeplinkUrl(String deeplinkUrl) {
            this.deeplinkUrl = deeplinkUrl;
        }
    }
}
