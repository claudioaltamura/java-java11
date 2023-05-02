package de.claudioaltamura.java.java9;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class OptionalTest {

  @Test
  void orNotNull() {
    Optional<String> name = Optional.of("Miles Morales");
    Optional<String> defaultValue = Optional.of("Spider Men");

    Optional<String> result = name.or(() -> defaultValue);

    assertThat(result.get()).contains("Miles Morales");
  }

  @Test
  void orNull() {
    Optional<String> name = Optional.ofNullable(null);
    Optional<String> defaultValue = Optional.of("Spider Men");

    Optional<String> result = name.or(() -> defaultValue);

    assertThat(result.get()).contains("Spider Men");
  }

  @Test
  void ifPresentOrElsePresent() {
    Optional<String> value = Optional.of("properValue");
    AtomicInteger successCounter = new AtomicInteger(0);
    AtomicInteger emptyOptionalCounter = new AtomicInteger(0);

    value.ifPresentOrElse(
        v -> successCounter.incrementAndGet(), emptyOptionalCounter::incrementAndGet);

    assertThat(successCounter.get()).isNotZero();
    assertThat(emptyOptionalCounter.get()).isZero();
  }

  @Test
  void ifPresentOrElsePresentNotPresent() {
    Optional<String> value = Optional.ofNullable(null);
    AtomicInteger successCounter = new AtomicInteger(0);
    AtomicInteger emptyOptionalCounter = new AtomicInteger(0);

    value.ifPresentOrElse(
        v -> successCounter.incrementAndGet(), emptyOptionalCounter::incrementAndGet);

    assertThat(successCounter.get()).isZero();
    assertThat(emptyOptionalCounter.get()).isNotZero();
  }
}
