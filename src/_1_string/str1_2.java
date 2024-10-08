package src._1_string;

import java.util.Scanner;

public class str1_2 {
    public String solution(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            }else{
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        str1_2 main = new str1_2();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(main.solution(str));
    }
}