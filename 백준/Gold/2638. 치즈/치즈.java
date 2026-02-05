import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int[][] arr;
    public static int N, M;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visited;

    public static void main(String[] args) {
        // 1. 치즈 내부 공간 찾아서 표시하기 (bfs)
        // 2. 치즈가 외부 공간과 2개 이상 닿아있는 곳들을 체크하여 삭제 cnt++
        // 3. 1번과정과 2번과정의 반복 하며 치즈가 몇개남았는지 체크한다
        // 4. 치즈가 안남았으면 cnt 출력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+2][M+2];

        // 가장자리 세팅
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N+2; i++) {
            if (i == 0 || i == N + 1) {
                for (int j = 0; j < M + 2; j++) {
                    arr[i][j] = 2;
                }
            } else {
                arr[i][0] = 2;
                arr[i][M+1] = 2;
            }
        }
        int cnt = 0;

        while (true) {
//            visited = new boolean[N + 2][M + 2];
            bfsFindExternalAir();

            // 아래 과정이 계속 반복됨
            // 치즈가 남아있는지 검증
            boolean isCheeseThere = true;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (arr[i][j] == 1) {
                        isCheeseThere = false;
                    }
                }
            }

            // 치즈가 없다면 반복 끝
            if (isCheeseThere) {
                System.out.println(cnt);
                return;
            }

            // 바깥쪽 공간 2로 만들기
//            for (int i = 0; i < N+2; i++) {
//                for (int j = 0; j < M+2; j++) {
//                    if (arr[i][j] == 2 && !visited[i][j]) {
//                        findSpace(i, j);
////                        bfsFindExternalAir();
//                    }
//                }
//            }

            // 사라질 치즈 찾기
            ArrayList<int[]> deleteList = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (arr[i][j] == 1) {
                        boolean flag = checkDelete(i, j);
                        if (flag) {
                            deleteList.add(new int[]{i, j});
                        }
                    }
                }
            }

            // 치즈 삭제
            for (int[] nowPlace : deleteList) {
                arr[nowPlace[0]][nowPlace[1]] = 0;
            }

            cnt++;
        }
    }

    // 가장자리 공간은 2로, 안쪽 공간은 0으로
    // 어떻게 공간을 찾지?
    // 계속 가다가 끝점을 만나면 ( (x,0) (0,y) (x,M-1), (N-1,y) ) 지금까지 들렸던 곳 visited로 처리하고,
    // 열린 곳은 visited 해주는 것
    public static void findSpace(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx>=0 && ny>=0 && nx<N+2 && ny<M+2 && arr[nx][ny] == 0 ) {
                arr[nx][ny] = 2;
                visited[nx][ny] = true;
                findSpace(nx, ny);
            }

        }
    }

    public static void bfsFindExternalAir() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N + 2][M + 2];

        // (0,0)은 무조건 외부 공기
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        arr[0][0] = 2;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < N + 2 && ny >= 0 && ny < M + 2) {
                    // 치즈(1)가 아니고, 아직 방문 안 한 공기라면 외부 공기(2)로 전환
                    if (!visited[nx][ny] && arr[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        arr[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    // 1. 지울 곳들을 찾기 -> 빈 공간과 인접한 곳이 2개 이상인 것
    // -> 인접한 곳(0)이 두개 이상 인 것
    // 2. 한꺼번에 모두 지우기
    // 3. 빈 공간(전에 2)을 다시 0으로 바꿔주기
    public static boolean checkDelete(int x, int y){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx <= N+1 && ny <= M+1) {
                if (arr[nx][ny] == 2) {
                    cnt++;
                    if(cnt==2)
                        break;
                }
            }
        }

        return cnt == 2;
    }
}
