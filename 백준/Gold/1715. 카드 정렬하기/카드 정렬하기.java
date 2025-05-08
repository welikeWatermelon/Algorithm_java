import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 1 ≤ N ≤ 100,000
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
            // 1,000보다 작거나 같은 양의 정수
        }

        int sum = 0;
        if (N == 1) {
            System.out.println(0);
            return;
        }
        while(true) {
            int A = pq.poll();
            int B = pq.poll();
            sum += (A + B);
            if(pq.isEmpty()) break;
            pq.add(A+B);
        }

        System.out.println(sum);

    }
}