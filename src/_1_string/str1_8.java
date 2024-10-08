package src._1_string;

import java.util.Scanner;

public class str1_8 {
    public static String solution(String str) {
        StringBuilder test1 = new StringBuilder();
        StringBuilder test2 = new StringBuilder();

        for (char a : str.toCharArray()) {
            if (Character.isLetter(a)) {
                test1.append(a);
                test2.append(a);
            }
        }

        String reversedStr = test2.reverse().
                toString().toLowerCase();

        String originStr = test1.toString().toLowerCase();

        if (reversedStr.equals(originStr)) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        str1_8 main = new str1_8();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(main.solution(str));
    }
}
