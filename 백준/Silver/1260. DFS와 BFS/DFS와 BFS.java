import java.util.*;

public class Main {

    public static int N;
    public static int M;
    public static int V;
    public static node[] arr;
    public static boolean[] checked;


    public static class node{
        ArrayList<Integer> links = new ArrayList<>();

        public void plusLink(int link) {
            links.add(link);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        arr = new node[N+1];
        checked = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            arr[i] = new node();
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[start].plusLink(end);
            arr[end].plusLink(start);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(arr[i].links);
        }

        checked[V] = true;
        System.out.print(V);
        dfs(V);
        System.out.println();
        checked = new boolean[N + 1];
        bfs(V);
    }

    public static void dfs(int V){
        for (int nextNode : arr[V].links) {
            if (!checked[nextNode]) {
                checked[nextNode]  = true;
                System.out.print(" " + nextNode);
                dfs(nextNode);
            }
        }

    }

    public static void bfs(int V){
        System.out.print(V);

        node now = arr[V];
        checked[V] = true;
        Queue<node> queue = new LinkedList<>();
        queue.add(now);
        while (!queue.isEmpty()) {
            node nowNode = queue.poll();
            for (int i : nowNode.links) {
                if (!checked[i]) {
                    checked[i] = true;
                    queue.add(arr[i]);
                    System.out.print(" " + i);
                }
            }
        }
    }
}
