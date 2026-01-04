package toanchetpay.plugin.dto.respond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import toanchetpay.plugin.dto.respond.baseRespond.ToanchetPayKhQrBaseResultRespond;

public class ToanChetMPGSRespond {
    private ToanChetMPGSRespond.Result result;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public ToanChetMPGSRespond.Result getResult() { return result; }
    public void setResult(ToanChetMPGSRespond.Result result) { this.result = result; }

    public static class Result  extends ToanchetPayKhQrBaseResultRespond {
    }
}
