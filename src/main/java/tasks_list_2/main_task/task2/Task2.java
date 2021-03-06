package tasks_list_2.main_task.task2;

import java.util.Scanner;

/**
 * @author Viktar on 19.09.2019
 */
public class Task2 {

    public static void main(String[] args) {
        findSimpleDivisorsOfNumber(inputNumber());
    }

    //найти наибольшую цифру натурального числа;
    private static int findTheGreatestNumOfDigit(int num) {
        int greatestNum = 0;
        int digit;
        while (num > 0) {
            digit = num % 10;
            if (digit > greatestNum) {
                greatestNum = digit;
            }
            num /= 10;
        }
        return greatestNum;
    }

    //    проверить, является ли заданное натуральное число палиндромом;
    private static boolean checkIsPalindrome(int num) {
        int palindrome = num;
        int reverse = 0;
        int digit;
        while (palindrome > 0) {
            digit = palindrome % 10;
            reverse = reverse * 10 + digit;
            palindrome /= 10;
        }
        return num == reverse;
    }

    //    определить является ли заданное натуральное число простым;
    private static boolean checkIsSimpleNumber(int num) {
        int divisorCounter = 0;
        if (num > 1) {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    divisorCounter++;
                    if (divisorCounter > 0) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    //    найти все простые делители заданного натурального числа;
    private static void findSimpleDivisorsOfNumber(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                if (checkIsSimpleNumber(i)) {
                    System.out.println(i);
                }
            }
        }
    }

    //найти НОД двух натуральных чисел a и b.
    private static int findGreatestCommonDivisor(int a, int b) {
        int greatestCommonDivisor = 1;
        int counter;
        if (a == b) {
            counter = a;
        } else if (a > b) {
            counter = a;
        } else {
            counter = b;
        }

        for (int i = 2; i <= counter; i++) {
            if (a % i == 0 && b % i == 0) {
                if (i > greatestCommonDivisor) {
                    greatestCommonDivisor = i;
                }
            }
        }
        return greatestCommonDivisor;
    }

    //найти НОК двух натуральных чисел a и b.
    private static int findLeastCommonMultiple() {
        int a = inputNumber();
        int b = inputNumber();
        return (a * b) / findGreatestCommonDivisor(a, b);
    }

    //найти количество различных цифр у заданного натурального числа.
    private static int findDifferentDigitsOfNumber(int num) {
        int digit;
        int tempDigit;
        int tempNumber;
        int counter;
        int counterDiffDigits = 0;
        while (num > 0) {
            digit = num % 10;
            tempNumber = num;
            counter = 0;
            while (tempNumber > 0) {
                tempDigit = tempNumber % 10;
                if (digit == tempDigit) {
                    counter++;
                }
                tempNumber /= 10;
            }
            if (counter == 1) {
                counterDiffDigits++;
            }
            num /= 10;
        }
        return counterDiffDigits;
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
