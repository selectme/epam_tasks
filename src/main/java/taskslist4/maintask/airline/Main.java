package taskslist4.maintask.airline;

import taskslist4.maintask.airline.models.Airplane;
import taskslist4.maintask.airline.service.implementations.AirlineServiceImpl;

/**
 * @author Viktar on 29.09.2019
 */
public class Main {
    private static final String FILE_PATH = "E:/result.txt";

    public static void main(String[] args) {
        AirlineServiceImpl service = new AirlineServiceImpl();
        Airplane[] airplanes = service.createAirplanesList(FILE_PATH);
        for(Airplane airplane : airplanes){
            System.out.println(airplane);
        }
    }
}
