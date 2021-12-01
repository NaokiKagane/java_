package ru.stqa.pft.sandbox;

public class Equality {

  public static void main (String[] args) {
    String s1 = "fierfox 2.0";
    String s2 = "fierfox " + Math.sqrt(4.0);

    System.out.println(s1 == s2);
    System.out.println(s1.equals (s2));
  }
}
