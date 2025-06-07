import java.util.*;
import java.util.Queue;
import java.util.Scanner;
// 백준 2146번
public class Main {
    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N;
    public static int[][] arr;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static ArrayList<ArrayList<int[]>> whereIsland = new ArrayList<>();
    public static ArrayList<List<int[]>> edgeIsland = new ArrayList<>();
    public static boolean[][] checked;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        checked = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 섬 나누기 (whereIsland 에 들어감)

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!checked[i][j] && arr[i][j] == 1 ) {
                    cut(i, j);
                }
            }
        }

        for (List<int[]> lis : whereIsland) {
            edgeIsland.add(findEdges(lis));
        }


        for (int i = 0; i < edgeIsland.size()-1; i++) {
            for (int j = i + 1; j < edgeIsland.size(); j++) {
                List<int[]> A = edgeIsland.get(i); //list[int[]] 나옴
                List<int[]> B = edgeIsland.get(j); //list[int[]] 나옴
                for (int a = 0; a < A.size(); a++) {
                    for (int b = 0; b < B.size(); b++) {
                        answer = Math.min(distance(A.get(a), B.get(b)),answer);
                    }
                }
            }
        }


        if (whereIsland.size() == 0) {
            answer = 1;
        }
        
        System.out.println(answer-1);




    }
    public static void cut(int x, int y){
        checked[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        ArrayList<int[]> tmp = new ArrayList<>();
        int[] listTmp = new int[2];
        listTmp[0] = x;
        listTmp[1] = y;
        tmp.add(listTmp);
        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 1 && !checked[nx][ny]) {
                    q.add(new Node(nx, ny));
                    int[] listTmp2 = new int[2];
                    listTmp2[0] = nx;
                    listTmp2[1] = ny;
                    tmp.add(listTmp2);
                    checked[nx][ny] = true;
                }
            }
        }
        whereIsland.add(tmp);
    }

    public static int distance(int[] A, int[] B) {
        return Math.abs(A[0] - B[0]) + Math.abs(A[1] - B[1]);
    }

    public static List<int[]> findEdges(List<int[]> islandCoords) {
        List<int[]> edges = new ArrayList<>();

        for (int[] pos : islandCoords) {
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 확인
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 바다와 맞닿았는지 확인
                if (arr[nx][ny] == 0) {
                    edges.add(new int[]{x, y});
                    break;  // 중복 추가 방지
                }
            }
        }

        return edges;
    }

}


// 섬을 나눠서 해당 좌표들이 한 그룹안에 들어가도록 해야함  -> BFS로 판단
// 여러개의 그룹이 생길텐데, 완전탐샏을 해야하나? (A의 1번과 B의 1번의 좌표차이를 계산)
// ArrayList[ArrayList<int[]>]
// 그렇게 해서 최솟갑을 계속 구해가느 과정
// 섬 두개를 고르고, 안의 요소들을 모두 비교함
