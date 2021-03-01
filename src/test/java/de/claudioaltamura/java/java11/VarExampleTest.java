package de.claudioaltamura.java.java11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VarExampleTest {

  @Test
  void testVar() {

    VarExample example = new VarExample();

    for (var current : example.languages()) {
      System.out.println(current);
    }

    assertEquals(3, example.languages().size());
  }
}
