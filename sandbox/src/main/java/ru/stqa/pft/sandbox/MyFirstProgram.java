package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Anna");

    Square s = new Square (5);
    System.out.println("Площадь квадрата со сторойной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со сторойной " + r.a + " и " + r.b + " = " + r.area());

    PointInfo P = new PointInfo(2,4,3,5);
    System.out.println("Расстояние между точкой Х с координатами " + P.x1 + ", " + P.y1 + " и точкой Y с координатами " + P.x2 + "," + P.y2+ " = " + distance(P));
  }
public static void hello(String somebody) {

    System.out.println("Hello, " + somebody + "!");
  }
public class Point {

  }
  public static double distance(PointInfo P){
    return Math.sqrt((P.x2 - P.x1) * (P.x2 - P.x1) + (P.y2 - P.y1) * (P.y2 - P.y1));

}
}