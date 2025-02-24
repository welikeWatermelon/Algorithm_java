package src._1_string;

import java.util.Scanner;

public class str1_7 {
    public static String solution(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        String reversedStr = new StringBuilder(str).
                reverse().toString().
                toLowerCase();

        String newstr = str.toLowerCase();
        if (newstr.equals(reversedStr)) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        str1_7 main = new str1_7();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(main.solution(str));
    }
}
