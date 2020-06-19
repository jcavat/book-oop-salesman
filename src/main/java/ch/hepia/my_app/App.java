package ch.hepia.my_app;
import ch.hepia.my_app.geometry.Point;
import ch.hepia.my_app.optimization.NearestNeighbourProblem;
import ch.hepia.my_app.optimization.Solution;

public class App
{
    public static void main( String[] args )
    {
        final Point p1 = new Point(0.0, 0.0);
        final Point p2 = new Point(3.0, 4.0);
        final Point p3 = new Point(2.0, 3.0);

        System.out.println( p1.distanceWith(p2) );

        NearestNeighbourProblem problem = new NearestNeighbourProblem();
        problem.addPoints(p1, p2, p3);
        Solution s = problem.solve();
        System.out.println( s.totalDistance() );
        for(Point p: s.sequence()) {
            System.out.println( p.toString() );
        }
    }
}
