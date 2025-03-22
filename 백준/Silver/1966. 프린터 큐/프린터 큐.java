import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대값 우선
            Queue<HashMap<Integer, Integer>> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                int idx = i;
                int num = sc.nextInt();
                HashMap<Integer, Integer> tmpMap = new HashMap<>();
                tmpMap.put(num, idx);
                queue.add(tmpMap);
                pq.add(num);
            }

            int cnt = 0;

            while (true) {
                int findNum = queue.peek().keySet().iterator().next();
                if (queue.peek().keySet().toArray()[0] == pq.peek()) { //가장 앞에 있는게 max면
                    cnt++;
                    pq.poll();
                    if (queue.peek().get(findNum) == M) { //앞에있는게 max인데, idx까지 같을때
                        System.out.println(cnt);
                        break;
                    } else {
                        queue.poll();
                    }
                } else {
                    queue.add(queue.poll());
                }
            }


        }

    }
}
