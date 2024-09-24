package src.string;

import java.util.Scanner;

public class str1_9v2 {
    public static int solution(String str) {
        int answer = 0;
        for (char x : str.toCharArray()) {
            //아스키 외워
            //x가 숫자인 문자라면 '0' : 48
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        str1_9v2 main = new str1_9v2();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(main.solution(str));
    }
}
