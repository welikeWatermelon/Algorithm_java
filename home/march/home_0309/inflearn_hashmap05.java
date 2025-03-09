package home_0309;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class inflearn_hashmap05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //가진 것 중 3장을 뽑아 큰수로 나열
        //ArrayList로 받아야함

        //세장을 뽑아 리스트에 모두 넣음 -> 내림차순 정리

        System.out.println(solution(N,K,arr));

    }

    public static int solution(int N, int K, int[] arr) {
        int answer=0; //문자는 nC3의 문제
        ArrayList<Integer> answerArr = new ArrayList<>();
//        if(nC3<K) return -1;
        //초기 설정 2개 넣어주기
//        TreeSet<Integer> Tset = new TreeSet<>(); // 기본적으로 오름차순으로 정렬시킴
//        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); // 내림차순으로 정렬시킴

//        tree.

//        Collections.sort(answerArr, Collections.reverseOrder());


//        answer = answerArr.get(K-1);

        return answer;
    }
}


