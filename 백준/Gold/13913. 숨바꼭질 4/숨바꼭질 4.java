import java.util.*;

public class Main {

    private static final int MAX_POS = 100_001;
    private static final int[] time = new int[MAX_POS];
    private static final int[] previous = new int[MAX_POS];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startPos = sc.nextInt();
        int targetPos = sc.nextInt();
        sc.close();

        findShortestPath(startPos, targetPos);

        StringBuilder sb = new StringBuilder();
        sb.append(time[targetPos] - 1).append('\n');

        List<Integer> path = new ArrayList<>();
        for (int cur = targetPos; cur != startPos; cur = previous[cur]) {
            path.add(cur);
        }
        path.add(startPos);
        Collections.reverse(path);

        for (int pos : path) sb.append(pos).append(' ');

        System.out.println(sb.toString().trim());
    }

    private static void findShortestPath(int startPos, int targetPos) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startPos);
        time[startPos] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == targetPos) return;

            int[] nextChoices = { current * 2, current - 1, current + 1 };
            for (int nextPos : nextChoices) {
                if (0 <= nextPos && nextPos < MAX_POS && time[nextPos] == 0) {
                    q.offer(nextPos);
                    time[nextPos] = time[current] + 1;
                    previous[nextPos] = current;
                }
            }
        }
    }
}
