package tasks_list_1.main_task_1.task6;

/**
 * @author Viktar on 13.09.2019
 */
public class Task6 {
    public static void main(String[] args) {
        int n = 1234560;
        int reverse = reverseNum(n);
        System.out.println(reverse);
    }

    private static int reverseNum(int num) {
        int i = 1_000_000;
        int reverse = 0;
        while (num > 0) {
            int x = num % 10;
            int x2 = x * i;
            reverse = reverse + x2;
            num = num/10;
            i = i / 10;
        }
        return reverse;
    }
}
