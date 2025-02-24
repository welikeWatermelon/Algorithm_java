package tree;

import java.util.Scanner;

public class swea_5174 {
    static int[] child1;
    static int[] child2;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            cnt = 0;
            int E = sc.nextInt();
            int N = sc.nextInt();
            child1 = new int[E + 2];
            child2 = new int[E + 2];

            //입력
            for (int i = 0; i < E; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                if (child1[parent] == 0) {
                    child1[parent] = child;
                } else if (child1[parent] != 0) {
                    child2[parent] = child;
                }

            }

            solution(N);
            System.out.printf("#%d %d\n",t,cnt+1);

        }
    }

    public static void solution(int idx) {
        if(child1[idx] != 0 && child2[idx] != 0) cnt+=2;
        else if(child1[idx] != 0) cnt++;
        else if(child2[idx] != 0) cnt++;
        else return;

        solution(child1[idx]);
        solution(child2[idx]);
    }

    //어떻게 배열을 해서 넣어줄지가 관건
    //해당 num에 해당하는 index를 찾아서 넣어야함
    //먼저 index에 맞춰서 num을 넣어주는것이 중요

    //노드의 개수 = 간선의 개수 + 1
    //
     // 부모와 자식을 어떻게 받을지?
    // 1. HashMap으로 받을 수 있음 (int i , ArrayList<>)
    // -> i부모에 ArrayList에 자식 추가

    // 2. index를 부모로, child1, child2로 받음
    // -> 새로운 입력이 들어왔을 떄, child1이 차 있을 경우, child2 에 넣어줌
}
