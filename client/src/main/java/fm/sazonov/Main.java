package fm.sazonov;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.time.LocalTime.now;

public class Main {

    private static AtomicInteger num = new AtomicInteger(0);
    private static HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) {
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            long until = test();
            results.add(until);
        }
        System.out.println(results.stream().flatMapToLong(LongStream::of).sum() / 20);
    }

    private static long test() {
        LocalTime start = now();
        IntStream.range(0, 1)
                .boxed()
                .map(in -> doGetAsync())
                .toList()
                .forEach(httpResponseCompletableFuture -> {
                    HttpResponse<String> join = httpResponseCompletableFuture.join();
                    System.out.println(join.body() + num.incrementAndGet());
                });
        LocalTime end = now();
        long until = start.until(end, ChronoUnit.SECONDS);
        return until;
    }

    private static CompletableFuture<HttpResponse<String>> doGetAsync() {
        var request = HttpRequest.newBuilder()
                .GET()
                //.uri(URI.create("http://127.0.0.1:8080/"))
                //.uri(URI.create("http://127.0.0.1:8080/second"))
                //.uri(URI.create("http://127.0.0.1:8080/third"))
                .uri(URI.create("http://127.0.0.1:8080/fourths"))
                .timeout(Duration.ofSeconds(60))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }
}