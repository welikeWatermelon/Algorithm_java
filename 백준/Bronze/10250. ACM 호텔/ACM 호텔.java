import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int[][] arr = new int[H][W];
            int cnt = 0;
            int answerH=0;
            int answerW=0;
            for (int i = 0; i < W; i++) {
                for (int j = 0; j < H; j++) {
                    cnt++;
                    if (cnt == N) {
                        answerH = j+1; // 층
                        answerW = i+1; // 호실
                    }
                }
            }
            String answer="";
            answer += String.valueOf(answerH);
            if (answerW < 10) {
                answer += "0";
                answer += String.valueOf(answerW);
            } else {
                answer += String.valueOf(answerW);
            }
            System.out.println(answer);
        }

    }
}
