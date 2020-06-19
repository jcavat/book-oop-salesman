package ch.hepia.my_app.geometry;

public class Point {
    private final double x; // réf. constante
    private final double y;

    public Point(double x, double y) {
        this.x = x; // ne peut être attribué qu'une fois dans un constructeur
        this.y = y;
    }

    public double quadraticDistanceWith(Point that) {
        final double deltaX = that.x - this.x;
        final double deltaY = that.y - this.y;
        return deltaX*deltaX + deltaY*deltaY;
    }

    public double distanceWith(Point that) {
        return Math.sqrt( quadraticDistanceWith(that) );
    }

    public String toString() {
        return "Point(" + x + "," + y + ")";
    }
}