import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static class Meeting implements Comparable<Meeting>{
        long start;
        long end;

        public Meeting(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end != o.end) {
                return Long.compare(this.end, o.end);
            }
            return Long.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new Meeting(sc.nextLong(), sc.nextLong()));
        }

        Long lastTime = 0L;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            Long start = meeting.start;
            Long end = meeting.end;
            if (start >= lastTime) {
                cnt++;
                lastTime = end;
            }
        }

        System.out.println(cnt);
    }
}
