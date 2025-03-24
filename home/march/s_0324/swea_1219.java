package s_0324;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea_1219 {

    public static List<Node> nodes;
    static class Node{
        int from;
        int to;

        Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) { // Test 케이스 번호
            nodes = new ArrayList<>();
            sc.nextInt();
            int C = sc.nextInt();
            sc.nextLine();

            // 순서쌍 입력
            for (int i = 0; i < C; i++) {
                int s = Integer.parseInt(sc.next());
                int e = Integer.parseInt(sc.next());
                nodes.add(new Node(s, e));
            }

            if (DFS(0)) {
                System.out.printf("#%d %d\n", t, 1);
            } else {
                System.out.printf("#%d %d\n", t, 0);
            }
        }
    }


    public static boolean DFS(int depth) {
        if (nodes.get(depth).to == 99) {
            return true;
        }

        int start = nodes.get(depth).to;
        for (int i = 0; i < nodes.size(); i++) {
            if (start == nodes.get(i).from) {
                if(DFS(i)) return true;
            }
        }
        return false;
    }
}
