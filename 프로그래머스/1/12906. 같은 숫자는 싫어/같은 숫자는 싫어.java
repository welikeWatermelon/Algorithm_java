import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
      
        //Queue 구조를 사용할 것
        //1. 입력을 큐에 넣어줌
        //2. pop을 먼저 우선적으로 한뒤 answer에 추가 (전제 조건)
        //3. pop한 것과 peek()이 같으면 위에있는건 그냥 삭제
        //4. pop한 것과 peek()이 같지 않으면, pop한 뒤 answer에 추가
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(arr[0]);
        int tmpNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != tmpNum) {
                tmpNum = arr[i];
                tmp.add(arr[i]);
            }
        }
        //이게 ArrayList를 배열로 바꾸는 법
        int[] answer = tmp.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}