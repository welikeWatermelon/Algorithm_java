import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        // 입력이 중복되는 경우도 있으니, ArrayList보다 배열로 graph를 만들자
        int[][] graph = new int[N + 1][N + 1];
        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int cnt = sc.nextInt();
            int[] tmpArr = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                tmpArr[j] = sc.nextInt();

//                if (graph[start][end] != 1) {
//                    graph[start][end] = 1;
//                    inDegree[end]++;
//                }
            }
            for (int j = 0; j < cnt - 1; j++) {
                if (graph[tmpArr[j]][tmpArr[j + 1]] == 0) {
                    graph[tmpArr[j]][tmpArr[j + 1]] =1;
                    inDegree[tmpArr[j+1]] ++;
                }
            }
        }



        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int start = q.poll();
            result.add(start);
            int[] tmp = graph[start];

            for (int i = 1; i <= N; i++) {
                if (tmp[i] == 1) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        // 순서를 정하는게 불가능 한 경우는, 순환이 생기는 경우!!
        if (result.size() < N) {
            System.out.println(0);
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }


    }
}
