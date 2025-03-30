import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        // 체스판 입력
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        int mn = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cntW = 0;
                int cntB = 0;
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        char current = arr[i + x][j + y];
                        if ((x + y) % 2 == 0) {
                            if (current != 'W') cntW++;
                            if (current != 'B') cntB++;
                        } else {
                            if (current != 'B') cntW++;
                            if (current != 'W') cntB++;
                        }
                    }
                }
                mn = Math.min(mn,Math.min(cntW, cntB));
            }
        }

        System.out.println(mn);

    }
}
