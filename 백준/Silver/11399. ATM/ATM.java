import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 오름차순 정렬 (그리디의 핵심: 가장 적게 걸리는 사람을 앞으로)
        Arrays.sort(times);

        int totalSum = 0;  // 전체 합계
        int currentSum = 0; // 각 사람이 기다리는 시간의 누적합

        for (int i = 0; i < N; i++) {
            currentSum += times[i]; // i번째 사람까지 걸린 시간
            totalSum += currentSum;  // 모든 사람이 기다린 시간의 총합에 누적
        }

        System.out.println(totalSum);
    }
}