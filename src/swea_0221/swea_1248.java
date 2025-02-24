package swea_0221;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1248 {
    static int[][] node;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= T; t++) {
            String[] temp = sc.nextLine().split(" "); //["5", "1"]
            int V = Integer.parseInt(temp[0]); //정점의 개수
            int E = Integer.parseInt(temp[1]); //간선의 개수
            int n1 = Integer.parseInt(temp[2]); // node 1
            int n2 = Integer.parseInt(temp[3]); // node 2
            node = new int[V + 1][3];

            int[] arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            // 노드 입력 index(부모), 0 (child1), 1 (child2), 2(parent)
            for (int i = 0; i < E; i++) {
                int p = arr[i * 2];
                int c = arr[i * 2+1];

                if (node[p][0] == 0) {
                    node[p][0] = c;
                } else {
                    node[p][1] = c;
                }
                node[c][2] = p;
            }

            //로직 <1>
            // n1과 n2의 공통조상을 찾고, 그 조상의 크기를 알아내야함
            // 1. n1의 첫번째 부모(p1)를 저장하고, n2의 부모(p2)와 비교
            // 1-1. 이때, p1이 p2와 같다면 정답 출력 break
            // 1-2. p1이 p2보다 작아지면 그때 p2를 저장하고 break
            // 2. p1의 부모를 찾아가면서 p2와 비교

            //로직 <2>
            // n1과 n2의 공통조상을 찾고, 그 조상의 크기를 알아내야함
            // 1. 부모를 찾는 수를 1씩 늘려가며 두 부모를 비교한다.
            // 2. n1의 부모를 p1, 찾을때 c1 , n2의 부모를 p2, 찾을때 c2 라고 하자.
            // 3. 부모를 계속 탐색해가며 p1과 p2를 비교하고 같다면 break

            // cnt를 변경해가며,,
            //로직 <2>
            int answer = 0;
            cnt = 0;
            outer:
            for (int i = 1; i< V; i++) {
                int first = findParent(node, n1, i);
                for (int j = 1; j< V ; j++) {
                    if (first == findParent(node,n2, j)) {
                        answer = findParent(node, n1, i);
                        break outer;
                    }
                }
            }

            childCnt(node, answer);

            System.out.printf("#%d %d %d\n",t,answer,cnt+1);
        }
    }

    //부모의 인덱스를 return 할것임
    //n에는 n1,n2가 들어감 / cnt에는 반복횟수
    static int findParent(int[][] node,int n, int cnt) {
        // 종료 조건: cnt가 0이거나 n이 0이면 현재 노드 반환
        if (cnt == 0) {
            return n;
        }
        // 부모를 찾고 재귀 호출하여 cnt를 감소시키며 부모의 부모를 계속 탐색
        return findParent(node, node[n][2], cnt - 1);
    }

    //자식 몇개?
    static void childCnt(int[][] node, int p) {
        if (node[p][0] != 0) {
            cnt++;
            childCnt(node, node[p][0]);
        }

        if (node[p][1] != 0) {
            cnt++;
            childCnt(node, node[p][1]);
        }

    }

}

//힙의 자료 크기 원소의 개수 * 4 * 4
