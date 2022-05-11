package ru.atom.geometry;

import java.util.Objects;

public class Bar implements Collider {

    private final Point firstPoint;
    private final Point secondPoint;

    public Bar(Point firstPoint, Point secondPoint) {
        this.firstPoint = new Point(Math.min(firstPoint.getX(), secondPoint.getX()), Math.min(firstPoint.getY(), secondPoint.getY()));
        this.secondPoint = new Point(Math.max(firstPoint.getX(), secondPoint.getX()), Math.max(firstPoint.getY(), secondPoint.getY()));
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (equals(other)) {
            return true;
        }

        if (other instanceof Bar) {
            Bar bar = (Bar) other;
            return isCollidingBar(bar);
        }

        if (other instanceof Point) {
            Point point = (Point) other;
            return isCollidingPoint(point);
        }

        return false;
    }

    private boolean isCollidingBar(Bar bar) {

        if (this.firstPoint.getX() > bar.getSecondPoint().getX() ||
                this.secondPoint.getX() < bar.getFirstPoint().getX()) {
            return false;
        }

        return this.firstPoint.getY() <= bar.getSecondPoint().getY() &&
                this.secondPoint.getY() >= bar.getFirstPoint().getY();
    }

    private boolean isCollidingPoint(Point point) {

        if (this.firstPoint.getX() > point.getX() ||
                this.secondPoint.getX() < point.getX()) {
            return false;
        }

        return this.firstPoint.getY() <= point.getY() &&
                this.secondPoint.getY() >= point.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return Objects.equals(firstPoint, bar.firstPoint) && Objects.equals(secondPoint, bar.secondPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, secondPoint);
    }
}
