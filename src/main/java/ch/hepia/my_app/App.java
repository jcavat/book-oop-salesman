package ch.hepia.my_app;
import ch.hepia.geometry.Point;
import ch.hepia.optimization.NearesNeighbourProblem;

public class App
{
    public static void main( String[] args )
    {
        final Point p1 = new Point(0.0, 0.0);
        final Point p2 = new Point(3.0, 4.0);

        System.out.println( p1.distanceWith(p2) );

        NearesNeighbourProblem problem = new NearesNeighbourProblem();
        problem.addPoints(p1, p2);
        System.out.println( problem.solve().totalDistance() );
    }
}
