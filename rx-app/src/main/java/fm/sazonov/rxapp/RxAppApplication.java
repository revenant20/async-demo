package fm.sazonov.rxapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class RxAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RxAppApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create("http://127.0.0.1:8081/");
    }

}
