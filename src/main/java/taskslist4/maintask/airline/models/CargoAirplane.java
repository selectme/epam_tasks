package taskslist4.maintask.airline.models;

/**
 * @author Viktar on 30.09.2019
 */
public class CargoAirplane extends Airplane {
    private int cargoCapacity;

    public CargoAirplane(String sideNumber, String manufacturer, int maxSpeed, int maxAltitude, String model,
                         AirplaneType airplaneType, int crewQuantity, int maxFlightRange, int fuelSupply, double fuelConsumption, int carryingCapacity1) {
        super(sideNumber, manufacturer, maxSpeed, maxAltitude, model, airplaneType, crewQuantity, maxFlightRange, fuelSupply, fuelConsumption);
        this.cargoCapacity = carryingCapacity1;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String toString() {
        return "Side number: " + getSideNumber() + "\n" +
                "Manufacturer: " + super.getManufacturer() + "\n" +
                "Type: " + super.getAirplaneType() + "\n" +
                "Model: " + super.getModel() + "\n" +
                "Crew: " + super.getCrewQuantity() + "\n" +
                "Max speed: " + super.getMaxSpeed() + " km/ph\n" +
                "Flight altitude: " + super.getMaxAltitude() + " km\n" +
                "Flight range: " + super.getMaxFlightRange() + " km\n" +
                "Carrying capacity: " + getCargoCapacity() + " t\n" +
                "Fuel supply: " + super.getFuelSupply() + " t\n" +
                "Fuel consumption: " + super.getFuelConsumption() + " t/ph\n";
    }
}
