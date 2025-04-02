import java.util.Scanner;

public class Main {
    public static int[] parents;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 도시의 수
        int M = sc.nextInt(); // 계획의 수
        parents = new int[N + 1];
        setParent();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    union(i,j);
                }
            }
        }

        sc.nextLine();
        String[] tmp = sc.nextLine().split(" ");
        int answer = findParent(Integer.parseInt(tmp[0]));

        for (int i = 0; i < tmp.length; i++) {
            if (answer != findParent(Integer.parseInt(tmp[i]))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    public static void setParent() {
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int findParent(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = findParent(parents[x]);
    }

    public static void union(int x, int y) {
        int rootX = findParent(x);
        int rootY = findParent(y);
        if (rootX < rootY) {
            parents[rootY] = rootX;
        } else {
            parents[rootX] = rootY;
        }
    }
}


// 다음 N개의 줄에는 N개의 정수가 주어진다. i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다
// 1이면 연결된 것이고 0이면 연결이 되지 않은 것이다.
// 마지막 줄에는 여행 계획이 주어진다.