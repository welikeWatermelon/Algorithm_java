package src.string;

import java.util.Scanner;

public class str1_6 {
    public static String solution(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        // stringBuilder를 첫 문자부터 끝문자까지 반복시킬건데
        // 매 순간 문자 검사를 할거임
        // 앞에서부터 하나씩 검사할때, 해당 문자의 개수가 2개 이상이라면
        // 해당 문자를 제외한 뒤에 있는 인덱스를 구해서 삭제시킴(뒤에꺼부터 지워야함 순서가 바뀌니까)
        // 해당 문자를 제거할 때는 배열로 받아야 하나
        // 위의 과정을 문자열의 마지막까지 반복해야함
        return "hi";
    }

    public static void main(String[] args) {
        str1_6 main = new str1_6();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(main.solution(str));
    }
}
