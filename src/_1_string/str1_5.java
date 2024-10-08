package src._1_string;

import java.util.Scanner;

public class str1_5 {
    public static String solution(String str) {
        // 영어 문자를 저장할 StringBuilder
        StringBuilder letters = new StringBuilder();


        //영어만 추출
        //str.toCharArray() : str문자열의 각 문자를 char 타입의 배열로 변환
        for (char ch : str.toCharArray()) {
            //알파벳일 경우 true (Character.isLetter(ch))
            if (Character.isLetter(ch)) {
                letters.append(ch);
            }
        }

        //결과 문자열을 저장할 StringBuilder
        StringBuilder result = new StringBuilder(str);

        //역순으로 바꾼 영어 문자를 결과에 반영
        int letterIndex = letters.length() - 1; //마지막 인덱스부터 할거니까
        for (int i=0; i<str.length();i++) {
            // str에서 i번째가 문자라면
            if (Character.isLetter(str.charAt(i))) {
                //i번째 있는 애를, letters에서 (letterIndex)번째 있는 애로 바꿔줄거야
                //그리고 이 친구는 반복때마다 1을 빼줄거야
                result.setCharAt(i, letters.charAt(letterIndex--));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        str1_5 main = new str1_5();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(main.solution(str));
    }
}
