package de.claudioaltamura.java.java11;

import java.util.ArrayList;
import java.util.List;

class VarExample {

  List<String> languages() {
    var lang = new ArrayList<String>();

    lang.add("German");
    lang.add("Englisch");
    lang.add("Italian");

    return lang;
  }
}
