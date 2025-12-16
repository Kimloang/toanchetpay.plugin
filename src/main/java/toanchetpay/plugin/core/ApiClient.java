package toanchetpay.plugin.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import toanchetpay.plugin.client.ToanchetPayRoot;

public class ApiClient {
    private final HttpExecutor http;
    public final ToanchetPayRoot toanchetPayRoot;
    public ApiClient(ToanchetPayRoot openSessionRequest) {
        this.http = new HttpExecutor();
        this.toanchetPayRoot = openSessionRequest;
    }
    public <T> T post(String path, Object body, Class<T> type) throws JsonProcessingException {
        String json = Json.toJson(body);
        String response = http.post(toanchetPayRoot.baseUrl() + path, json);
        return Json.fromJson(response, type);
    }
    public <T> T get(String path, Class<T> type) throws JsonProcessingException {
        String response = http.get(toanchetPayRoot.baseUrl()  , path);
        return Json.fromJson(response, type);
    }
}
