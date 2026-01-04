package toanchetpay.plugin.dto.request;

import toanchetpay.plugin.app.EToanChetOperation;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.contract.IToanchetPayBaseContract;
import toanchetpay.plugin.dto.request.baseRequest.OpenSessionBaseRequest;
import toanchetpay.plugin.dto.request.baseRequest.OpenSessionXpayTransactionBaseRequest;
import toanchetpay.plugin.util.ToanChetUtil;

public class ToanChetMPGSRequest  extends OpenSessionBaseRequest implements IToanchetPayBaseContract {
    private final ToanchetPayRoot toanchetPayRoot;
    private ToanChetMPGSRequest.XPayTransaction xpayTransaction;
    @Override
    public void setCredentials(ToanchetPayRoot toanchetPayRoot) {
        super.setLoginId(toanchetPayRoot.loginId());
        super.setPassword(toanchetPayRoot.password());
        super.setMerchantID(toanchetPayRoot.merchantId());
    }
    public ToanChetMPGSRequest(ToanchetPayRoot toanchetPayRoot){
        setCredentials(toanchetPayRoot);
        this.toanchetPayRoot = toanchetPayRoot;
    }
    public ToanChetMPGSRequest.XPayTransaction getXpayTransaction() {
        return xpayTransaction;
    }
    public void setXpayTransaction(ToanChetMPGSRequest.XPayTransaction xpayTransaction) {
        this.xpayTransaction = xpayTransaction;
        super.setHash(ToanChetUtil.buildHashForOpenSession(super.getLoginId(), super.getPassword(), super.getMerchantID(), xpayTransaction.getTxid(), toanchetPayRoot.secretKey()));
    }
    public static  class XPayTransaction  extends OpenSessionXpayTransactionBaseRequest {
        private String operationType;
        public String getOperationType() {
            return operationType;
        }

        public void setOperationType(EToanChetOperation operationType) {
            this.operationType = String.valueOf(operationType.getValue());
        }
    }
}
