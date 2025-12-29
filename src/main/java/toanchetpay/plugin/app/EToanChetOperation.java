package toanchetpay.plugin.app;

public enum EToanChetOperation {
    KHQR (5),
    KHQR_WEB_VIEW (3);

    public int getValue() {
        return value;
    }

    private final int value;
    EToanChetOperation(int value) {
        this.value=value;
    }
}
