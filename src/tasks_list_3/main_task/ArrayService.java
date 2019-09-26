package tasks_list_3.main_task;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Viktar on 24.09.2019
 */
public class ArrayService {

    int[][] arrayInitializator() {

        System.out.println("Enter number of rows: ");
        int rows = inputNumber();
        System.out.println("Enter number of columns: ");
        int columns = inputNumber();
        System.out.println("Range of numbers.");
        System.out.println("Enter a minimal number: ");
        int minValue = inputNumber();
        System.out.println("Enter a maximal number:");
        int maxValue = inputNumber();
        int[][] arr = new int[rows][columns];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt((maxValue - minValue) + 1) + minValue;
            }
        }
        return arr;
    }


    int findMinElement(int[][] arr) {
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }

    int findMaxElement(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    double findArithmeticalAverage(int[][] arr) {
        int sum = 0;
        int totalElements = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
                totalElements++;
            }
        }
        return (double) sum / totalElements;
    }

    double findGeomethricalAverage(int[][] arr) {
        double product = 1;
        int totalElements = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                product *= arr[i][j];
                totalElements++;
            }
        }
        return Math.pow(product, 1.0 / totalElements);
    }

    int findLocalMinimum(int[][] arr) {
        if ((arr.length > 1) && (arr[0].length > 1)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if ((i == 0) && (j == 0)) {
                        if ((arr[i][j] < arr[i][j + 1]) && (arr[i][j] < arr[i + 1][j])) {
                            System.out.println("The first local minimum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if ((i == 0) && (j == arr[i].length - 1)) {
                        if ((arr[i][j] < arr[i][j - 1]) && (arr[i][j] < arr[i + 1][j])) {
                            System.out.println("The first local minimum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if ((i == arr.length - 1) && (j == 0)) {
                        if ((arr[i][j] < arr[i - 1][j]) && (arr[i][j] < arr[i][j + 1])) {
                            System.out.println("The first local minimum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if ((i == arr.length - 1) && (j == arr[i].length - 1)) {
                        if ((arr[i][j] < arr[i][j - 1]) && (arr[i][j] < arr[i - 1][j])) {
                            System.out.println("The first local minimum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if (i == 0) {
                        if ((arr[i][j] < arr[i + 1][j]) && (arr[i][j] < arr[i][j - 1]) && (arr[i][j] < arr[i][j + 1])) {
                            System.out.println("The first local minimum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if (i == arr.length - 1) {
                        if ((arr[i][j] < arr[i - 1][j]) && (arr[i][j] < arr[i][j + 1]) && (arr[i][j] < arr[i][j - 1])) {
                            System.out.println("The first local minimum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if (j == 0) {
                        if ((arr[i][j] < arr[i][j + 1]) && (arr[i][j] < arr[i - 1][j]) && (arr[i][j] < arr[i + 1][j])) {
                            System.out.println("The first local minimum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if (j == arr[i].length - 1) {
                        if ((arr[i][j] < arr[i + 1][j]) && (arr[i][j] < arr[i - 1][j]) && (arr[i][j] < arr[i][j - 1])) {
                            System.out.println("The first local minimum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if ((arr[i][j] < arr[i + 1][j]) && (arr[i][j] < arr[i - 1][j]) && (arr[i][j] < arr[i][j + 1]) && (arr[i][j] < arr[i + 1][j - 1])) {
                        System.out.println("The first local minimum is on " + i + " " + j);
                        return arr[i][j];
                    }
                }
            }
        } else {
            System.out.println("Error: this is not a matrix");
        }
        return -1;
    }


    int findLocalMaximum(int[][] arr) {
        if ((arr.length > 1) && (arr[0].length > 1)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if ((i == 0) && (j == 0)) {
                        if ((arr[i][j] > arr[i][j + 1]) && (arr[i][j] > arr[i + 1][j])) {
                            System.out.println("The first local maximum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if ((i == 0) && (j == arr[i].length - 1)) {
                        if ((arr[i][j] > arr[i][j - 1]) && (arr[i][j] > arr[i + 1][j])) {
                            System.out.println("The first local maximum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if ((i == arr.length - 1) && (j == 0)) {
                        if ((arr[i][j] > arr[i - 1][j]) && (arr[i][j] > arr[i][j + 1])) {
                            System.out.println("The first local maximum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if ((i == arr.length - 1) && (j == arr[i].length - 1)) {
                        if ((arr[i][j] > arr[i][j - 1]) && (arr[i][j] > arr[i - 1][j])) {
                            System.out.println("The first local maximum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if (i == 0) {
                        if ((arr[i][j] > arr[i + 1][j]) && (arr[i][j] > arr[i][j - 1]) && (arr[i][j] > arr[i][j + 1])) {
                            System.out.println("The first local maximum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if (i == arr.length - 1) {
                        if ((arr[i][j] > arr[i - 1][j]) && (arr[i][j] > arr[i][j + 1]) && (arr[i][j] > arr[i][j - 1])) {
                            System.out.println("The first local maximum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if (j == 0) {
                        if ((arr[i][j] > arr[i][j + 1]) && (arr[i][j] > arr[i - 1][j]) && (arr[i][j] > arr[i + 1][j])) {
                            System.out.println("The first local maximum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if (j == arr[i].length - 1) {
                        if ((arr[i][j] > arr[i + 1][j]) && (arr[i][j] > arr[i - 1][j]) && (arr[i][j] > arr[i][j - 1])) {
                            System.out.println("The first local maximum is on " + i + " " + j);
                            return arr[i][j];
                        }
                    } else if ((arr[i][j] > arr[i + 1][j]) && (arr[i][j] > arr[i - 1][j]) && (arr[i][j] > arr[i][j + 1]) && (arr[i][j] > arr[i][j - 1])) {
                        System.out.println("The first local maximum is on " + i + " " + j);
                        return arr[i][j];
                    }
                }
            }
        } else {
            System.out.println("Error: this is not a matrix");
        }
        return -1;
    }

    int[][] matrixTransponator(int[][] arr) {
        if (arr[0].length == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr[i].length; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
            return arr;
        } else {
            int[][] newArr = new int[arr[0].length][arr.length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    newArr[j][i] = arr[i][j];
                }
            }
            return newArr;
        }
    }

    void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int inputNumber() {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("Enter a number greater than 0");
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Enter a number greater than 0");
            }
            num = sc.nextInt();
        } while (num <= 0);
        return num;
    }
}
