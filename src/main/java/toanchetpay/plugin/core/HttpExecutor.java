package toanchetpay.plugin.core;

import okhttp3.*;
import toanchetpay.plugin.exception.ToanChetPayException;

import java.io.IOException;

public class HttpExecutor {

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private final OkHttpClient client = new OkHttpClient();

    public String post(String url, String json) {
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
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
}

