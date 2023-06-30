package fm.sazonov.dto;

import lombok.experimental.UtilityClass;

import java.net.URI;
import java.net.http.HttpRequest;

@UtilityClass
public class Utils {
    public static String getUri(String url) {
        return "http://127.0.0.1:8081/" + url;
    }

    public static HttpRequest getRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(getUri(url)))
                .build();
    }
}