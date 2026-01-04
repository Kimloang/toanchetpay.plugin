package toanchetpay.plugin.dto.request;

import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.contract.IToanchetPayBaseContract;
import toanchetpay.plugin.dto.request.baseRequest.OpenSessionBaseRequest;
import toanchetpay.plugin.dto.request.baseRequest.OpenSessionXpayTransactionBaseRequest;
import toanchetpay.plugin.util.ToanChetUtil;

public class ToanchetDeeplinkRequest extends OpenSessionBaseRequest implements IToanchetPayBaseContract {
    private ToanchetDeeplinkRequest.XPayTransaction xpayTransaction;
    private final ToanchetPayRoot toanchetPayRoot;
    public ToanchetDeeplinkRequest(ToanchetPayRoot toanchetPayRoot){
        setCredentials(toanchetPayRoot);
        this.toanchetPayRoot = toanchetPayRoot;
    }
    @Override
    public void setCredentials(ToanchetPayRoot toanchetPayRoot) {
        super.setLoginId(toanchetPayRoot.loginId());
        super.setPassword(toanchetPayRoot.password());
        super.setMerchantID(toanchetPayRoot.merchantId());
    }
    public ToanchetDeeplinkRequest.XPayTransaction getXpayTransaction() {
        return xpayTransaction;
    }
    public void setXpayTransaction(ToanchetDeeplinkRequest.XPayTransaction xpayTransaction) {
        this.xpayTransaction = xpayTransaction;
        super.setHash(ToanChetUtil.buildHashForOpenSession(super.getLoginId(), super.getPassword(), super.getMerchantID(), xpayTransaction.getTxid(), toanchetPayRoot.secretKey()));
    }
    public static  class XPayTransaction  extends OpenSessionXpayTransactionBaseRequest {
        private String oprDevice;
        private String callBackUrl;
        private String compName;
        public String getOprDevice() {
            return oprDevice;
        }
        public void setOprDevice(String oprDevice) {
            this.oprDevice = oprDevice;
        }
        public String getCallBackUrl() {
            return callBackUrl;
        }
        public void setCallBackUrl(String callBackUrl) {
            this.callBackUrl = callBackUrl;
        }
        public String getCompName() {
            return compName;
        }
        public void setCompName(String compName) {
            this.compName = compName;
        }
    }
}
