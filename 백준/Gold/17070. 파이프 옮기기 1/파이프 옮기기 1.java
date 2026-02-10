import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int N;
    public static int[][] arr;
    public static boolean[][] checked;
    public static int cnt;

    public static void main(String[] args) {
        // 1. 가로인지 세로은지 대각인지 확인하는 것 ((끝위치)r,c,state(1=가로,2=세로,3=대각))
        // 2. 끝 점이 어떻게 이동하는지
        // 2-1. 가로로 놓여 있다면
        // 2-1-1. 계속 가로로 하고 (0,+1,1), 오른쪽으로 한 칸 이동할지
        // 2-1-2. 대각으로 이동 (+1,+1,3), 오른쪽 한칸, 아래로 한 칸, 대각으로 변경

        // 2-2 세로로 놓여 있다면
        // 2-2-1. 계속 세로로 가고 (+1, 0, 2), 아래로 한 칸 이동
        // 2-2-2. 대각으로 이동 (+1, +1, 3), 오른쪽 한 칸 아래로 한 칸, 대각으로 변경

        // 2-3
        // 2-3-1. 오른쪽 한 칸 이동 (0, +1, 1), 가로로 변경
        // 2-3-2. 아래로 한 칸 이동 (+1, 0, 2), 세로로 변경
        // 2-3-3. 대각으로 이동 (+1, +1, 3), 오른쪽 한 칸, 아래로 한 칸, 대각 그대로

        // 시작점은 (1,1,1) -> (N,N,?)로 갈 때까지 몇 가지 방법이 있나 알아야함

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        recursion(0, 1, 1);
        System.out.println(cnt);

    }

    public static void recursion(int endX, int endY, int direction) {
            if (endX == N - 1 && endY == N - 1) {
                cnt++;
            }

            if (direction == 1) { // 가로
                if (endY + 1 < N && arr[endX][endY+1]!=1) {
                    recursion(endX, endY + 1, 1);
                }

                if (endX + 1 < N && endY + 1 < N && arr[endX][endY+1]!=1 && arr[endX+1][endY+1]!=1 && arr[endX+1][endY]!=1) {
                    recursion(endX+1, endY + 1, 3);
                }

            } else if (direction == 2) { // 세로
                if (endX + 1 < N && arr[endX+1][endY]!=1) {
                    recursion(endX+1, endY, 2);
                }

                if (endX + 1 < N && endY + 1 < N && arr[endX+1][endY]!=1 && arr[endX+1][endY+1]!=1 && arr[endX][endY+1]!=1) {
                    recursion(endX+1, endY+1, 3);
                }
            } else { // 대각
                if (endY + 1 < N && endX + 1 < N && arr[endX+1][endY+1] != 1 && arr[endX+1][endY] != 1 && arr[endX][endY+1]!=1) {
                    recursion(endX+1, endY+1, 3);
                }

                if (endY + 1 < N && arr[endX][endY+1]!=1 ) {
                    recursion(endX, endY+1, 1);
                }

                if (endX + 1 < N && arr[endX+1][endY]!=1) {
                    recursion(endX + 1, endY, 2);
                }
            }
        }
    }
