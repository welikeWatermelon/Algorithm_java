package src._1_string;

import java.util.Scanner;

public class str1_9 {
    public static int solution(String str) {
        char[] array = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : array) {
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            }
        }
        String ans = stringBuilder.toString();
        int num = Integer.parseInt(ans);
        return num;
    }

    public static void main(String[] args) {
        str1_9 main = new str1_9();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(main.solution(str));
    }
}
