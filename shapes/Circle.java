package shapes;


public final class Circle implements Shape {
    private double radius;
    String type = "circle";

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        if (!isCorrect()) {
            throw new IllegalStateException("Invalid circle radius: " + radius);
        } else {
            return Math.PI * radius * radius;
        }
    }
    @Override
    public double getPerimeter() {
        if (!isCorrect()) {
            throw new IllegalStateException("Invalid circle radius: " + radius);
        } else {
            return 2 * Math.PI * radius;
        }
    }

    private boolean isCorrect() {
        return radius > 0;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Circle && radius == ((Circle)other).radius;
    }

    public int hashCode() {
        return Double.valueOf(radius).hashCode();
    }

    public String toString() {
        return "Circle(radius=" + radius + ')';
    }

    public final double getRadius() {
        return radius;
    }

    public final void setRadius(double radius) {
        this.radius = radius;
    }
}
