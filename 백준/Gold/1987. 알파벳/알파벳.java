import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N, M, mx;
    public static char[][] arr;
    public static boolean[][] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        checked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        checked[0][0] = true;
        ArrayList<Character> countArr = new ArrayList<>();
        countArr.add(arr[0][0]);

        DFS(0, 0, countArr, 1);
        System.out.println(mx);
        // 다음 칸으로 움직일 때,
        // 1. 없는 알파벳이라면 배열에 넣어줌
        // 2. 있는 알파벳이라면 return -> 다른방향으로 감
        // 2-1. 주변에 탐색을 다 했으면 mx 갱신해줘야함

    }


    public static void DFS(int x, int y, ArrayList<Character> countArr,int cnt) {


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<M && !checked[nx][ny] &&
                    !countArr.contains(arr[nx][ny])){
                checked[nx][ny] = true;
                countArr.add(arr[nx][ny]);
                DFS(nx, ny, countArr, cnt+1);
                checked[nx][ny] = false;
                remove(countArr, arr[nx][ny]);
            }

            if (mx < cnt) {
                mx = cnt;
            }
        }
    }

    public static void remove(ArrayList<Character> countArr, char s) {
        for (int i = countArr.size() - 1; i >= 0; i++) {
            if (countArr.get(i) == s) {
                countArr.remove(i);
                break;
            }
        }
    }
}


// (0,0)에 말이 놓여있음
// 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
// 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
// 말이 최대한 몇 칸 지날 수 있는지..
