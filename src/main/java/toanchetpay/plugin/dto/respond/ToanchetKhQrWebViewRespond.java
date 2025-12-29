package toanchetpay.plugin.dto.respond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import toanchetpay.plugin.dto.respond.BaseRespond.ToanchetPayKhQrBaseResultRespond;

public class ToanchetKhQrWebViewRespond {
    private ToanchetPayKhQrBaseResultRespond result;
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("result")
    public ToanchetPayKhQrBaseResultRespond getResult() { return result; }
    public void setResult(ToanchetPayKhQrBaseResultRespond result) { this.result = result; }
}
