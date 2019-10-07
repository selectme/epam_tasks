package tasks_list_1.main_task_1.task5;

/**
 * @author Viktar on 13.09.2019
 */
public class Task5 {
    public static void main(String[] args) {
        System.out.println(findGeometricMean(123455));
    }

    private static double findArithmeticMean(int num) {
        int count = 0;
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
            count++;
        }
        return (double) sum/count;
    }

    private static double findGeometricMean(int num){
        int count = 0;
        int product = 1;
        while (num > 0) {
            product = product * (num % 10);
            num = num / 10;
            count++;
        }
        return Math.pow(product, 1.0/count);
    }
}
