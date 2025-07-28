import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 돌 수
        int[] arr = new int[N];  // 점프 배열

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int start = sc.nextInt() - 1;  // 시작 인덱스 

        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 1;  // 시작점도 포함

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int left = now - arr[now];
            int right = now + arr[now];

            // 왼쪽 점프
            if (left >= 0 && !visited[left]) {
                visited[left] = true;
                queue.add(left);
                count++;
            }

            // 오른쪽 점프
            if (right < N && !visited[right]) {
                visited[right] = true;
                queue.add(right);
                count++;
            }
        }

        System.out.println(count);
    }
}
