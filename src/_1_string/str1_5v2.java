package src._1_string;

import java.util.Scanner;

public class str1_5v2 {
    public static String solution(String str) {
        // 영어 문자를 저장할 StringBuilder
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            while (!Character.isLetter(s[lt])) {
                lt++;
            }

            while (!Character.isLetter(s[rt])) {
                rt--;
            }

            char tmp = s[lt];
            s[lt] = s[rt];
            s[rt] = tmp;
            rt--;
            lt++;
        }

        String a = new String(s);
        return a;
    }

    public static void main(String[] args) {
        str1_5v2 main = new str1_5v2();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(main.solution(str));
    }
}
