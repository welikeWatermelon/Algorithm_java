package home_0309;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class inflearn_hashmap03 {
//    public static int N,K;
    public static int[] arr;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N - K + 1; i++) {
            System.out.print(solution(N,K).get(i)+" ");
        }
    }

    public static ArrayList<Integer> solution(int N, int K){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        //시작 초기 설정 (처음 N-K개 들어갔음)
        for (int i = 0; i < K-1; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for (int i = 0; i <= N - K; i++ ) {
            //1. 다음 꺼 더해줘
            map.put(arr[K - 1 + i], map.getOrDefault(arr[K - 1+i], 0) + 1);
            //2. 점수 출력
            answer.add(map.size());
            //3. 처음 꺼 빼줘
            //3-1. 처음꺼가 한개만 나왔다면
            if (map.get(arr[i]) == 1) {
                map.remove(arr[+ i]);
            } else { //3-2. 처음꺼가 두개 이상이라면 카운트를 하나 빼줌
                map.put(arr[i], map.get(arr[i]) - 1);
            }
        }
        return answer;
    }
}
