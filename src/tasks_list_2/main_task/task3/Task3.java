package tasks_list_2.main_task.task3;

import java.util.Scanner;

/**
 * @author Viktar on 20.09.2019
 */
public class Task3 {
    public static void main(String[] args) {
        System.out.println(checkIsPerfectNumber(inputNumber()));
    }

    private static boolean checkIsPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
                System.out.println(i);
            }
        }
        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

    private static int inputNumber() {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Enter a number greater than 0");
        while (true) {
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Enter a number greater than 0");
            }
            num = sc.nextInt();
            if (num > 0) {
                break;
            } else {
                System.out.println("Enter a number greater than 0");
                sc.nextLine();
            }
        }
        return num;
    }
}

