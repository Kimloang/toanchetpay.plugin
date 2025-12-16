package toanchetpay.plugin.exception;

public class ToanChetPayException extends RuntimeException  {
    private final int statusCode;
    private final String body;

    public ToanChetPayException(int statusCode, String body) {
        super("API Error: " + statusCode);
        this.statusCode = statusCode;
        this.body = body;
    }
}
