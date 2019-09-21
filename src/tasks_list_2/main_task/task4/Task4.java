package tasks_list_2.main_task.task4;

import java.util.Scanner;

/**
 * @author Viktar on 20.09.2019
 */
public class Task4 {
    public static void main(String[] args) {
        System.out.println(findSumOfDivisors(220));
    }

    private static void checkIsFriendlyNumber(){
        System.out.println("Enter range of number: ");
        System.out.println("Min: ");
        int min = inputNumber();
        System.out.println("Max");
        int max = inputNumber();
        int sumOfDivisors1 = 0;
        int sumOfDivisors2 = 0;
        for (int i = min; i <= max; i++) {
            sumOfDivisors1 = findSumOfDivisors(i);
            for (int j = i+1; j <= max; j++) {
                sumOfDivisors2 = findSumOfDivisors(j);
                if (sumOfDivisors1 == j && sumOfDivisors2 == i){
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    private static int findSumOfDivisors(int num){
        int sumOfDivisors = 0;
        for (int i = 1; i <= num/2; i++) {
            if(num % i == 0){
                sumOfDivisors+=i;
            }
        }
        return sumOfDivisors;
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
