package src.string;

import java.util.Scanner;

public class str1_6 {
    public static String solution(String str) {
        // stringBuilder를 첫 문자부터 끝문자까지 반복시킬건데
        // 매 순간 문자 검사를 할거임
        // 앞에서부터 하나씩 검사할때, 해당 문자의 개수가 2개 이상이라면
        // 해당 문자를 제외한 뒤에 있는 인덱스를 구해서 삭제시킴(뒤에꺼부터 지워야함 순서가 바뀌니까)
        // 해당 문자를 제거할 때는 배열로 받아야 하나
        // 위의 과정을 문자열의 마지막까지 반복해야함
        // -------------------------------------위의 과정은 너무 복잡
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            //str.charAt(i)) : str에서 i번째 있는 문자가 뭐니
            //str.indexOf(S) : S의 문자가 처음으로 나오는건 몇번째 위치에 있니
            //str.indexOf(str.charAt(i)) == i : 문자가 처음 나오는 경우! (문자가 처음 나오는 경우와 해당 순서가 동일할 때)
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        str1_6 main = new str1_6();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(main.solution(str));
    }
}
