import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    public static class answers implements Comparable<answers>{
        int time;
        int distance;

        answers(int time, int distance){
            this.time = time;
            this.distance = distance;
        }

        @Override
        public int compareTo(answers o) {
            if (this.time != o.time) {
                return Integer.compare(this.time, o.time);
            }
            return Integer.compare(o.distance, this.distance);
        }
    }

    public static int time;
    public static int H;
    public static int L;
    public static int N;
    public static int M;
    public static int B;
    public static boolean flag = false;
    public static int[][] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // 깎는데는 2초
        // 쌓는데는 1초


        int max = Integer.MIN_VALUE;
        int MinTime = Integer.MAX_VALUE;
        PriorityQueue<answers> answerCandidate = new PriorityQueue<>();

        ground = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if(ground[i][j]>max) max = ground[i][j];
            }
        }

        for (int standard = max; standard >= 0; standard--) {
            H = 0;
            L = 0;
            time = 0;
            flag = true;
            int nowTime = construction(standard);
            if (flag) {
                if(nowTime<=MinTime) answerCandidate.add(new answers(nowTime,standard));
            }
        }

        answers answer = answerCandidate.poll();
        System.out.println(answer.time + " " + answer.distance);



        // 기준점을 잡고, 그 기준점보다 높은 점들을 H, 낮은 점들을 L 라고 하자
        // 이 떄, (기준점) - (각 점)들 해서 (-)가 나온다면 time에 (+2) 해주고, (+)가 나온다면 time에 (+1) 해줌
        // 이렇게 모든 기준점들을 돌며 과정 진행
        // 이럴경우 경우의수 : 500 x 500 x 256.
        // 근데 여기서 고려해야 할 건 갖고있는 블록의 수
        // 이게 무한정이라면 문제가 없겠지만, 기준점을 바탕으로 L에 들어있는 블록의 필요 개수가 B보다 많다면 해당 기준점 위로는 안가야함
        // 땅이 제일 높은 것부터 해야하니까 기준점은 최고로 하면 될 듯

        // 아 최소시간을 구하는게 먼저네
        // 그리고 깎은건 다시 넣어줌
    }

    public static int construction(int standard){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int calculation = standard - ground[i][j];
                if (calculation > 0) { // 쌓아야함
                    L+= calculation;
                    time+=calculation;
                } else if(calculation < 0){
                    H-=calculation;
                    time+=-2*calculation;
                }
            }
        }
        if (B+H < L) {
            flag = false;
        } // 여기 넘어가면 블록은 여유로운 상황
        return time;
    }
}
