package swea_0221;

import java.util.Arrays;
import java.util.Scanner;

public class swea_5174_answer {
//    static int cnt=0;
    public static void main(String[] args) {
        //1. 트리구조 저장 -> left, right 내려가겠다
        //2. 서브트리 루트 노드 N을 기준으로 순회를 진행, 노드 탐색 할때마다 cnt ++;
        Scanner sc = new Scanner(System.in);
//        sc.nextInt(); //한 줄을 문자열로 받은 메서드
        //테스트 케이스 수 T
        int T = Integer.parseInt(sc.nextLine().trim()); //trim은 개행 삭제
        // sc.nextInt(), sc.next(), sc.nextDouble() -> 개행문자를 처리하지 않음
        // 그다음에 sc.nextLint()을 받으면 개행문자를 받게됨
        for (int t = 1; t <= T; t++) {
            //입력
            //간선의 갯수 E와 서브트리의 루트노드N
            //sc.nextLine(); // "5 1"
            String[] temp = sc.nextLine().split(" "); //["5", "1"]
            int E = Integer.parseInt(temp[0]);
            int N = Integer.parseInt(temp[1]);

            //간선의 정보 arr
            int[] arr = new int[E * 2];
            temp = sc.nextLine().split(" ");
            for (int i = 0; i < E; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }

//            int[] arr = Arrays.stream(sc.nextLine().split(" "))
//            .mapToInt(Integer::parseInt);
//            .toArray();
//            maptoInt가 원소 하나하나 실행하고 int로 바꿔줌


            //로직
            //1. 입력받은 데이터(간선 정보)를 가지고 트리의 정보를 저장(가공)
            //왼쪽 자식에 대한 정보 left,오른쪽 자식에 대한 정보  right 이차원 배열을 가지고 트리 정보를 저장

            int[] left = new int[E + 2];
            int[] right = new int[E + 2];
            for (int i = 0; i < E; i++) {
                //부모p와 자식c 정보
                int p = arr[i * 2];
                int c = arr[i * 2 + 1];

                //부 -> 자 정보 left, right 저장
                //이미 왼쪽 자식에 기록이 되어 있다면, 오른쪽 자식에 기록
                if (left[p] == 0) {
                    left[p] = c;
                } else {
                    right[p] = c;
                }
            }

            //2. 루트노드 N을 기준으로 순회..(카운트)
            // 어느 순회를 하든 상관이 없음
            // 전위 순회 코드로 진행
            int result = postOrder(N, left, right);

            //출력
            System.out.println("#" + t + " " + result);
        }
    }

    //루트 노드 N을 기준으로 순회하여 서브트리의 모든 노드의 갯수를 카운트 후 반환

    //<1번 풀이> - 추천
    private static int postOrder(int v, int[] left, int[] right) {
        // 카운트 변수 cnt
        int cnt = 0;

        // 노드 n을 기준으로 해서 V -> L -> R
        if (v != 0) {
            //현재 노드 v 탐색
            cnt++;
            // 왼쪽 자식 탐색 R
            cnt += postOrder(left[v], left, right);
            // 오른쪽 자식 탐색 L
            cnt += postOrder(right[v], left, right);

        }
        return cnt;
    }


//    //<2번 풀이> - 비추천
//        private static int postOrder(int v, int[] left, int[] right) {
//        // 카운트 변수 cnt -> 전역변수로
////        int cnt = 0;
//
//        // 노드 n을 기준으로 해서 V -> L -> R
//        if (v != 0) {
//            //현재 노드 v 탐색
//            cnt++;
//            // 왼쪽 자식 탐색 R
//            postOrder(left[v], left, right);
//            // 오른쪽 자식 탐색 L
//            postOrder(right[v], left, right);
//
//        }
//        return cnt;
//    }
}
