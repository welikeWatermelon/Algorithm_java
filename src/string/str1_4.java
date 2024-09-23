package string;

import java.util.Scanner;

public class str1_4 {
    public static String solution(String str) {
        String answer = "";
        for (int i = str.length()-1; i >= 0; i--) { // charAt에서 인덱스 범위 초가 가능성
            answer += str.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        str1_4 main = new str1_4();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비
        String[] str = new String[num];

        //문자열 입력 받기
        for (int i = 0; i < num; i++) {
            str[i] = scanner.nextLine();
        }

        //결과값 나오는 부분
        for (int i = 0; i < num; i++) {
            System.out.println(main.solution(str[i]));
        }
    }
}
