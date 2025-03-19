import java.util.Scanner;

public class Main {
    public static int N;
    public static int[][] arr;
    public static boolean[][] checked;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //이 코드로 mxcnt 구할 수 있음
        int mx = Integer.MIN_VALUE;
        for(int height = 0; height<=100; height++){
            int cnt = 0;
            checked = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!checked[i][j] && arr[i][j] > height) { //방문안했고, 빗물보다 높은 경우
                        checked[i][j] = true; //방문
                        cnt += 1;
                        DFS(i, j, height);
                    }
                }
            }
            mx = Math.max(mx, cnt);
        }

        System.out.println(mx);
    }


    // DFS는 그냥 탐색하고 true로 바꿔주는 역할만 갖도록 하는게 좋을 듯
    // for문으로 위치를 계속 탐색하며, false와 height보다 높은 값을 만날 때를 찾아 DFS 함수를 호출해주자

    // cnt 반환
    public static void DFS(int x, int y, int height) {
        //기저 조건 -> 다시 써야함
        // 기저조건이 필요 없을것 같은데? 어차피 실행 안되면 상관 없으니까

        for (int s = 0; s < 4; s++) {
            int nx = x + dx[s];
            int ny = y + dy[s];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !checked[nx][ny] && arr[nx][ny]>height) {
                checked[nx][ny] = true; //이렇게하면 가운데에 들어갔을 때, 다 탐색하기도 하네 문제 없겠다
                DFS(nx, ny, height);
            }
        }
    }
}

// max 값을 찾아서 1부터 max-1 까지 비의 양을 조절해야함 : height
//
//
// height에 따른 안전구역을 구해야함
// height보다 작은 구역은 0으로 초기화 -> 굳이 그럴 필요 없다 작거나 같은 것만 보면 되니까
// 0이 아닌 구역을 찾으면 그 다음 부터 DFS
// DFS가 한타임 끝나면 cnt += 1
// 마지막 까지 탐색한 후 cnt를 cntArr에 추가 (cntArr의 배열값은 max)

// cntArr에서 max값 출력
