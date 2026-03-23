// 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은
// 익은 토마토의 영향을 받아 익게 된다.
// 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토

// <입력>
// 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.
// M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수
// 2 ≤ M,N ≤ 1,000
// 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
// 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
// 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
// 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
// 토마토가 하나 이상 있는 경우만 입력으로 주어진다.

// <출력>
// 토마토가 모두 익을 때까지의 최소 날짜를 출력해야함
// 저장될 때부터 모든 토마토가 익어있다면 0
// 토마도가 모두 익지 못하는 상황이면 -1

// <제한 사항>
// 1초 -> 10^8
// 1000 -> 10^3
// n^2 까지 가능함

// <전략>
// 익은 토마토들의 위치를 찾는다 1
// 익은 토마토들의 위치를 바탕으로 주변에 안 익은 토마토(0)이 있으면 1로 바꾼다
//      - 해당 과정은 BFS를 바탕으로 한다
//          - 익은 토마토들을 바탕으로 하나씩 주변을 익혀가야 하므로 너비탐색
//          - 익은 토마토들은 Queue에 계속 넣는다.
//              - int[3] 으로 Queue에 넣어준다. x,y,day 식으로
//              - 처음에 넣는 애들은 day = 0으로 해준다.
//              - 만약 모든 데이터가 1인지는 미리 검사를 해서 이 과정을 모두 건너뛴다
//          - 기존 큐에 있던 애들 상태를 day 라고 한다면 - A
//          - A로 인해 들어가는 애들은 day+1 로 저장해주며 상태를 1로 바꿔준 뒤 큐에 넣는다.
//          - PriorityQueue를 사용하며 일수가 낮은것부터 해결해가고 큐가 비었을 떄의 값을 구한다.
//              - 근데 PriorityQueue로 해야하나? ArrayDeque로 하면 안되나?
//              - 굳이 PriorityQueue로 안해도 되네.
//              - 그럼 둘 중에 왜 ArrayDeque가 더 성능이 좋나?
//              - 이건 공부해야함
//          - 총 데이터를 탐색하며 아직 0인 토마토가 있다면 -1 반환
//          - 0이 없다면 큐가 비었을 떄의 값을 반환
//
//      - DFS로의 에러사항은 한곳만 먼저 쭉 갔을 때와 다른곳을 통해서 쭉 갔을 때
//          - 며칠만에 익었는지 차이가 난다. 만약 이렇다면 일수가 작은거로 업데이트 해줘야함
//          - 모든 데이터들을 다시 순회하며 일수 중 최대가 되는 값을 정답으로
//          - dfs를 통해서 한다면 메모리의 어떤 부하가 있고, 시간의 부하가 얼마나 있을지 모르겠음


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] appleBox = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                appleBox[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> changeApples = new ArrayDeque<>();
        // 이건 1만 있는걸 확인하기 위한 것
        // 1만 있다면 0으로 BFS 안돌리고 바로 출력해버리면 되니까
        // 근데 -1이 있는건 무시해야함 (얜 걍 벽임)
        // 그래서 0이 있다면 익어야할 사과가 있다는 것이고, 이제 답으로 0은 나올 수 없는 것
        // 즉, fullApples == false면 바뀔 사과가 있으니 -1 혹은 0이아닌 수가 나온다는 것
        boolean fullApples = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (appleBox[i][j] == 1) {
                    changeApples.add(new int[]{i, j, 0});
                } else if (appleBox[i][j] == 0) {
                    // 이 부분 수정했음
                    // 0을 명시 안해주면 -1을 만나더라도 false로 가서
                    fullApples = false;
                }
            }
        }

        // 출력
        // 모두 1인지 검사
        if (fullApples) {
            System.out.println(0);
            return;
        }

        // 다 익는데 최소 날짜
        System.out.println(BFS(changeApples, appleBox, N, M));
    }

    // 사과를 익히는 과정
    public static int BFS(Queue<int[]> oldApples, int[][] appleBox, int N, int M) {
        int finalDay = 0;

        while (!oldApples.isEmpty()) {
            int[] nowApple = oldApples.poll();
            int x = nowApple[0];
            int y = nowApple[1];
            int day = nowApple[2];
            finalDay = day;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 아래에서 checked는 필요 없을 듯? 왜냐면 0인 곳만 방문하잖아
                // 그리고 PriorityQueue를 안해도 day가 낮은 순부터 들어가서 괜찮음
                // 위의 과정 확인 필요!
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && appleBox[nx][ny] == 0) {
                    oldApples.add(new int[]{nx, ny, day + 1});
                    appleBox[nx][ny] = 1;
                }
            }
        }

        // 안 익은 사과 판별
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 안익은 사과가 있다면 -1 출력
                if (appleBox[i][j] == 0) {
                    return -1;
                }
            }
        }

        return finalDay;
    }
}

// 보완점
// 종료 후 0 검사: BFS 종료 후 전체 배열을 다시 도는 것은
// $O(N \times M)$입니다.
// 이미 BFS 시작 전 안 익은 토마토의 총 개수(count)를 세어두고,
// 익힐 때마다 count--를 하면 마지막에 루프를 또 돌 필요가 없습니다.