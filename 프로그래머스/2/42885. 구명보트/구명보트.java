import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int i=0;
        int j= people.length-1;
        Arrays.sort(people);
        while(i<=j){
            if(people[j]+people[i]<=limit){
                i++;
            }
            j--;
            answer++;
        }
        return answer;
    }
}