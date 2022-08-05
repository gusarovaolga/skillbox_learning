import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Список рейсов, вылетающих в ближайшие два часа: ");
        findPlanesLeavingInTheNextTwoHours(Airport.getInstance());
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        Date time = Date.from(LocalDateTime.now().plusHours(2).atZone(ZoneId.systemDefault()).toInstant());
        Date now = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        List<Flight> flightOnTime = airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight ->
                        flight.getDate().before(time)
                                && flight.getDate().after(now)
                                && flight.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());

        flightOnTime.forEach(System.out::println);

        return flightOnTime;
    }
}