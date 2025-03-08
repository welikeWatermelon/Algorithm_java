package swea_0308;

import java.util.Queue;
import java.util.Scanner;

public class swea_2806_N_Queen {
    public static int N,cnt;
    public static int[] queen;
    public static boolean[] checked;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            queen = new int[N];
            checked = new boolean[N];

        }
    }

    public static void QueenNeverCry(int depth) {

        //전의 depth에서 대각선을 막는 코드 <1>
        if (0 < depth) {
            for (int i = 0; i < depth-1; i++) {
                if (Math.abs(queen[i] - queen[depth - 1]) == Math.abs(i - (depth - 1))) {
                    return;
                }
            }
        }
        //여기 오는 코드들은 모두 <1> 조건에도 안걸리고 같은 열에도 있지 않은 것들이 모여서
        //총 depth가 N까지 (depth는 0부터 시작이니 목표보다 하나 더 많을때임 종료조건) 왔다면
        //대각과 같은 열을 통과한 것이니 cnt++
        if (depth == N) {
            cnt++;
            return;
        }



        for (int i = 0; i < N; i++) {
            // 이 코드는 같은 열에 있는지를 검사하는거임
            if (!checked[i]) { //check -> i번 열에 안들어왔어
                queen[depth]=i; //depth 행, i열에 퀸 넣어줌
                checked[i] = true; //check에 i번 열 들어옴
                QueenNeverCry(depth + 1);
                checked[i] = false;

                // 근데 여기서 대각을 처리해준다면?
            }
        }
    }
}
