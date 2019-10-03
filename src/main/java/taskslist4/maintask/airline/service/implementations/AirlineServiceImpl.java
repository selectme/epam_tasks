package taskslist4.maintask.airline.service.implementations;

import taskslist4.maintask.airline.models.Airplane;
import taskslist4.maintask.airline.models.AirplaneType;
import taskslist4.maintask.airline.models.CargoAirplane;
import taskslist4.maintask.airline.models.PassengerAirplane;
import taskslist4.maintask.airline.comparators.AirplaneCrewCapacityComparator;
import taskslist4.maintask.airline.comparators.AirplanePassengersCapacityComparator;
import taskslist4.maintask.airline.service.AirlineService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Viktar on 30.09.2019
 */
public class AirlineServiceImpl implements AirlineService {

    /**
     * Creates array of {@link Airplane}  from a list of airplanes
     *
     * @param filePath path to the airplanes list
     * @return array of {@link Airplane}
     */
    public Airplane[] createAirplanesList(String filePath) {
        Scanner input = fileInput(filePath);

        String sideNumber;
        String manufacturer;
        String model;
        AirplaneType airplaneType;
        int crew;
        int passengers;
        int maxSpeed;
        int maxAltitude;
        int maxFlightRange;
        int fuelSupply;
        double fuelConsumption;
        int cargoCapacity;

        input.nextLine();

        Airplane[] airplanes = new Airplane[getAirplanesQuantity(filePath)];
        int arrayPosition = 0;
        while (input.hasNextLine()) {

            String[] characteristics = input.nextLine().split("\\|");
            sideNumber = characteristics[0].trim();
            manufacturer = characteristics[1].trim();
            model = characteristics[2].trim();

            try {
                airplaneType = AirplaneType.valueOf(characteristics[3].trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR! Airplane " + sideNumber + " must be only Passenger or Cargo. Check your airplanes list");
                continue;
            }

            try {
                crew = Integer.parseInt(characteristics[4].trim());
                if (crew < 0) {
                    throw new IllegalArgumentException("ERROR! Crew can't be less than 0 and it must be a natural number. Check the airplane number " + sideNumber);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR! Crew must be a natural number. Check the airplane number " + sideNumber, e);
            }

            try {
                passengers = Integer.parseInt(characteristics[5].trim());
                if (passengers < 0) {
                    throw new IllegalArgumentException("ERROR! Passengers can't be less than 0 and it must be a natural number. Check the airplane number " + sideNumber);
                } else if ((airplaneType == AirplaneType.CARGO) && (passengers > 0)) {
                    throw new IllegalStateException("Cargo type can't have passengers. Check the airplane number " + sideNumber);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR! Passengers must be a natural number. Check the airplane number " + sideNumber, e);
            }

            try {
                maxSpeed = Integer.parseInt(characteristics[6].trim());
                if (maxSpeed < 0) {
                    throw new IllegalArgumentException("Error! Max speed can't be negative. Check the airplane number " + sideNumber);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR! Max speed must be a positive natural number. Check the airplane number " + sideNumber);
            }

            try {
                maxAltitude = Integer.parseInt(characteristics[7].trim());
                if (maxAltitude < 0) {
                    throw new IllegalArgumentException("Error! Max altitude can't be negative. Check the airplane number " + sideNumber);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR! Max altitude must be a positive natural number. Check the airplane number " + sideNumber);
            }

            try {
                maxFlightRange = Integer.parseInt(characteristics[8].trim());
                if (maxFlightRange < 0) {
                    throw new IllegalArgumentException("ERROR! Max flight range can't be negative. Check the airplane number " + sideNumber);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR! Max speed must be a positive natural number. Check the airplane number " + sideNumber);
            }

            try {
                fuelSupply = Integer.parseInt(characteristics[9].trim());
                if (fuelSupply < 0) {
                    throw new IllegalArgumentException("ERROR! Fuel supply range can't be negative. Check the airplane number " + sideNumber);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR! Fuel supply must be a positive natural number. Check the airplane number " + sideNumber);
            }

            try {
                fuelConsumption = Double.parseDouble(characteristics[10].trim());
                if (fuelConsumption < 0) {
                    throw new IllegalArgumentException("ERROR! Fuel consumption can't be negative. Check the airplane number " + sideNumber);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR! Fuel consumption must be a positive number. Check the airplane number " + sideNumber);
            }

            try {
                cargoCapacity = Integer.parseInt(characteristics[11].trim());
                if ((airplaneType == AirplaneType.PASSENGER) && ((cargoCapacity > 0) || (cargoCapacity < 0))) {
                    throw new IllegalArgumentException("Error! Passenger airplane does not carry cargo. Check the airplane number " + sideNumber);
                } else if (cargoCapacity < 0) {
                    throw new IllegalArgumentException("ERROR! Cargo capacity can't negative it must be a natural number. Check the airplane number " + sideNumber);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERROR! Cargo capacity must be a natural number. Check the airplane number " + sideNumber);
            }

            if (airplaneType == AirplaneType.CARGO) {
                airplanes[arrayPosition] = new CargoAirplane(sideNumber, manufacturer, maxSpeed, maxAltitude, model, airplaneType, crew, maxFlightRange, fuelSupply, fuelConsumption, cargoCapacity);
            } else {
                airplanes[arrayPosition] = new PassengerAirplane(sideNumber, manufacturer, maxSpeed, maxAltitude, model, airplaneType, crew, maxFlightRange, fuelSupply, fuelConsumption, passengers);
            }
            arrayPosition++;
        }
        return airplanes;
    }

    /**
     * Finds total passengers and crew capacity of all airplanes
     *
     * @param airplanes array of{@link Airplane}
     * @return quantity of passengers and crew of all airplanes
     */
    public int findTotalAirplanesCapacity(Airplane[] airplanes) {
        return findTotalPassengersCapacity(airplanes) + findTotalCrewCapacity(airplanes);
    }

    /**
     * Finds passengers capacity of all airplanes
     *
     * @param airplanes array of {@link Airplane}
     * @return total passengers capacity of all airplanes
     */
    public int findTotalPassengersCapacity(Airplane[] airplanes) {

        int sumOfPassengers = 0;
        for (Airplane airplane : airplanes) {
            if (airplane instanceof PassengerAirplane) {
                sumOfPassengers += ((PassengerAirplane) airplane).getMaxPassengers();
            }
        }
        return sumOfPassengers;
    }

    /**
     * Finds crew capacity of all airplanes
     *
     * @param airplanes array of {@link Airplane}
     * @return total quantity of crew from all airplanes
     */
    public int findTotalCrewCapacity(Airplane[] airplanes) {
        int sumOfCrews = 0;
        for (Airplane airplane : airplanes) {
            sumOfCrews += airplane.getCrewQuantity();
        }
        return sumOfCrews;
    }

    /**
     * Finds carrying capacity of all airplanes
     *
     * @param airplanes array of {@link Airplane}
     * @return total carrying capacity of all airplanes
     */
    public int findTotalAirplanesCarryingCapacity(Airplane[] airplanes) {
        int carryingSum = 0;
        for (Airplane airplane : airplanes) {
            if (airplane instanceof CargoAirplane) {
                CargoAirplane cargoAirplane = (CargoAirplane) airplane;
                carryingSum += cargoAirplane.getCargoCapacity();
            }
        }
        return carryingSum;
    }

    /**
     * Checks if text file exists
     *
     * @param filePath path to text file
     * @return Scanner
     */
    public Scanner fileInput(String filePath) {
        File file = new File(filePath);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return input;
    }

    /**
     * Gets quantity of airplanes from the airplanes text file
     *
     * @param filePath path to text file
     * @return quantity of airplanes
     */
    public int getAirplanesQuantity(String filePath) {
        Scanner scanner = fileInput(filePath);
        int airplanesCounter = 0;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            airplanesCounter++;
        }
        return airplanesCounter;
    }

    /**
     * Sorts airplanes by passengers capacity, then sorts by crew capacity
     *
     * @param airplanes array of{@link Airplane}
     */
    public void sortByPassengersAndCrewCapacity(Airplane[] airplanes) {
        Comparator<Airplane> comparator = new AirplanePassengersCapacityComparator().thenComparing(new AirplaneCrewCapacityComparator());
        Arrays.sort(airplanes, comparator);
        for (Airplane airplane : airplanes) {
            System.out.println(airplane);
        }
    }

    /**
     * Sorts airplanes by passengers capacity.
     *
     * @param airplanes array of {@link Airplane}
     */
    public void sortByPassengersCapacity(Airplane[] airplanes) {
        Comparator<Airplane> comparator = new AirplanePassengersCapacityComparator();
        Arrays.sort(airplanes, comparator);
        for (Airplane airplane : airplanes) {
            System.out.println(airplane);
        }
    }

    /**
     * Sorts airplanes by crew capacity
     *
     * @param airplanes array of{@link Airplane}
     */
    public void sortByCrewCapacity(Airplane[] airplanes) {
        Comparator<Airplane> comparator = new AirplaneCrewCapacityComparator();
        Arrays.sort(airplanes, comparator);
        for (Airplane airplane : airplanes) {
            System.out.println(airplane);
        }
    }

    /**
     * Finds an airplane suitable for the given parameters of fuel consumption, then finds the most economical airplane
     *
     * @param airplanes array of {@link Airplane}
     * @param rangeFrom minimal value of fuel consumption
     * @param rangeTo   max value of fuel consumption
     * @return the most economical airplane suitable of given parameters
     */
    public Airplane findPlaneByFuelConsumptionRange(Airplane[] airplanes, int rangeFrom, int rangeTo) {
        Airplane theMostEconomicalPlane = airplanes[0];
        for (Airplane airplane : airplanes) {
            if ((airplane.getFuelConsumption() >= rangeFrom) && (airplane.getFuelConsumption() <= rangeTo)) {
                if (theMostEconomicalPlane.getFuelConsumption() > airplane.getFuelConsumption()) {
                    theMostEconomicalPlane = airplane;
                }
            }
        }
        return theMostEconomicalPlane;
    }
}
