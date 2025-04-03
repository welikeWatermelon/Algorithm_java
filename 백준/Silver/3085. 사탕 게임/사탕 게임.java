import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        // i와 j를 체인지 (양옆, 위아래)
        // 양옆

        int mx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    char tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j+1] = tmp;
                    mx = Math.max(mx,findmx(arr));// 최대 출력하는 메서드 실행
                    tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j+1] = tmp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                if (arr[j][i] != arr[j+1][i]) {
                    char tmp = arr[j][i];
                    arr[j][i] = arr[j+1][i];
                    arr[j+1][i] = tmp;
                    // 최대 출력하는 메서드 실행
                    mx = Math.max(mx,findmx(arr));
                    tmp = arr[j][i];
                    arr[j][i] = arr[j+1][i];
                    arr[j+1][i] = tmp;
                }
            }
        }

        System.out.println(mx);
    }

    private static int findmx(char[][] arr) {
        int N = arr.length;
        int max = 1;

        // 가로 검사
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 세로 검사
        for (int j = 0; j < N; j++) {
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (arr[i][j] == arr[i - 1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }


}
//  상근이는 사탕의 색이 다른 인접한 두 칸을 고른다
