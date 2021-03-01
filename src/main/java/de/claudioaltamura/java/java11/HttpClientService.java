package de.claudioaltamura.java.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClientService {

  private final HttpClient client;
  private final ExecutorService executor;

  public HttpClientService() {
    executor = Executors.newFixedThreadPool(100);
    client =
        HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(3))
            .executor(executor)
            .version(Version.HTTP_1_1)
            .build();
  }

  public CompletableFuture<HttpResponse<String>> send(Request request) {
    var httpPost =
        HttpRequest.newBuilder()
            .uri(URI.create(request.getEndpoint()))
            .header("Content-Type", "application/octet-stream")
            .header("accept", "application/json")
            .POST(BodyPublishers.ofByteArray(request.getPayload()))
            .build();

    return client.sendAsync(httpPost, BodyHandlers.ofString());
  }
}
