package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testArea() {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(2, 7);
    Assert.assertEquals(p1.distance(p2), 4);

  }
}
