package tasks_list_1.main_task_2.task1;

/**
 * @author Viktar on 13.09.2019
 */
public class Task1 {
    public static void main(String[] args) {
        double x1 = -3;
        double y1 = -2;
        double x2 = 0;
        double y2 = -1;
        double x3 = -2;
        double y3 = 5;

        checkForTriangleByCoordinats(x1, y1, x2, y2, x3, y3);
    }

    private static void checkForTriangleByCoordinats(double x1, double y1, double x2, double y2, double x3, double y3) {
        double AB = findSideOfTriangle(x1, y1, x2, y2);
        double BC = findSideOfTriangle(x3, y3, x2, y2);
        double AC = findSideOfTriangle(x3, x1, y3, y1);

        if (AB < BC + AC &&
                BC < AB + AC &&
                AC < AB + BC) {
            System.out.println("Is triangle");
            checkForRightTriangle(AB, BC, AC);
        } else {
            System.out.println("Is not triangle");
        }
    }

    private static double findSideOfTriangle(double x1, double y1, double x2, double y2) {
        return Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)));
    }

    private static void checkForRightTriangle(double a, double b, double c) {
        double hypotenuse;
        double cathet1;
        double cathet2;
        if (a > b && a > c) {
            hypotenuse = a;
            cathet1 = b;
            cathet2 = c;
        } else {
            if (b > c) {
                hypotenuse = b;
                cathet1 = a;
                cathet2 = c;
            } else {
                hypotenuse = c;
                cathet1 = a;
                cathet2 = b;
            }
        }

        if (Math.pow(hypotenuse, 2) == Math.pow(cathet1, 2) + Math.pow(cathet2, 2)) {
            System.out.println("Is right triangle");
        } else {
            System.out.println("Is not right triangle");
        }
    }
}

