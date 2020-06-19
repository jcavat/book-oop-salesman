package ch.hepia.my_app;

import ch.hepia.my_app.geometry.Point;
import ch.hepia.my_app.optimization.NearestNeighbourProblem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    final Point p1 = new Point(0.0, 0.0);
    final Point p2 = new Point(3.0, 4.0);

    @Test
    void testRoundTripBetweenTwoPoints() {
        NearestNeighbourProblem problem = new NearestNeighbourProblem();
        problem.addPoints(p1, p2);
        assertEquals(p1.distanceWith(p2) * 2, problem.solve().totalDistance());
    }

    @Test
    void testSolutionWithoutPoints() {
        NearestNeighbourProblem problem = new NearestNeighbourProblem();

        /* should throw an error. Second arg means "execute it later" */
        assertThrows(IllegalStateException.class, () -> problem.solve());
    }

}
