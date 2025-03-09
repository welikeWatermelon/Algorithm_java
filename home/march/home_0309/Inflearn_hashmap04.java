package home_0309;

import java.util.HashMap;
import java.util.Scanner;

public class Inflearn_hashmap04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        String test = sc.next();
        int answer = solution(st, test);
        System.out.println(answer);

    }

    public static int solution(String st, String test) {
        HashMap<Character, Integer> mapSt = new HashMap<>();
        HashMap<Character, Integer> mapTest = new HashMap<>();

        int answer = 0;
        for (char c : test.toCharArray()) {
            mapTest.put(c, mapTest.getOrDefault(c, 0) + 1);
        }

        //초기 설정 maptest의 길이보다 하나 적게 들어옴
        for (int i = 0; i < test.length()-1; i++) {
            mapSt.put(st.charAt(i), mapSt.getOrDefault(st.charAt(i), 0) + 1);
        }

        //7번 진행되어야 함
        for (int i = 0; i < st.length() - test.length() + 1; i++) {
            //넣기
            mapSt.put(st.charAt(i + test.length()-1), mapSt.getOrDefault(st.charAt(i + test.length()-1), 0) + 1);
            //정답 확인
            if (mapSt.equals(mapTest)) {
                answer++;
            }
            //삭제하기
            if (mapSt.get(st.charAt(i)) == 1) {
                mapSt.remove(st.charAt(i));
            } else {
                mapSt.put(st.charAt(i), mapSt.get(st.charAt(i)) - 1);
            }
        }

        return answer;

    }
}
