package tasks_list_1.main_task_1.task7;

/**
 * @author Viktar on 13.09.2019
 */
public class Task7 {
    public static void main(String[] args) {
        changeValuesOfVariables(10, 5);
    }

    private static void changeValuesOfVariables(int a, int b) {
        System.out.println("Before changing: ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        if (a == b) {
            System.out.println("Nums are equal");
        } else {
            a = a + b;
            b = a - b;
            a = a - b;
        }

        System.out.println("After changing: ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
