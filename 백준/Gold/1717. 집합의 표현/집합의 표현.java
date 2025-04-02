import java.util.Scanner;

public class Main {
    public static int[] parents;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        parents = new int[n+1];
        setParent();

        for (int i = 0; i < m; i++) {
            int hop = sc.nextInt(); // hop이 1일때만 출력할거임
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (hop == 0) {
                union(u, v);
            } else {
                System.out.println(findParent(u)==findParent(v) ? "YES" : "NO");
            }
        }
    }

    public static void setParent(){
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    public static int findParent(int x){
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = findParent(parents[x]);
    }

    public static void union(int x, int y){
        int root_x = findParent(x);
        int root_y = findParent(y);
        if (root_x < root_y) {
            parents[root_y] = root_x;
        } else {
            parents[root_x] = root_y;
        }
    }
}

// rank : 유니온 파인드에서 트리의 높이를 기준으로 붙이기 위해 사용하는 정보
// 두 집합을 합칠 때, 더 얕은 트리를 깊은 트리에 붙임
// 이렇게 해야 트리가 편향되지 않고 전체 탐색연산이 더 빨라짐
// find할 때, 탐색 깊이 최소화
