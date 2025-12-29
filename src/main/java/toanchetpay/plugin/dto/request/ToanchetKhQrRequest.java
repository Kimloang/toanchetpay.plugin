package toanchetpay.plugin.dto.request;

import toanchetpay.plugin.app.EToanChetOperation;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.contract.IToanchetPayBaseContract;
import toanchetpay.plugin.dto.request.BaseRequest.OpenSessionXpayTransactionBaseRequest;
import toanchetpay.plugin.dto.request.baseRequest.OpenSessionBaseRequest;

public class ToanchetKhQrRequest extends OpenSessionBaseRequest implements IToanchetPayBaseContract {
    @Override
    public void setCredentials(ToanchetPayRoot toanchetPayRoot) {
        super.setLoginId(toanchetPayRoot.loginId());
        super.setPassword(toanchetPayRoot.password());
        super.setMerchantID(toanchetPayRoot.merchantId());
    }
    private XpayTransaction xpayTransaction;
    public XpayTransaction getXpayTransaction() {
        return xpayTransaction;
    }
    public ToanchetKhQrRequest(ToanchetPayRoot toanchetPayRoot){
        setCredentials(toanchetPayRoot);
    }
    public void setXpayTransaction(XpayTransaction xpayTransaction) {
        this.xpayTransaction = xpayTransaction;
    }

    public static class XpayTransaction extends OpenSessionXpayTransactionBaseRequest {
        private String operationType;
        public String getOperationType() {
            return operationType;
        }

        public void setOperationType(EToanChetOperation operationType) {
            this.operationType = String.valueOf(operationType.getValue());
        }

    }
}
