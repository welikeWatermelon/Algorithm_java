import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int N,K,cnt;
    public static boolean[] checked = new boolean[200001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        cnt = 0;
        System.out.println(BFS(N,0));
    }

    public static int BFS(int step, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{step,cnt});
        while (!q.isEmpty()) {
            int[] x = q.poll();
            if (x[0] == K) {
                return x[1];
            }

            if (x[0] * 2 <= 200000 && !checked[x[0] * 2]) {
                q.add(new int[]{x[0] * 2, x[1] + 1});
                checked[x[0] * 2] = true;
            }

            if ((x[0] - 1 >= 0 && !checked[x[0] - 1])) {
                q.add(new int[]{x[0] - 1, x[1] + 1});
                checked[x[0]-1] = true;
            }

            if (x[0] + 1 <= 200000 && !checked[x[0] + 1]) {
                q.add(new int[]{x[0] + 1, x[1] + 1});
                checked[x[0]+1] = true;
            }

        }



        return 0;
    }
}
