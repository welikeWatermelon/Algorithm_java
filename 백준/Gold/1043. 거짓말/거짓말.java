import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] parent;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parent = new int[N+1];
        // 부모 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int M = sc.nextInt();
        int truthCnt = sc.nextInt();
        if (truthCnt == 0) {
            System.out.println(M);
            return;
        }

        List<int[]> list = new ArrayList<>();

        int firstTruthPeople = sc.nextInt();
        for (int i = 1; i < truthCnt; i++) {
            int nextTruthPeople = sc.nextInt();
            union(firstTruthPeople,nextTruthPeople);
        }

        for (int i = 0; i < M; i++) {
            int cnt = sc.nextInt();
            int firstPeople = sc.nextInt();
            int[] tmpInt = new int[cnt];
            tmpInt[0] = firstPeople;
            for (int j = 1; j < cnt; j++) {
                int nextPeople = sc.nextInt();
                union(firstPeople, nextPeople);
                tmpInt[j] = nextPeople;
            }
            list.add(i,tmpInt);
        }


        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (lie(firstTruthPeople,list.get(i))) {
                cnt++;
            }
        }

        System.out.println(cnt);





    }

    public static int find(int x){
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX != parentY) {
            parent[parentY] = parentX;
        }
    }

    public static boolean same(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        return parentX == parentY;
    }

    public static boolean lie(int firstTruthPeople, int[] partyList) {
        int root = find(firstTruthPeople);
        for (int i = 0; i < partyList.length; i++) {
            if (root == find(partyList[i])) { // 같다는건 진실을 안다는 것
                return false;
            }
        }
        return true; // 끝까지 통과했다는건 진실을 아는애가 없다는 것
    }

}
