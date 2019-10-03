package taskslist4.maintask.airline.comparators;

import taskslist4.maintask.airline.models.Airplane;

import java.util.Comparator;

/**
 * @author Viktar on 01.10.2019
 */
public class AirplaneCrewCapacityComparator implements Comparator<Airplane> {

    @Override
    public int compare(Airplane o1, Airplane o2) {
        return o2.getCrewQuantity() - o1.getCrewQuantity();
    }
}
