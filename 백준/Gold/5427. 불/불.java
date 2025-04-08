import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static int N,M;
    public static char[][] arr;
    public static boolean[][] checked;
    public static boolean[][] checkedFire;
    public static int[] dx = {-1, 1,0,0};
    public static int[] dy = {0,0,-1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            M = sc.nextInt();
            N = sc.nextInt();
            sc.nextLine();
            int startX = 0;
            int startY = 0;
            arr = new char[N][M];
            checked = new boolean[N][M];
            checkedFire = new boolean[N][M];
            ArrayList<int[]> fire = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String tmp = sc.next();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = tmp.charAt(j);
                    if (arr[i][j] == '@') {
                        startX = i;
                        startY = j;
                    }

                    if (arr[i][j] == '*') {
                        fire.add(new int[]{i, j});
                    }
                }
            }
            int answer = BFS(startX, startY, fire);

            if (answer == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer);
            }

        }
    }

    public static int BFS(int startX, int startY,ArrayList<int[]> fire) {
        PriorityQueue<Order> pq = new PriorityQueue<>();
        Order start = new Order(startX, startY, arr[startX][startY], 0);
        pq.add(start);
        for (int[] c : fire) {
            pq.add(new Order(c[0], c[1], '*', 0));
            checkedFire[c[0]][c[1]] = true;
        }

        checked[startX][startY] = true;
        while (!pq.isEmpty()) {
            Order now = pq.poll();
            int cnt = now.cnt;
            char isFire = now.t;
            int x = now.x;
            int y = now.y;

            // 기저조건
            if (isFire=='@' && (x == N - 1 || y == M - 1 || x == 0 || y == 0)) {
                return cnt+1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !checkedFire[nx][ny] && isFire=='*' && arr[nx][ny]!='#') { // 불
                    checkedFire[nx][ny] = true;
                    arr[nx][ny] = '*';
                    pq.add(new Order(nx, ny, arr[nx][ny], cnt + 1));
                }

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !checked[nx][ny] && isFire == '@' && arr[nx][ny]!='*' && arr[nx][ny]!='#') { // 빈공간
                    checked[nx][ny] = true;
                    pq.add(new Order(nx, ny, isFire, cnt + 1));
                }
            }


        }
        return -1;
    }
}

class Order implements Comparable<Order> {
    int x;
    int y;
    char t;
    int cnt;

    Order(int x, int y, char t, int cnt) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Order o) {
        // 1. cnt가 작은 순서로 정렬
        if (this.cnt != o.cnt) {
            return Integer.compare(this.cnt, o.cnt);
        }

        // 2. cnt가 같다면, t가 '*'이면 우선순위 높음
        if (this.t == '*' && o.t != '*') {
            return -1; // 내가 먼저!!!
        } else if (this.t != '*' && o.t == '*') {
            return 1; // 상대가 먼저!!!
        }

        // 3. 그 외에는 같다고 간주
        return 0;
    }
}

// 사람이 이동할 때, 불이 따라오는 그런 코드에 대해 처리해줘야함
// 불이 먼저 들어가니까 문제인데, 이 코드 역시 필요해서 어떻게 처리할지가 문제임

// 따로 생각해서 하려고 하니 이것도 문제
// 시간이 오래지나 불 구역이 많으면 못나갈 수도 있음

// 한번 움직일 때마다(같은 cnt마다) 같은 불의 위치인 세계가 4개 동시에 존재해야함
// BFS에 들어오고 나오는 파라미터는 상근이의 위치와 시간이라고 하자
// 시간에 따라 불의 범위가 다르게 적용해줘야함
// 즉, cnt에 따라 불이 퍼지도록 ( cnt = 0 -> fire = 1 , cnt = 1 -> fire = 4 ) -> 요곳이 문제

// 전에 추가된 불의 위치를 저장 (처음엔 처음 불 위치를 저장 (cnt = 0) )
// 그 불의 위치에서 동서남북으로 불 더해줌 (cnt = 1 ... )
// 이때 추가된 불을 저장 (cnt = 1 ... )
// 반복