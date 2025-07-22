import java.util.*;

public class Main {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int cnt;
    public static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            sc.nextLine();
            cnt = 0;
            visited = new boolean[N];
            arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(s->Integer.parseInt(s)-1)
                    // .map(s -> Integer.parseInt(s))와 같음
                    // map() + collect() → List<Integer> 만들고 싶을 때
                    // mapToInt() + toArray() → int[] 배열 만들고 싶을 때
                    .toArray();

            bfs(0);
            System.out.println(cnt);
        }


    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!visited[arr[current]]) {
                queue.add(arr[current]);
                visited[arr[current]] = true;
            } else { // 순환 발견
                cnt++;
                // 다음 타겟을 queue 에 넣어야함
                for (int i : arr) {
                    if (!visited[i]) {
                        queue.add(i);
                        break;
                    }
                }
            }
        }
    }
}

// 지나가면 무조건 true

