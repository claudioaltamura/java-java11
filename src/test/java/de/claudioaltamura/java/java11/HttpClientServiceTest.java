package de.claudioaltamura.java.java11;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.ref.ReferenceQueue;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HttpClientServiceTest {

  @Test
  @DisplayName("send a request")
  void testAsyncHttpClient() throws ExecutionException, InterruptedException {
    HttpClientService httpClientService = new HttpClientService();
    CompletableFuture<HttpResponse<String>> response = httpClientService.send(
        new Request("http://httpbin.org/post", "hello, world!".getBytes())
    );
    assertEquals(200, response.get().statusCode());
  }
}