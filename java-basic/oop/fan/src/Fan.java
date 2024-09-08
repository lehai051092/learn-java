public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    int speed = SLOW;
    boolean on = false;
    double radius = 5;
    String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (this.getOn()) {
            return "Speed: " + this.getSpeed() + ", Color: " + this.getColor() + ", Radius: " + this.getRadius() + ", Fan is On";
        }

        return "Speed: " + this.getSpeed() + ", Color: " + this.getColor() + ", Radius: " + this.getRadius() + ", Fan is Off";
    }
}
