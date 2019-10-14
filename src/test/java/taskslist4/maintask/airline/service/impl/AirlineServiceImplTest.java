package taskslist4.maintask.airline.service.impl;

import org.junit.Before;
import org.junit.Test;
import taskslist4.maintask.airline.model.Airplane;
import taskslist4.maintask.airline.model.AirplaneType;
import taskslist4.maintask.airline.model.CargoAirplane;
import taskslist4.maintask.airline.model.PassengerAirplane;
import taskslist4.maintask.airline.service.AirlineService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Viktar on 07.10.2019
 */
public class AirlineServiceImplTest {
    private static final String RIGHT_DATA = "airplanesRightData.txt";
    private static final String WRONG_DATA = "airplanesWrongData.txt";
    private AirlineService airlineService;
    private List<Airplane> airplanesRightData;
    private List<Airplane> airplanesWrongData;
    private List<Airplane> airplanesTest;

    @Before
    public void setUp() throws Exception {
        airlineService = new AirlineServiceImpl();
        airplanesRightData = airlineService.createAirplanesList(RIGHT_DATA);

        airplanesTest = new ArrayList<>();
        Airplane cargoAirplane1 = new CargoAirplane("GH12", "Sukhoi", 850,
                10000, "C4312", AirplaneType.CARGO, 2, 5000, 245,
                170, 220);
        Airplane passengerAirplane1 = new PassengerAirplane("B423", "Airbus", 900,
                10000, "A320", AirplaneType.PASSENGER, 4, 6000, 195,
                120, 265);

        Airplane passengerAirplane2 = new PassengerAirplane("S513", "Airbus", 900,
                10500, "A370", AirplaneType.PASSENGER, 3, 5000, 200,
                160, 256);
        Airplane cargoAirplane2 = new CargoAirplane("GH15", "Bombardier", 800,
                11000, "B234", AirplaneType.CARGO, 4, 5000, 200,
                180, 220);
        Airplane passengerAirplane3 = new PassengerAirplane("Y1456", "Boeing", 950,
                8000, "737", AirplaneType.PASSENGER, 5, 6500, 180,
                130, 277);
        airplanesTest.add(cargoAirplane1);
        airplanesTest.add(passengerAirplane1);
        airplanesTest.add(passengerAirplane2);
        airplanesTest.add(cargoAirplane2);
        airplanesTest.add(passengerAirplane3);

    }

    @Test
    public void testGetAirplanesQuantity() {
        int airplanes = airlineService.getAirplanesQuantity(airplanesRightData);
        assertEquals(5, airplanes);
    }

    @Test
    public void testCreateAirplanesList_success() {
        List<Airplane> airplanes = airplanesRightData;
        assertEquals(airplanes.get(0), airplanesTest.get(0));
        assertEquals(airplanes.get(1), airplanesTest.get(1));
        assertEquals(airplanes.get(2), airplanesTest.get(2));
        assertEquals(airplanes.get(3), airplanesTest.get(3));
        assertEquals(airplanes.get(4), airplanesTest.get(4));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCreateAirplanesList_wrongInputData() {
        airplanesWrongData = airlineService.createAirplanesList(WRONG_DATA);
        List<Airplane> airplanes = airplanesWrongData;
        assertEquals(airplanes.get(0), airplanesTest.get(0));
        assertEquals(airplanes.get(1), airplanesTest.get(1));
        assertEquals(airplanes.get(2), airplanesTest.get(2));
        assertEquals(airplanes.get(3), airplanesTest.get(3));
        assertEquals(airplanes.get(4), airplanesTest.get(4));
    }

    @Test
    public void testFindTotalCrewCapacity() {
        int crews = airlineService.findTotalCrewCapacity(airplanesRightData);
        assertEquals(18, crews);
    }


    @Test
    public void testFindTotalAirplanesCapacity() {
        int total = airlineService.findTotalAirplanesCapacity(airplanesRightData);
        assertEquals(816, total);
    }

    @Test
    public void testFindTotalPassengersCapacity() {
        int total = airlineService.findTotalPassengersCapacity(airplanesRightData);
        assertEquals(798, total);
    }

    @Test
    public void testFindTotalAirplanesCarryingCapacity() {
        int total = airlineService.findTotalAirplanesCarryingCapacity(airplanesRightData);
        assertEquals(440, total);
    }

    @Test
    public void findPlaneByFuelConsumptionRange() {
        Airplane airplane = airlineService.findPlaneByFuelConsumptionRange(airplanesRightData, 100, 200);
        assertEquals(airplane.getFuelConsumption(), 120.0, 0.01);
    }
}