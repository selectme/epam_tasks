package tasks_list_3.main_task;

/**
 * @author Viktar on 24.09.2019
 */
public class Main {
    public static void main(String[] args) {
        ArrayService arrayService = new ArrayService();

        int[][] arr = arrayService.arrayInitializator();
//        int[][] arr = {{7, 10, 1, 9}, {5, 6, 7, 8}, {12, 4, 3 , 5}};

        arrayService.printMatrix(arr);

        System.out.println("Min element: " + arrayService.findMinElement(arr));
        System.out.println("Max element: " + arrayService.findMaxElement(arr));
        System.out.println("Arithmetical average: " + arrayService.findArithmeticalAverage(arr));
        System.out.println("Geomethrical average: " + arrayService.findGeomethricalAverage(arr));
        System.out.println("The first local minimum " + arrayService.findLocalMinimum(arr));
        System.out.println("The first local maximum " + arrayService.findLocalMaximum(arr));

        arrayService.printMatrix(arrayService.matrixTransponator(arr));
    }
}
