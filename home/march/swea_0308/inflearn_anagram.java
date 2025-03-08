package swea_0308;

import java.util.HashMap;
import java.util.Scanner;

public class inflearn_anagram {
    public static String solution(String st1, String st2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : st1.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (char c : st2.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)-1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String st1 = sc.next();
        String st2 = sc.next();

        System.out.println(solution(st1, st2));
    }
}
