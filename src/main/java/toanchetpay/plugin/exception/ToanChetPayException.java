package toanchetpay.plugin.exception;

public class ToanChetPayException extends RuntimeException  {

    public ToanChetPayException(int statusCode, String body) {
        super("API Error: " + statusCode + "Message :"+ body);
    }
}
