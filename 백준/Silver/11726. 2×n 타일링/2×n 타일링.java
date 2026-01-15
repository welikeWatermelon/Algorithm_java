import java.util.Scanner;

public class Main {

    public static long[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
        } else {
            answer = new long[n + 1];
            answer[0] = 0L;
            answer[1] = 1L;
            answer[2] = 2L;
            System.out.println(count(n));
        }
    }

    public static long count(int n) {
        if (answer[n] != 0) {
            return answer[n];
        } else {
            answer[n] = (count(n - 2) + count(n - 1))%10007;
            return answer[n];
        }
    }
}
