import java.util.Scanner;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0, 0);
        if (M == 0) {
            cnt--;
        }
        System.out.println(cnt);

    }

    public static void DFS(int depth, int sum) {
        if (depth == N) {
            if (sum == M) {
                cnt++;
                return;
            }
            return;
        }
        // 
        DFS(depth + 1, sum + arr[depth]);
        DFS(depth + 1, sum);
    }
}
