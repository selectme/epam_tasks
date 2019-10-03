package taskslist4.maintask.airline;

import taskslist4.maintask.airline.models.Airplane;
import taskslist4.maintask.airline.service.implementations.AirlineServiceImpl;

import java.util.List;

/**
 * @author Viktar on 29.09.2019
 */
public class Main {
    private static final String FILE_PATH = "E:/result.txt";

    public static void main(String[] args) {
        AirlineServiceImpl service = new AirlineServiceImpl();
        List<Airplane> airplanes = service.createAirplanesList(FILE_PATH);
        System.out.println(service.findTotalPassengersCapacity(airplanes));

    }
}
