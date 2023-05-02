package de.claudioaltamura.java.java11;

import static org.junit.jupiter.api.Assertions.*;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HttpClientServiceTest {

  @Test
  @Disabled("temporarily disabled")
  @DisplayName("send a request")
  void testAsyncHttpClient() throws ExecutionException, InterruptedException {
    HttpClientService httpClientService = new HttpClientService();
    CompletableFuture<HttpResponse<String>> response =
        httpClientService.send(new Request("https://httpbin.org/anything", "hello, world!".getBytes()));
    assertEquals(200, response.get().statusCode());
  }
}
