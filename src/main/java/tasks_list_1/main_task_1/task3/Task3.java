package tasks_list_1.main_task_1.task3;

/**
 * @author Viktar on 13.09.2019
 */
public class Task3 {
    public static void main(String[] args) {
        double ringArea = findRingArea(10, 5);
        System.out.println("The ring's are = " + ringArea);
    }

    private static double findRingArea(double radius1, double radius2) {
        if (radius1 > radius2) {
            return findCircleArea(radius1) - findCircleArea(radius2);
        } else {
            System.out.println("R1 can not be less R2");
        }
        return 0;
    }

    private static double findCircleArea(double radius) {
        return Math.PI * (Math.pow(radius, 2));
    }
}
