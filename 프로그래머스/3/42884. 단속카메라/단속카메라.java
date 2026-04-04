// 최소 한번은 카메라를 만나도록 설치할 것
// 최소 한번은 모든 차량이 카메라를 만나도록 하려면, 최소 몇대의 카메라를 설치해야 하는지
// 차량 <10,000
// 진입, 진출 : -30,000 ~ 30,000

// -20,"-15"  / -18,-13 / -14,-5 / -5,-3
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int camera = Integer.MIN_VALUE;
        for(int i=0; i<routes.length; i++){
            if(i==0){
                camera = routes[i][1];
                answer++;
            }else{
                int start = routes[i][0];
                int end = routes[i][1];
                if(start<=camera && end>=camera) continue;
                camera = end;
                answer++;
            }
        }
        return answer;
    }
}