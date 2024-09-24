package src.string;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class str1_11v2 {
    public static String solution(String str) {
        String answer = "";
        // 빈 문자 +
        str = str + " ";
        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                answer += str.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);

                } cnt=1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        str1_11v2 main = new str1_11v2();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(main.solution(str));
    }
}
