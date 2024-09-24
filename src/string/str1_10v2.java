package src.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class str1_10v2 {
    public static int[] solution(String str,char t) {
        // 왼쪽의 e로부터 거리를 구함
        // 오른쪽의 e로부터 거리를 구함
        // 최솟값으로 정리
        int[] answer = new int[str.length()];
        int p = 1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            }
            else{
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(p,answer[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        str1_10v2 main = new str1_10v2();
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 단어를 문자열로 입력 받음
        String str = scanner.next();

        // 두 번째 단어의 첫 번째 문자를 입력 받음 (문자 하나 받음)
        char t = scanner.next().charAt(0);
        for (int i : main.solution(str,t)) {
            System.out.print(i+" ");
        }
    }
}
