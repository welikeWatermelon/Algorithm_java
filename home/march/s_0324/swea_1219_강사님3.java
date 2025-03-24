//package s_0324;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class swea_1219_강사님3 {
//    static class Node {
//        int v; // 이전 정점 정보
//        int u; // 다음 정점 정보
//        int w; // 가중치 정보
//
//        public Node(int v, int u, int w) {
//            this.v = v;
//            this.u = u;
//            this.w = w;
//        }
//    }
//
//    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("input.txt"));
//        Scanner sc = new Scanner(System.in);
//
//        int T = 10;
//        for (int tc = 1; tc <= T; tc++) {
//
//            // 테스트케이스번호 test_case, 길(간선 edge) 의 갯수 E
//            String temp = sc.nextLine().trim();
//            String[] temp2 = temp.split(" ");
//            int test_case = Integer.parseInt(temp2[0]);
//            int E = Integer.parseInt(temp2[1]);
//
//            // 순서쌍을 입력...
//            String[] temp3 = sc.nextLine().trim().split(" ");
//            int[] pairs = new int[E * 2];
//            for (int i = 0; i < pairs.length; i++) {
//                pairs[i] = Integer.parseInt(temp3[i]);
//            }
////			int[] pairs = Arrays.stream(sc.nextLine().trim().split(" "))
////					.mapToInt(x -> Integer.parseInt(x))
////					.toArray();
//
//            // 로직
//            int V = 100;
//            // 해당 입력을 통해 인접리스트 방법...! (리스트 -> why? 크기가 동적)
//            List<List<Node>> adj = new ArrayList<>();
//            // 인접리스트 초기 생성 시에 V개 만큼의 인접 리스트를 추가 생성하여 할당
//            for (int i = 0; i < V; i++) {
//                adj.add(new ArrayList<>());
//            }
//
//            // 인접행렬은 노드(정점) 사이의 정보를
//            // 연결 관계를 직접 adj.get(u).add(v); // u -> v
//            // 정점 u -> 정점 v로 갈 수 있는 페어를 꺼내와야 한다. pairs 로부터
//            int w = 100;
//            for (int i = 0; i < pairs.length; i += 2) {
//                int u = pairs[i];
//                int v = pairs[i + 1];
//
//                adj.get(u).add(new Node(u, v, w)); // u -> v, 가중치w 갈 수 있음 o
//            }
//
//            isArrive = false;
//            visited = new boolean[V][V];
//            // 현재위치(시작점 노드 번호 0)
//            // 마지막 종점 위치 (종착점 노드 번호 99)
//            recursive(V, adj, 0, 99);
////
////			// 출력
//            System.out.println("1");
//        }
//    }
//
//    static final int[] dx = { 0, 0, -1, 1 }; // 델타배열
//    static final int[] dy = { -1, 1, 0, 0 }; // (동서남북)
//
//    static boolean isArrive; // 도착할 수 있는지 유무
//    static boolean[][] visited; // 방문 체크 배열
//
//    // 재귀함수를 통해서 동서남북으로 이동할 수 있는 좌표를 탐색(+방문체크)하고,,,
//    // 최종적으로는 마지막 노드 99 좌표에 현재 좌표 (x, y)와 동일하게 되면 종료!
//    // (+isArrive 변수 값을 true)
//    private static void recursive(final int V, final List<List<Integer>> adj, int start, int end) {
//        // 기저조건 (종료조건)
//        // -> 마지막 노드(99번 노드) 좌표에 현재 노드(start)와 동일할 때
//        if (start == end) {
//            isArrive = true;
//            return;
//        }
//
//        // 재귀호출 다음좌표로 탐색 (다음 노드로 탐색할 수 있는지를 인접행렬을 통해 확인)
//        // start -> 모든v를 한번씩 가져온다...!
//        for (Node node : adj.get(start)) {
//            if (visited[start][node.v] == true) {
//                continue;
//            }
//
//            // i번 노드로 방문을 진행하겠다...!
//            // 방문배열에 체크...!
//            visited[start][node.v] = true; // 결정
//            recursive(V, adj, node.v, end);
//            visited[start][node.v] = false; // 복구
//        }
//    }
//
//}
//
//
