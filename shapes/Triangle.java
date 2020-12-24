package shapes;
import java.util.Objects;


public final class Triangle implements Shape {
    private double a;
    private double b;
    private double c;
    String type = "triangle";

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        if (!isCorrect()) {
            throw new IllegalStateException("Invalid triangle: a=" + a + ", b=" + b + ", c=" + c);
        } else {
            return Math.sqrt(getPerimeter() / 2
                    * (getPerimeter() / 2 - a)
                    * (getPerimeter() / 2 - b)
                    * (getPerimeter() / 2 - c));
        }
    }

    public double getPerimeter() {
        if (!isCorrect()) {
            throw new IllegalStateException("Invalid triangle: a=" + a + ", b=" + b + ", c=" + c);
        } else {
            return a + b + c;
        }
    }

    private boolean isCorrect() {
        return a > 0 && b > 0 && c > 0
                && a + b > c
                && b + c > a
                && a + c > b;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Triangle
                && a == ((Triangle)other).a
                && b == ((Triangle)other).b
                && c == ((Triangle)other).c;
    }

    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    public String toString() {
        return "Triangle(a=" + a + ", b=" + b + ", c=" + c + ')';
    }

    public final double getA() {
        return a;
    }

    public final void setA(double a) {
        this.a = a;
    }

    public final double getB() {
        return b;
    }

    public final void setB(double b) {
        this.b = b;
    }

    public final double getC() {
        return c;
    }

    public final void setC(double c) {
        this.c = c;
    }
}