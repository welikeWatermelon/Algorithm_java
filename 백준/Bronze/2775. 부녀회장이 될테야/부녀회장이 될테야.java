import java.util.Scanner;

public class Main {
    public static int[][] arr = new int[15][15];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수
        for (int t = 0; t < T; t++) {
            int k = sc.nextInt(); // 층
            int n = sc.nextInt(); // 호
            System.out.println(getPeople(k, n));
        }
    }

    public static int getPeople(int k, int n) {
        if (arr[k][n] != 0) return arr[k][n];

        if (k == 0) return arr[k][n] = n;
        if (n == 1) return arr[k][n] = 1;

        return arr[k][n] = getPeople(k, n - 1) + getPeople(k - 1, n);
    }
}
