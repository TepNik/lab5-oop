package shapes;


public final class Square implements Shape {
    private double height;
    String type = "square";

    public Square(double height) {
        this.height = height;
    }

    public double getArea() {
        if (!isCorrect()) {
            throw new IllegalStateException("Invalid square height=" + height);
        } else {
            return height * height;
        }
    }

    public double getPerimeter() {
        if (!isCorrect()) {
            throw new IllegalStateException("Invalid square height=" + height);
        } else {
            return 4 * height;
        }
    }

    private boolean isCorrect() {
        return this.height > (double)0;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Square && height == ((Square)other).height;
    }

    public int hashCode() {
        return Double.valueOf(height).hashCode();
    }

    public String toString() {
        return "Square(height=" + height + ')';
    }

    public final double getHeight() {
        return height;
    }

    public final void setHeight(double height) {
        this.height = height;
    }
}