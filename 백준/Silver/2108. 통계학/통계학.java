import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[8001]; // -4000 ~ 4000
        double sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            count[arr[i] + 4000]++;
        }
        Arrays.sort(arr);

        // 1. 평균
        System.out.println(Math.round(sum / N));

        // 2. 중앙값
        System.out.println(arr[N / 2]);

        // 3. 최빈값
        int maxFreq = 0;
        for (int i = 0; i < 8001; i++) maxFreq = Math.max(maxFreq, count[i]);

        ArrayList<Integer> modes = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxFreq) modes.add(i - 4000);
        }
        Collections.sort(modes);
        System.out.println(modes.size() > 1 ? modes.get(1) : modes.get(0));

        // 4. 범위
        System.out.println(arr[N - 1] - arr[0]);
    }
}