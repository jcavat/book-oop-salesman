package ch.hepia.my_app.optimization;

import ch.hepia.my_app.geometry.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NearestNeighbourProblemTest {

    @Test
    void testSolutionWithoutPoints() {
        Point shortestRef = new Point(1.0, 1.0);
        List<Point> points = List.of( new Point(0.0, 24.0), new Point(33.0, 2.5), shortestRef );
        assertTrue( NearestNeighbourProblem.nearestIndex(new Point(0.0, 0.0), points) == 2 );
    }
}
