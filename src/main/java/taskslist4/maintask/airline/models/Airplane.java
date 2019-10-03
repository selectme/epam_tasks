package taskslist4.maintask.airline.models;

/**
 * @author Viktar on 29.09.2019
 */
public abstract class Airplane extends Aircraft {

    private String sideNumber;
    private String model;
    private AirplaneType airplaneType;
    private int crewQuantity;
    private int maxFlightRange;
    private int fuelSupply;
    private double fuelConsumption;

    /**
     *
     * @param sideNumber side number of an airplane
     * @param manufacturer brand of an airplane
     * @param maxSpeed max speed of an airplane, km per hour
     * @param maxAltitude max altitude of airplane, meters
     * @param model model of airplane
     * @param airplaneType {@link AirplaneType}
     * @param crewQuantity crew quantity of an airplane
     * @param maxFlightRange max flight distance of an airplane, km
     * @param fuelSupply fuel supply or tank capacity of an airplane, ton
     * @param fuelConsumption fuel consumption of an airplane, kg per hour
     */
    public Airplane(String sideNumber, String manufacturer, int maxSpeed, int maxAltitude, String model,
                    AirplaneType airplaneType, int crewQuantity, int maxFlightRange, int fuelSupply, double fuelConsumption) {
        super(manufacturer, maxSpeed, maxAltitude);
        this.sideNumber = sideNumber;
        this.model = model;
        this.airplaneType = airplaneType;
        this.crewQuantity = crewQuantity;
        this.maxFlightRange = maxFlightRange;
        this.fuelSupply = fuelSupply;
        this.fuelConsumption = fuelConsumption;
    }

    public String getSideNumber() {
        return sideNumber;
    }

    public void setSideNumber(String sideNumber) {
        this.sideNumber = sideNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    public int getCrewQuantity() {
        return crewQuantity;
    }

    public void setCrewQuantity(int crewQuantity) {
        this.crewQuantity = crewQuantity;
    }

    public int getMaxFlightRange() {
        return maxFlightRange;
    }

    public void setMaxFlightRange(int maxFlightRange) {
        this.maxFlightRange = maxFlightRange;
    }

    public int getFuelSupply() {
        return fuelSupply;
    }

    public void setFuelSupply(int fuelSupply) {
        this.fuelSupply = fuelSupply;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "Side number: " + getSideNumber() + "\n" +
                "Manufacturer: " + super.getManufacturer() + "\n" +
                "Type: " + airplaneType + "\n" +
                "Model: " + model + "\n" +
                "Crew: " + crewQuantity + "\n" +
                "Max speed: " + super.getMaxSpeed() + " km/ph\n" +
                "Flight altitude: " + super.getMaxAltitude() + " km\n" +
                "Flight range: " + maxFlightRange + " km\n" +
                "Fuel supply: " + fuelSupply + " t\n" +
                "Fuel consumption: " + getFuelConsumption() + " kg/ph\n";
    }
}
