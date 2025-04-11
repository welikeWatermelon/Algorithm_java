    import java.util.ArrayDeque;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Scanner;

    public class Main {
        public static int N, M, startX, startY;
        public static int[][] arr;
        public static int[][] answer;
        public static int[] dx = {-1, 1, 0, 0};
        public static int[] dy = {0, 0, -1, 1};
        public static boolean[][] checked;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N][M];
            answer = new int[N][M];
            checked = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] == 2) {
                        startX = i;
                        startY = j;
                        checked[i][j] = true;
                    }
                }
            }
    //        DFS(startX, startY, 0);
            BFS(startX, startY);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    //갈 수 있지만 방문안한곳
                    if (!checked[i][j] && arr[i][j]!=0) {
                        if (j == M - 1) {
                            System.out.println(-1);
                            continue;
                        }
                        System.out.print(-1+" ");
                    } else if (!checked[i][j] && arr[i][j]==0) {
                        if (j == M - 1) {
                            System.out.println(0);
                            continue;
                        }
                        System.out.print(0+" ");
                    } else{
                        if (j == M - 1) {
                            System.out.println(answer[i][j]);
                            continue;
                        }
                        System.out.print(answer[i][j] + " ");
                    }
                }
            }
        }

        public static void BFS(int x, int y) {
            Queue<int[]> q = new ArrayDeque<>(); //LinkedList보다 효율적
            q.add(new int[]{x, y, 0});
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int nowX = now[0];
                int nowY = now[1];
                int nowCnt = now[2];
                answer[nowX][nowY] = nowCnt;
                for (int i = 0; i < 4; i++) {
                    int nx = nowX + dx[i];
                    int ny = nowY + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1 && !checked[nx][ny]) {
                        checked[nx][ny] = true;
                        q.add(new int[]{nx, ny, nowCnt + 1});
                    }
                }

            }
        }

    //    // 이렇게 하면 순차대로 가게되니, 최소거리가 아님
    //    public static void DFS(int x, int y, int cnt) {
    //        for (int i = 0; i < 4; i++) {
    //            int nx = x + dx[i];
    //            int ny = y + dy[i];
    //            if (nx >= 0 && ny >= 0 && ny < M && nx < N && !checked[nx][ny] && arr[nx][ny] == 1) {
    //                checked[nx][ny]=true;
    //                answer[nx][ny] = cnt+1;
    //                DFS(nx, ny, cnt + 1);
    //            }
    //        }
    //    }
    }


    // 0은 갈 수 없는 땅이고 - 원래 갈 수 없는 땅인 위치는 0을 출력하고
    // 1은 갈 수 있는 땅, - 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.
    // 2는 목표지점이다.
    //
    // 입력에서 2는 단 한개이다.