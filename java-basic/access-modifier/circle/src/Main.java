public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Circle1 Radius: " + circle1.getRadius());
        System.out.println("Circle1 Area: " + circle1.getArea());

        Circle circle2 = new Circle(2.5);
        System.out.println("Circle2 Radius: " + circle2.getRadius());
        System.out.println("Circle2 Area: " + circle2.getArea());
    }
}