import java.util.Scanner;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        dfs(1, 0);
        System.out.print(sb);
    }

    public static void dfs(int start, int depth) {
if (depth == M) {
    for (int i = 0; i < M; i++) {
        sb.append(arr[i]);
        if (i < M - 1) { // 마지막 원소가 아닐 때만 공백 추가
            sb.append(" ");
        }
    }
    sb.append("\n");
    return;
}

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
