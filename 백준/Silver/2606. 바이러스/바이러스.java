import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static boolean[] checked;
    public static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N + 1][N + 1];
        checked = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            arr[first][second] = 1;
            arr[second][first] = 1;
        }

        checked[1] = true;
        System.out.println(DFS(1, 0));
    }

    public static int DFS(int idx,int cnt) {
        int tmparr[] = arr[idx];
        for (int i = 1; i < N + 1; i++) {
            if (tmparr[i] == 1 && !checked[i]) {
                checked[i] = true;
                cnt = DFS(i, cnt + 1);
            }
        }

        return cnt;
    }
}
