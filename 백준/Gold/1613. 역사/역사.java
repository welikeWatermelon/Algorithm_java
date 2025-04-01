import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
        }

        for (int t = 1; t <= n; t++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][t] != 0 && graph[t][j] != 0) {
                        graph[i][j]=1;
                    }
                }
            }
        }

        int findSet = sc.nextInt();
        for (int i = 0; i < findSet; i++) {
            int before = sc.nextInt();
            int after = sc.nextInt();
            if (graph[before][after] == 0) {
                if (graph[after][before] != 0) {
                    System.out.println(1);
                } else if (graph[after][before] == 0) {
                    System.out.println(0);
                }
            } else {
                System.out.println(-1);
            }
        }

    }
}
