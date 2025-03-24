package s_0324;

import java.util.Scanner;

public class swea_4875_강사님 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine().trim());
        for (int t = 1; t <= T; t++) {
            // 입력
            // 미로의 한 변의 길이 N
            int N = Integer.parseInt(sc.nextLine().trim());

            // 미로의 정보 NxN
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String temp = sc.nextLine().trim();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = temp.charAt(j) - '0';
                }
            }

            // 로직
            // 재귀함수를 통해서 미로를 시작점 -> 출발점으로 도착을 할 수 있는 경로가 있는지 없는지 탐색
            isArrive = false; // 도착할 수 있는지 유무
            visited = new boolean[N][N]; // 델타 탐색 (방문 체크 배열)

            // 재귀 함수를 통해 미로를 탐색 진행해준다.
            // 내가 탐색할 미로의 한변의 길이 N 정보 arr
            // 현재 나의 좌표 위치 (x,y)
            // 마지막 도착 지점 (ex, ey)
            // 현재 내가 얼마나 재귀를 진행했는가 (depth -> 지금은 필요없음)
            // 출력

            int result = 0;
            if (isArrive) {
                result = 1;
            }
        }

    }

    static boolean isArrive; // 도착할 수 있는지 유무
    static int[] dx = {0, 0, -1, 1}; // 동서남북 델타배열
    static int[] dy = {-1, 1, 0, 0};

    static boolean[][] visited;
}
