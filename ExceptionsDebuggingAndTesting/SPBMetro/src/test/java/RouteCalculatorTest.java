import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route0;//без пересадок
    List<Station> route1;//одна пересадка
    List<Station> route2;//две пересадки

    List<Station> connect1;
    List<Station> connect2;

    Line line1 = new Line(1, "First");
    Line line2 = new Line(2, "Second");
    Line line3 = new Line(3, "Third");

    Station s1 = new Station("Первая", line1);
    Station s2 = new Station("Вторая 1на2", line1);
    Station s3 = new Station("Третья 2на1", line2);
    Station s4 = new Station("Четвертая 2на3", line2);
    Station s5 = new Station("Пятая 3на2", line3);
    Station s6 = new Station("Шестая ", line3);
    Station s7 = new Station("Седьмая", line1);

    StationIndex stationIndexTest = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndexTest);

    @Override
    protected void setUp() throws Exception {

        line1.addStation(s1);
        line1.addStation(s2);
        line1.addStation(s7);

        line2.addStation(s3);
        line2.addStation(s4);

        line3.addStation(s5);
        line3.addStation(s6);

        connect1 = new ArrayList<>();
        connect1.add(s2);
        connect1.add(s3);

        connect2 = new ArrayList<>();
        connect2.add(s4);
        connect2.add(s5);

        stationIndexTest.addStation(s1);
        stationIndexTest.addStation(s2);
        stationIndexTest.addStation(s3);
        stationIndexTest.addStation(s4);
        stationIndexTest.addStation(s5);
        stationIndexTest.addStation(s6);
        stationIndexTest.addStation(s7);

        stationIndexTest.addLine(line1);
        stationIndexTest.addLine(line2);
        stationIndexTest.addLine(line3);

        stationIndexTest.addConnection(connect1);
        stationIndexTest.addConnection(connect2);

        route0 = new ArrayList<>();
        route0.add(s1);
        route0.add(s2);

        route1 = new ArrayList<>();
        route1.add(s1);
        route1.add(s2);
        route1.add(s3);

        route2 = new ArrayList<>();
        route2.add(s1);
        route2.add(s2);
        route2.add(s3);
        route2.add(s4);
        route2.add(s5);
        route2.add(s6);

    }


    public void testCalculateDuration() {

        double actual = RouteCalculator.calculateDuration(route2);
        double expected = 14.5;
        assertEquals(expected, actual);

    }

    public void testGetRouteOnTheLine() {

        List<Station> actual = routeCalculator.getShortestRoute(s1, s2);
        List<Station> expected = route0;
        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {

        List<Station> actual = routeCalculator.getShortestRoute(s1, s3);
        List<Station> expected = route1;
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {

        List<Station> actual = routeCalculator.getShortestRoute(s1, s6);
        List<Station> expected = route2;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {

        List<Station> actual = routeCalculator.getShortestRoute(s1, s7);
        List<Station> expected = new ArrayList<>();
        expected.add(s1);
        expected.add(s2);
        expected.add(s7);
        assertEquals(expected, actual);
    }


    @Override
    protected void tearDown() throws Exception {
    }
}
