package tasks_list_1.main_task_2.task3;

/**
 * @author Viktar on 14.09.2019
 */
public class Task3 {
    public static void main(String[] args) {
        checkLetterForVowelFourth('A');
    }

    /* First */
    private static void checkLetterForVowel(char c) {
        if (c == 'A' || c == 'a') {
            System.out.println("Vowel");
        } else if (c == 'E' || c == 'e') {
            System.out.println("Vowel");
        } else if (c == 'I' || c == 'i') {
            System.out.println("Vowel");
        } else if (c == 'O' || c == 'o') {
            System.out.println("Vowel");
        } else if (c == 'U' || c == 'u') {
            System.out.println("Vowel");
        } else {
            System.out.println("Is not vowel");
        }
    }

    /* Second */
    private static void checkLetterForVowelSecond(char c) {
        switch (c) {
            case 'A':
            case 'a':
            case 'E':
            case 'e':
            case 'I':
            case 'i':
            case 'O':
            case 'o':
            case 'U':
            case 'u':
                System.out.println("Vowel");
                break;
            default:
                System.out.println("Is not vowel");
                break;
        }
    }

    /* Third*/
    private static void checkLetterForVowelThird(char c) {
        char x = Character.toLowerCase(c);
        System.out.println(x);
        if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
            System.out.println("Vowel");
        } else {
            System.out.println("Is not vowel");
        }
    }

    /* Fourth*/
    private static void checkLetterForVowelFourth(char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        char x = Character.toLowerCase(c);
        for (int i = 0; i < vowels.length; i++) {
            if (x == vowels[i]) {
                System.out.println("Vowel");
                break;
            } else if (i == vowels.length - 1) {
                System.out.println("Is not vowel");
            }
        }
    }
}
