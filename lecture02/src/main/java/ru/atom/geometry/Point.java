package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider  /* super class and interfaces here if necessary */ {
    // fields
    // and methods

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;

        return this.x == point.getX() && this.y == point.getY();
        // your code here
    }

    @Override
    public boolean isColliding(Collider other) {
        if (equals(other)) {
            return true;
        }

        if (other instanceof Bar) {
            return other.isColliding(this);
        }

        return false;
    }
}
