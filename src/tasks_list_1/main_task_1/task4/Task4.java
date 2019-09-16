package tasks_list_1.main_task_1.task4;

/**
 * @author Viktar on 13.09.2019
 */
public class Task4 {
    public static void main(String[] args) {
        int num = 4321;
        checkForIncreasingSequence(num);
    }

    private static void checkForIncreasingSequence(int num) {
        int d = num % 10;
        num = num / 10;
        int c = num % 10;
        num = num / 10;
        int b = num % 10;
        num = num / 10;
        int a = num % 10;

        if (a <= b) {
            if (b <= c) {
                if (c <= d) {
                    System.out.println("Increasing sequence");
                } else {
                    System.out.println("Just a sequence of numbers");
                }
            } else {
                System.out.println("Just a sequence of numbers");
            }
        } else if (b >= c) {
            if (c >= d) {
                System.out.println("Descending sequence");
            } else {
                System.out.println("Just a sequence of numbers");
            }
        } else {
            System.out.println("Just a sequence of numbers");
        }
    }

    /* Можно и таким способом
                if (a <= b && b <= c && c <= d) {
            System.out.println("Increasing sequences");
        }else {
            System.out.println("Not increasing sequences");
        }*/
}
