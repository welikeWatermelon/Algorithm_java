import java.util.Scanner;

public class Main {
    public static int N, cnt;
    public static int[][] chessBoard;
    public static int[] chessBoardMin;
    public static boolean[] diag1;
    public static boolean[] diag2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chessBoard = new int[N][N];
        chessBoardMin = new int[N+1];
        diag1 = new boolean[N + N + 1];
        diag2 = new boolean[N + N + 1];

        cnt = 0;

        dfs(1);
        System.out.println(cnt);

    }

    public static void dfs(int depth){
        if (depth == N + 1) {
            cnt++;
            return;
        }

        for (int j = 1; j <= N; j++) {
            if (diag1[depth + j] || diag2[depth - j + N]) { // 대각 검사
                continue; // 걸리면 다음으로
            }

            boolean flag = false;
            for (int k = 1; k < depth; k++) { // 세로 검사
                if (chessBoardMin[k] == j) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                chessBoardMin[depth] = j;
                diag1[depth+j] = true;
                diag2[depth-j+N] = true;
                dfs(depth + 1);
                diag1[depth+j] = false;
                diag2[depth - j + N] = false;
            }
        }
    }

//    public static void bfs(){
//
//    }
}


// N-Queen 문제
// N x N 에서 N개의 퀸을 서로 공격하지 않고 놓을 수 있는 경우의 수 구하기
// 걍 매 단계마다 검사하고 지나가는게 좋을 듯?
// 그럼 BFS가 나을듯? DFS도 가능하네
// 둘 다로 풀어보자
// 근데 BFS는 메모리 초과 날 수 이씅ㅁ -> 이거 판단해봐야함
// 위에서부터 차례대로 놓을거임
// 그럼 위를 보고 놓을 수 있는지 판단해야겠찌?
// 대각이 문제임
// 대각은 놓을 때 아래를 checked로 해놓자
// 그리고 놓을 땐 checked와 위의 애들만 확인하는 거로, 즉 위에 있으면 안되는거지

// 1차원 대각 판단하는 법
// 1. 행 + 열 을 더했을 때 같으면 안됨
// 2. (|r1-r2| == |c1-c2| 면 같은 기울기에 있는거 (기울기 1))

//