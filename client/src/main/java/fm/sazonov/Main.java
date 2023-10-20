package fm.sazonov;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

import static java.time.LocalTime.now;

public class Main {

    public static final int END_EXCLUSIVE = 100;

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) {
        var start = now();
        var averExTime = launch();
        System.out.println("Average execution time = " + averExTime);
        var end = now();
        var amount = start.until(end, ChronoUnit.MILLIS);
        System.out.println("all the time the requests are executed = " + amount);
    }

    private static double launch() {
        return IntStream.range(0, END_EXCLUSIVE)
                .boxed()
                .parallel()
                .map(in -> doGetAsync())
                .mapToDouble(s -> (double)s)
                .sum() / END_EXCLUSIVE;
    }

    private static long doGetAsync() {
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://127.0.0.1:8082/"))
                //.uri(URI.create("http://127.0.0.1:8080/second"))
                //.uri(URI.create("http://127.0.0.1:8080/third"))
                //.uri(URI.create("http://127.0.0.1:8080/async-rt/catalog"))
                //.uri(URI.create("http://127.0.0.1:8080/async-hc/v2/catalog"))
                //.uri(URI.create("http://127.0.0.1:8080/async-hc/v1/catalog"))
                //.uri(URI.create("http://127.0.0.1:8080/catalog"))
                //.uri(URI.create("http://127.0.0.1:8080/s"))
                .timeout(Duration.ofSeconds(60))
                .build();
        var start = now();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).join();
        var end = now();
        var until = start.until(end, ChronoUnit.MILLIS);
        System.out.println("until = " + until);
        return until;
    }
}