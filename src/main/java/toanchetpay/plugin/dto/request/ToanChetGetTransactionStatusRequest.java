//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package toanchetpay.plugin.dto.request;

import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.contract.IToanchetPayBaseContract;
import toanchetpay.plugin.dto.request.baseRequest.OpenSessionBaseCheckStatusRequest;
import toanchetpay.plugin.dto.request.baseRequest.OpenSessionBaseRequest;
import toanchetpay.plugin.util.ToanChetUtil;


public class ToanChetGetTransactionStatusRequest extends OpenSessionBaseCheckStatusRequest implements IToanchetPayBaseContract {
    private final String paymentTokenid;
    private final String merchantName;

    public void setCredentials(ToanchetPayRoot toanchetPayRoot) {
        super.setLoginId(toanchetPayRoot.loginId());
        super.setPassword(toanchetPayRoot.password());
        super.setMerchantId(toanchetPayRoot.merchantId());
    }

    public String getMerchantName() {
        return this.merchantName;
    }
    public String getPaymentTokenid() {
        return this.paymentTokenid;
    }
    public ToanChetGetTransactionStatusRequest(ToanchetPayRoot toanchetPayRoot,String paymentTokenid,String merchantName) {
        this.setCredentials(toanchetPayRoot);
        this.paymentTokenid = paymentTokenid;
        this.merchantName = merchantName;
        super.setHash(ToanChetUtil.buildHashForOpenSessionCheckStatus(super.getLoginId(), super.getPassword(), super.getMerchantId(), paymentTokenid, toanchetPayRoot.secretKey()));
    }

}
