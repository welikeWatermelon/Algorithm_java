import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static boolean[][] checkedBlank;
    public static int N,M, cnt;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 열
        M = sc.nextInt(); // 행
        cnt = 0;
        arr = new int[N][M];
        checkedBlank = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();

            }
        }
        // 가운데 빈 공간 찾아주기 -> 최초 한번만 진행
        int howMany=0;

        // 여기서 치즈 자리수랑 만약에 모두 0이 되면 flag로 해줘야함
        // isZero : 모두 자리가 0인지 확인
        while (!isZero()) {
            boolean[][] checkedBlank = new boolean[N][M];
            // 외부 공기 반영
            findBlank(checkedBlank);
            cnt++;

            // 가장자리 발견후 제거
            howMany = findEdge();

            // -1 -> 0
            minusToZero();
        }
        System.out.println(cnt);
        System.out.println(howMany);
    }



    // 0. 안쪽의 공백을 찾는 코드를 짜야함 -> 공백을 -1로 바꿔줌
//    -> 맨처음에 1위치에 checkedBlank[][] 를 true로 바꿔줘
//    -> 그 다음, 행으로 검사를 진행하며 0열 부터 시작하여 arr[i][j]가 1이 나올때까지 모두 true로 바꿔줘
//          즉, 1이 나오면 그때까지 반복문을 반복해야함 (break)
//    -> 그 다음, 행으로 검사를 진행하며 M-1열 부터 시작하여 arr[i][j]가 1이 나올때까지 모두 true로 바꿔줘
//    -> 그 다음, 열으로 검사를 진행하며 0행 부터 시작하여 arr[i][j]가 1이 나올때까지 모두 true로 바꿔줘
//    -> 그 다음, 열으로 검사를 진행하며 N-1열 부터 시작하여 arr[i][j]가 1이 나올때까지 모두 true로 바꿔줘
//    -> 그러면 가장 안쪽을 제외한 나머지가 모두 true로 바뀔것임
//    -> false인 것들을 -1로 바꿔줘

    // 가운데 빈 공간 찾아주기
    // 최대 10,000 이니까 상관 없는 시간복잡도임
    // 내부공기 -1로 마킹
    public static void findBlank(boolean[][] checkedBlank) {
        // 외부공기 BFS
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        checkedBlank[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !checkedBlank[nx][ny]) {
                    if (arr[nx][ny] == 0) {
                        checkedBlank[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // 내부공기 마킹
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!checkedBlank[i][j] && arr[i][j] == 0) {
                    arr[i][j] = -1;
                }
            }
        }
    }


    // 가장자리 제거해주기
    // 시간복잡도 40,000 이니까 노상관
    // 2 -> 0
    public static int findEdge(){
        int howMany=0;

        // 바깥쪽 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    for (int s = 0; s < 4; s++) {
                        int nx = i + dx[s];
                        int ny = j + dy[s];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1) {
                            arr[nx][ny] = 2;
                            howMany ++;
                        }
                    }
                }
            }
        }

        // 모두 0으로 바꿔주기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                }
            }
        }
        return howMany;
    }

    // -1 -> 0
    public static void minusToZero() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == -1) {
                    arr[nx][ny] = 0;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // -1 -> 0 (DFS)
//    public static void DFS(int x, int y) {
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == -1) {
//                arr[nx][ny] = 0;
//                DFS(nx, ny);
//            }
//        }
//    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == -1) {
                    arr[nx][ny] = 0;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static boolean isZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}


//
// 1. 가장 바깥의 치즈를 판단하는 코드를 짜야함 -> 그 바깥의 치즈를 제거
//    -> 0이면 주변에 붙어있는 1을 모두 2로 바꿔줘 (바로 인접한것들만) (그냥 반복문)
//    -> 2인 치즈를 모두 제거
//
// 2. 바깥쪽 치즐를 제거하고 -1이 0을 만났다면, -1을 0으로 바꿔줌 (붙어있는거 연속해서 모두)
//    -> -1 주변에 0이 있다면 그 부분을 시작으로 계속해서 -1을 0으로 바꿔주는것 ! (DFS,BFS)



// 2를 찾아 제거(0으로 바꿔줌) -> cnt ++
// -1이 0을 만났다면 0으로 연속해서 바꿔줌
// 그다음 2찾기
// -1이 0을 만났다면 0으로 연속해서 바꿔줌
// 위의 과정 반복