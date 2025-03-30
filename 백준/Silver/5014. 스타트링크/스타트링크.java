import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static boolean[] checked;
    public static int F,S,G,U, D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt(); // 총 층
        S = sc.nextInt(); // 현재 위치
        G = sc.nextInt(); // 스타트링크 위치
        U = sc.nextInt(); // 위로 U층 이동
        D = sc.nextInt(); // 아래로 D층 이동

        checked = new boolean[F + 1];
        int answer = BFS(S);
        if (answer != -1) {
            System.out.println(answer);
        } else {
            System.out.println("use the stairs");
        }

    }

    public static int BFS(int nowWhere) {
        int finalCnt= 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{nowWhere,0});
        while (!q.isEmpty()) {
            finalCnt++;
            int[] tmp = q.poll();
            int now = tmp[0];
            int cnt = tmp[1];

            if (now == G) {
                return cnt;
            }
            if (now + U <= F && !checked[now+U]) {
                checked[now+U] = true;
                q.add(new int[]{now + U, cnt + 1});
            }
            if (now - D >= 1 && !checked[now - D]) {
                checked[now - D] = true;
                q.add(new int[]{now - D, cnt + 1});
            }
        }
        return -1;
    }
}
