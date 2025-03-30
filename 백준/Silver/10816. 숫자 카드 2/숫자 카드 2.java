import java.util.HashMap;
import java.util.Scanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1); // 개수 저장
        }
// 지정한 key가 있으면 해당 값 리턴하고, 없으면 기본값(defaultValue)을 리턴
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int query = sc.nextInt();
            sb.append(map.getOrDefault(query, 0)).append(" ");
        }

        System.out.println(sb);
    }
}
