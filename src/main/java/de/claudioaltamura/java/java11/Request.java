package de.claudioaltamura.java.java11;

import java.util.Arrays;
import java.util.Objects;

public class Request {

  private final String endpoint;

  private final byte[] payload;

  public Request(String endpoint, byte[] payload) {
    super();
    this.endpoint = endpoint;
    this.payload = payload;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public byte[] getPayload() {
    return payload;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(payload);
    result = prime * result + Objects.hash(endpoint);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Request other = (Request) obj;
    return Objects.equals(endpoint, other.endpoint) && Arrays.equals(payload, other.payload);
  }

  @Override
  public String toString() {
    return "Message [endpoint=" + endpoint + ", payload=" + Arrays.toString(payload) + "]";
  }
}
