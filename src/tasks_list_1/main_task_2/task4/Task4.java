package tasks_list_1.main_task_2.task4;

/**
 * @author Viktar on 14.09.2019
 */
public class Task4 {
    public static void main(String[] args) {
        findNextDaysDate(31, 3, 2008);
    }

    private static void findNextDaysDate(int day, int month, int year) {
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;

        if (month == 2) {
            if ((checkYearForLeap(year)) && day == 29) {
                nextDay = 1;
                nextMonth++;
            } else if ((!checkYearForLeap(year)) && day == 28) {
                nextDay = 1;
                nextMonth++;
            }
            else {
                nextDay++;
            }
        }else {
            if((month==4 || month == 6 || month == 9 || month == 11) && day == 30){
                nextDay = 1;
                nextMonth++;
            }else if(month == 12 && day == 31){
                nextDay = 1;
                nextMonth = 1;
                nextYear++;
            }else if (day == 31){
                nextDay = 1;
                nextMonth++;
            }else {
                nextDay++;
            }
        }
        System.out.println("Next date: " + nextDay + "-" + nextMonth + "-" + nextYear);
    }

    private static boolean checkYearForLeap(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
