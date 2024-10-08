package src._1_string;

import java.util.Scanner;

public class str1_9v3 {
    public static int solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            //Character.isDigit(x) : x가 숫자면 true
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        str1_9v3 main = new str1_9v3();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(main.solution(str));
    }
}
