package swea_0220;

import java.util.Scanner;

public class swea_5176 {
    static int[] tree;
    static int index;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            tree = new int[N+1];
            //높이 생성
//            int H = (int) (Math.log(N) / Math.log(2));
            index = 0;
            inOrder(1, N);

            int rootValue = tree[1];
            int midValue = tree[N / 2];

            System.out.println("#" + t + " " + rootValue + " " + midValue);
        }
    }

    //n은 실제 배열의 크기
    public static void inOrder(int node, int n) {
        if(node > n) return;
        //L
        inOrder(2*node,n);

        //본문
        tree[node] = ++index;

        //R
        inOrder(2*node+1,n);
    }

}
