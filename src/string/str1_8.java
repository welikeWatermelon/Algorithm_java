package src.string;

import java.util.Scanner;

public class str1_8 {
    public static String solution(String str) {
        StringBuilder test = new StringBuilder();

        for (char a : str.toCharArray()) {
            if (Character.isLetter(a)) {
                test.append(a);
            }
        }

        String reversedStr = test.reverse().
                toString().toLowerCase();

        String originStr = test.toString().toLowerCase();

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
