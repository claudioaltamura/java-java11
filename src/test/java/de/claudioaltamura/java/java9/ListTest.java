package de.claudioaltamura.java.java9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ListTest {

  @Test
  void listOf() {
    assertThat(Animals.getList()).containsExactly("ant", "bear", "crocodile");
  }
}
