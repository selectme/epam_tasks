package tasks_list_1.main_task_2.task2;

/**
 * @author Viktar on 13.09.2019
 */
public class Task2 {
    public static void main(String[] args) {
        findDragonHeads(785);
    }

    public static void findDragonHeads(int age) {
        int sumHeads = 3;

        if (age >= 1) {
            if (age < 200) {
                sumHeads = sumHeads + (3 * age);
            } else if (age >= 200) {
                if (age < 300) {
                    sumHeads = sumHeads + (200 * 3) + (2 * (age - 200));
                } else {
                    sumHeads = sumHeads + (200 * 3) + (100 * 2) + (age - 300);
                }
            }
        }

        int eyes = sumHeads * 2;
        System.out.println("Dragon has " + sumHeads + " heads and " + eyes + " eyes.");
    }
}
