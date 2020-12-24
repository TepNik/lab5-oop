package shapes;

import java.util.Objects;

public final class Rectangle implements Shape {
    private double width;
    private double height;
    String type = "rectangle";

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        if (!isCorrect()) {
            throw new IllegalStateException("Invalid rectangle: width=" + width + ", height=" + height);
        } else {
            return width * height;
        }
    }

    public double getPerimeter() {
        if (!isCorrect()) {
            throw new IllegalStateException("Invalid rectangle: width=" + width + ", height=" + height);
        } else {
            return 2 * (width + height);
        }
    }

    private boolean isCorrect() {
        return width > 0 && height > 0;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Rectangle && width == ((Rectangle)other).width && height == ((Rectangle)other).height;
    }

    public int hashCode() {
        return Objects.hash(width, height);
    }

    public String toString() {
        return "Rectangle(width=" + width + ", height=" + height + ')';
    }

    public final double getWidth() {
        return width;
    }

    public final void setWidth(double width) {
        this.width = width;
    }

    public final double getHeight() {
        return height;
    }

    public final void setHeight(double height) {
        this.height = height;
    }
}