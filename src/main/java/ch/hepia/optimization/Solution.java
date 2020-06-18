package ch.hepia.optimization;

        import ch.hepia.geometry.Point;
        import java.util.List;

public class Solution {
    private final List<Point> sequence;

    public Solution(List<Point> points) {
        this.sequence = points;
    }

    public double totalDistance() {
        if( this.sequence.isEmpty() ) {
            throw new IllegalStateException("A solution must contain at least one point");
        }
        double res = 0.0;
        Point ref = this.sequence.get(0);
        for(Point p: this.sequence) {
            res += ref.distanceWith(p); // first loop ref = p, don't worry: only assign 0 to res
            ref = p;
        }
        res += ref.distanceWith( this.sequence.get(0) ); // finish the travelling... go home
        return res;
    }
}
