package src.string;

import java.util.Scanner;

public class str1_12v2 {
    public static String solution(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            //
            String tmp = s.substring(0, 7).replace('#','1').replace('*','0');
            int num = Integer.parseInt(tmp, 2); //tmp를 2진수로 만듬
            answer += (char) num;
            // 7부터 끝까지의 인덱스만 남김
            s = s.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) {
        str1_12v2 main = new str1_12v2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(main.solution(n, str));
    }
}

