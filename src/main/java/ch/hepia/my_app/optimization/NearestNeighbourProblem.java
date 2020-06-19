package ch.hepia.my_app.optimization;

import ch.hepia.my_app.geometry.Point;

import java.util.ArrayList;
import java.util.List;

public class NearestNeighbourProblem {
    private final List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        this.points.add(point);
    }

    /* arbitrary variable arguments. Transform to an array
     * can be use like this: addPoints( new Point(0.0, 0.0), new Point(1.0, 2.0) )
     */
    public void addPoints(Point... points) {
        for(Point p: points) {
            addPoint(p);
        }
    }

    public Solution solve() {
        if( this.points.isEmpty() ) {
            throw new IllegalStateException("A solution must contain at least one point");
        }

        final List<Point> sequence = new ArrayList<>();
        final List<Point> localPoints = new ArrayList<>(this.points); // copy the original list

        Point ref = localPoints.remove(0);
        sequence.add(ref);
        while( !localPoints.isEmpty() ) {
            final int nearestIndex = nearestIndex(ref, localPoints);
            ref = localPoints.remove(nearestIndex);
            sequence.add(ref);
        }
        return new Solution(sequence);
    }

    static int nearestIndex(Point ref, List<Point> remaining) {
        assert !remaining.isEmpty();
        double minDistance = Double.MAX_VALUE;
        int index = 0;
        int currentIndex = 0;
        for(Point p: remaining) {
            double distance = ref.quadraticDistanceWith(p);
            if( distance < minDistance){
                index = currentIndex;
                minDistance = distance;
            }
            currentIndex += 1;
        }
        return index;
    }
}
