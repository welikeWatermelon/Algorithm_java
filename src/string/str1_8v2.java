package src.string;

import java.util.Scanner;

public class str1_8v2 {
    public static String solution(String str) {
        String answer = "NO";
        //^ : 부정, [A-Z]: A부터 Z까지 ->
        //([^A-Z],"") : A부터 Z까지 아니면 빈문자로 !
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) {
            answer = "YES";
        }

        return answer;
    }


    public static void main(String[] args) {
        str1_8v2 main = new str1_8v2();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(main.solution(str));
    }
}
