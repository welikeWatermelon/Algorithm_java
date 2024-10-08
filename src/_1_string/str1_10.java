package src._1_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class str1_10 {
    public static void solution(String str,char t) {
        char[] array = str.toCharArray();
        char[] array1;

        //거리 최소 (답)
        List<Integer> min = new ArrayList<>();

        //t가 있는 인덱스 (해당 문자가 있는 인덱스)
        List<Integer> indices = new ArrayList<>();

        //1. t들의 위치를 모두 찾는다 (인덱스로) (ex. t가 3개)
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == t)
                indices.add(i);
        }
        //4. 1~3을 문자열 반복
        for (int i = 0; i < str.length(); i++) {
            int minDis = 1000;
            //2. 각 위치에서 t들의 인덱스를 뺀다 (3개의 결과가 나옴)
            //3. 그 중 minDis 구한다 (3개의 결과중 가장 작은거. 0보다 큰거)
            for (Integer index : indices) {
                if (Math.abs(i - index) < minDis) {
                    minDis = Math.abs(i - index);
                }
            }
            //min의 정답 리스트에 추가
            min.add(minDis);
        }
        for (Integer i : min) {
            System.out.print(i+" ");
        }

    }

    public static void main(String[] args) {
        str1_10 main = new str1_10();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();  // 첫 번째 단어를 문자열로 입력 받음
        char t = scanner.next().charAt(0);  // 두 번째 단어의 첫 번째 문자를 입력 받음
        main.solution(str,t);
    }
}
