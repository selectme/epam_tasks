package tasks_list_2.main_task.task1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Viktar on 19.09.2019
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println("How many times would you like to play \"Head or Tails\"?");
        playHeadOrTails(inputNumber());
    }

    private static void playHeadOrTails(int times) {
        Random random = new Random();
        int head = 0;
        int tail = 0;
        for (int i = 0; i < times; i++) {
            if (random.nextInt(2) == 0) {
                head++;
            } else {
                tail++;
            }
        }
        System.out.println("Heads: " + head + "\nTails: " + tail);
    }

    private static int inputNumber() {
        Scanner sc = new Scanner(System.in);
        int num;
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
