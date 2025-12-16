package toanchetpay.plugin;

import toanchetpay.plugin.api.ToanchetPayApiService;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.core.ApiClient;

public class ToanchetPaySdk {
    private final ApiClient apiClient;
    public final ToanchetPayApiService  apiService;
    public ToanchetPaySdk(ToanchetPayRoot toanchetPayRoot) {
        this.apiClient= new ApiClient(toanchetPayRoot);
        this.apiService = new ToanchetPayApiService(this.apiClient);
    }
}
