package toanchetpay.plugin.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJson(Object o) throws JsonProcessingException { return objectMapper.writeValueAsString(o); }
    public static <T> T fromJson(String json, Class<T> type) throws JsonProcessingException { return objectMapper.readValue(json, type); }
}
