package taskslist4.maintask.airline.service.impl;

import org.junit.Before;
import org.junit.Test;
import taskslist4.maintask.airline.model.Airplane;
import taskslist4.maintask.airline.model.AirplaneType;
import taskslist4.maintask.airline.model.CargoAirplane;
import taskslist4.maintask.airline.service.AirlineService;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Viktar on 07.10.2019
 */
public class AirlineServiceImplTest {
    private static final String RIGHT_DATA = "airplanesRightData.txt";
    private static final String WRONG_DATA = "airplanesWrongData.txt";
    private AirlineService airlineService;


    @Before
    public void setUp() throws Exception {
        airlineService = new AirlineServiceImpl();
    }

    @Test
    public void testGetAirplanesQuantity() {

        int airplanes = airlineService.getAirplanesQuantity(RIGHT_DATA);

        assertEquals(5, airplanes);
    }


    @Test
    public void testCreateAirplanesList_success() {

        List<Airplane> airplanes = airlineService.createAirplanesList(RIGHT_DATA);

        assertTrue(airplanes.get(0) instanceof CargoAirplane);
        assertEquals(airplanes.get(0).getSideNumber(), "GH12");
        assertEquals(airplanes.get(0).getManufacturer(), "Sukhoi");
        assertEquals(airplanes.get(0).getModel(), "C4312");
        assertEquals(airplanes.get(0).getAirplaneType(), AirplaneType.CARGO);
        assertEquals(airplanes.get(0).getCrewQuantity(), 2);
        assertEquals(airplanes.get(0).getMaxSpeed(), 850);
        assertEquals(airplanes.get(0).getMaxAltitude(), 10000);
        assertEquals(airplanes.get(0).getMaxFlightRange(), 5000);
        assertEquals(airplanes.get(0).getFuelSupply(), 245);
        assertEquals(airplanes.get(0).getFuelConsumption(), 170, 0.01);
        assertEquals(((CargoAirplane) airplanes.get(0)).getCargoCapacity(), 220);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCreateAirplanesList_wrongInputData() {

        List<Airplane> airplanes = airlineService.createAirplanesList(WRONG_DATA);

        assertTrue(airplanes.get(0) instanceof CargoAirplane);
        assertEquals(airplanes.get(0).getSideNumber(), "GH12");
        assertEquals(airplanes.get(0).getManufacturer(), "Sukhoi");
        assertEquals(airplanes.get(0).getModel(), "C4312");
        assertEquals(airplanes.get(0).getAirplaneType(), AirplaneType.CARGO);
        assertEquals(airplanes.get(0).getCrewQuantity(), 2);
        assertEquals(airplanes.get(0).getMaxSpeed(), 850);
        assertEquals(airplanes.get(0).getMaxAltitude(), 10000);
        assertEquals(airplanes.get(0).getMaxFlightRange(), 5000);
        assertEquals(airplanes.get(0).getFuelSupply(), 245);
        assertEquals(airplanes.get(0).getFuelConsumption(), 170, 0.01);
        assertEquals(((CargoAirplane) airplanes.get(0)).getCargoCapacity(), 220);
    }

    @Test
    public void testFindTotalCrewCapacity() {

        int crews = airlineService.findTotalCrewCapacity(airlineService.createAirplanesList(RIGHT_DATA));
        assertEquals(18, crews);
    }

    @Test
    public void testFindTotalAirplanesCapacity() {

        int total = airlineService.findTotalAirplanesCapacity(airlineService.createAirplanesList(RIGHT_DATA));
        assertEquals(816, total);
    }

    @Test
    public void testFindTotalPassengersCapacity() {

        int total = airlineService.findTotalPassengersCapacity(airlineService.createAirplanesList(RIGHT_DATA));
        assertEquals(798, total);
    }

    @Test
    public void testFindTotalAirplanesCarryingCapacity() {

        int total = airlineService.findTotalAirplanesCarryingCapacity(airlineService.createAirplanesList(RIGHT_DATA));
        assertEquals(440, total);
    }
}