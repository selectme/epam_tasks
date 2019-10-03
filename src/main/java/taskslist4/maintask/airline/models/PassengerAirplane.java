package taskslist4.maintask.airline.models;

/**
 * @author Viktar on 30.09.2019
 */
public class PassengerAirplane extends Airplane {
    private int maxPassengers;

    public PassengerAirplane(String sideNumber, String manufacturer, int maxSpeed, int maxAltitude, String model,
                             AirplaneType airplaneType, int crewQuantity, int maxFlightRange, int fuelSupply, double fuelConsumption, int maxPassengers) {
        super(sideNumber, manufacturer, maxSpeed, maxAltitude, model, airplaneType, crewQuantity, maxFlightRange, fuelSupply, fuelConsumption);
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String toString() {
        return "Side number: " + getSideNumber() + "\n" +
                "Manufacturer: " + super.getManufacturer() + "\n" +
                "Type: " + super.getAirplaneType() + "\n" +
                "Model: " + super.getModel() + "\n" +
                "Crew: " + super.getCrewQuantity() + "\n" +
                "Passengers: " + getMaxPassengers() + "\n" +
                "Max speed: " + super.getMaxSpeed() + " km/ph\n" +
                "Flight altitude: " + super.getMaxAltitude() + " km\n" +
                "Flight range: " + super.getMaxFlightRange() + " km\n" +
                "Fuel supply: " + super.getFuelSupply() + " t\n" +
                "Fuel consumption: " + super.getFuelConsumption() + " kg/ph\n";
    }
}
