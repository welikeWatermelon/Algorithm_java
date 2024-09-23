package string;

import java.util.Scanner;

public class str1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        String s = scanner.nextLine().toLowerCase();
        char s1 = s.charAt(0);
        System.out.println(count(str, s1));
    }

    public static int count(String str, char ch) {
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                cnt++;
            }
        }
        return cnt;
    }
}
