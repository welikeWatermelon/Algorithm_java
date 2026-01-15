import java.util.Scanner;

public class Main {

    public static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            answer = 0;
            int n = sc.nextInt();
            findPlus(n, 0);
            System.out.println(answer);
        }
    }

    public static void findPlus(int n, int num) {

        // 기저조건
        if (n < num) {
            return;
        }

        if (n == num) {
            answer++;
        }

        findPlus(n, num + 3);
        findPlus(n, num + 2);
        findPlus(n, num + 1);
    }
}
