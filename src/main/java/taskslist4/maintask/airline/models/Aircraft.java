package taskslist4.maintask.airline.models;

/**
 * @author Viktar on 30.09.2019
 */
public abstract class Aircraft {
    private String manufacturer;
    private int maxSpeed;
    private int maxAltitude;

    public Aircraft(String manufacturer, int maxSpeed, int maxAltitude) {
        this.manufacturer = manufacturer;
        this.maxSpeed = maxSpeed;
        this.maxAltitude = maxAltitude;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    @Override
    public String toString() {
        return "MANUFACTURER: " + manufacturer + "\n" +
                "Max speed: " + maxSpeed + " km/ph\n" +
                "Flight altitude: " + maxAltitude + " km\n";
    }
}
