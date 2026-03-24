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

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(findMinLoad(N, M, map));
        // BFS
        // 전의 상태를 가져와서 다음에 넘겨야함
        // 만약 벽을 깼다면 1, 안깬 상태라면 0
        // 이 때, 벽을 깬 경우는 그대로 넘기고, 꺠지 않은 경우라면 분기처리 해줘야함
        //      벽을 만났을 때, 깰 것인가 그냥 둘 것인가
        // 이 과정만 해주면 됨
        // ArrayDeque를 사용해줄것
        // visited 처리를 해줄 것 (원본 데이터는 바뀌면 안됨. 그리고 처음 도착한게 최소 일 것이기 때문에 나중에 바꿀 걱정 X - DFS는 이걸 조심해줘야함)
    }

    public static int findMinLoad(int N, int M, int[][] map) {
        Queue<int[]> moveList = new ArrayDeque<>();
        moveList.add(new int[]{0, 0, 0, 1});
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        while (!moveList.isEmpty()) {
            int[] nowPlace = moveList.poll();
            int x = nowPlace[0];
            int y = nowPlace[1];
            int crack = nowPlace[2];
            int dist = nowPlace[3];

            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (crack == 1) {
                    // 벽을 꺤 상태고, 벽이 없는 곳만 다님
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny][1] && map[nx][ny] == 0) {
                        moveList.add(new int[]{nx, ny, 1, dist + 1});
                        visited[nx][ny][1] = true;
                    }
                } else { // 벽돌을 안 깬 상태고, 아무곳이나 갈 수 있음
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny][0]) {
                        // 벽 없는 곳
                        if (map[nx][ny] == 0) {
                            moveList.add(new int[]{nx, ny, 0, dist + 1});
                            visited[nx][ny][0] = true;
                        } else { // 벽 있는 곳 (뚫는 거)
                            moveList.add(new int[]{nx, ny, 1, dist + 1});
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
