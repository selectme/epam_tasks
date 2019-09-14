package tasks_list_1.main_task_1.task2;

/**
 * @author Viktar on 13.09.2019
 */
public class Task2 {
    public static void main(String[] args) {

        findDinosWeightInDifferenceMeasures(500);
    }

    private static void findDinosWeightInDifferenceMeasures(double kilos) {
        double mg = convertToMilligram(kilos);
        double gramms = convertToGrams(kilos);
        double tons = convertToTon(kilos);
        System.out.println("Dinos weight in:" +
                "\nKg: " + kilos +
                "\nMiligrams: " + mg +
                "\nGramms: " + gramms +
                "\nTons: " + tons);
    }

    private static double convertToMilligram(double kilos) {
        return kilos / 0.000001;
    }

    private static double convertToGrams(double kilos) {
        return kilos / 0.001;
    }

    private static double convertToTon(double kilos) {
        return kilos / 1000;
    }
}
