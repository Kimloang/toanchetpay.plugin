package toanchetpay.plugin.core;

import okhttp3.*;
import toanchetpay.plugin.exception.ToanChetPayException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpExecutor {

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    public String post(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return execute(request);
    }
    public String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new ToanChetPayException(
                        response.code(),response.message()
                );
            }
            return response.body() != null ? response.body().string() : "";
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String execute(Request request) {
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                // Return API error details if available
                String errorBody = response.body() != null ? response.body().string() : "No content";
                throw new ToanChetPayException(
                        response.code(),
                        "API Error: " + response.message() + " | Body: " + errorBody
                );
            }
            return response.body() != null ? response.body().string() : "";
        } catch (IOException ex) {
            throw new ToanChetPayException(503, "Network/IO Error: " + ex.getMessage());
        }
    }
}

