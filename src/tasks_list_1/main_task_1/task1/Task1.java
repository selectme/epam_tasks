package tasks_list_1.main_task_1.task1;

/**
 * @author Viktar on 13.09.2019
 */

public class Task1 {
    public static void main(String[] args) {
        checkNumsforDifference(1, 1, 1);
    }

    private static void checkNumsforDifference(int a, int b, int c) {
        if (a == b) {
            if (b == c) {
                System.out.println("Nums are equal");
            }
            else System.out.println("Nums are difference");
        }
        else {
            System.out.println("Nums are difference");
        }
    }
}
