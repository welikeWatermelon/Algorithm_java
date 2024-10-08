package src._1_string;
import java.util.HashSet;
import java.util.Set;

public class str1_11 {
    public static void solution(String str) {
        char[] array = str.toCharArray();
        Set<String> set = new HashSet<>();

        // 문자를 하나씩 집합에 추가하므로써 중복제가
        for (char s : array) {
            set.add(String.valueOf(s)); // char를 String으로 변환하여 추가
        }

        // 중복이 제거된 문자를 원래 str에서 개수를 찾는 과정
        for (String s : set) {

        }

        //str개수를 찾아서 문자 다음 넣어주는 과정
    }
}
