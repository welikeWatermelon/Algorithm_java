package swea_0220;

import java.util.Scanner;

public class swea_5176_4 {
    static int[] tree;
    static int index;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            tree = new int[N + 1];
            index = 0;

            inOrder(1, N);

            int root = tree[1];
            int n2 = tree[N / 2];

            System.out.printf("#%d %d %d\n",t,root,n2);
        }
    }

    public static void inOrder(int node, int N) {
        if(node>N) return;
        inOrder(2*node,N);
        tree[node] = ++index;
        inOrder(2*node+1,N);
    }
}
