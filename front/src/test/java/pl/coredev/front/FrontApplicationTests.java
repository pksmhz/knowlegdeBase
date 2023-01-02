package pl.coredev.front;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.NginxContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootTest
@Testcontainers
class FrontApplicationTests {

    @Container
    NginxContainer<?> nginx = new NginxContainer<>("nginx");

    @Test
    void test() throws IOException, InterruptedException, URISyntaxException {
        var client = HttpClient.newHttpClient();
        var url = nginx.getBaseUrl("http", 80);
        var request = HttpRequest.newBuilder(url.toURI()).GET().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Assertions.assertTrue(response.body().contains("Thank you for using nginx."));
    }

}
