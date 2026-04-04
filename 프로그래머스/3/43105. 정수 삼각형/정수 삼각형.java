import java.util.*;
// 그대로 내려가거나
// 현위치 +1 로 내려가야함
// 높이는 최대 500
// 숫자는 최대 10,000
// 꼭대기에서 바닥까지 가는데 최대 합을 구하고자 하는 것
// dp[i] : i층까지 최대 합 이라고 하자.
// 층마다의 연관관계가 있나?
// dp[i][j] : i층의 j인덱스를 꼭 들리는 최대 합?
// dp[0][0] = 7

// dp[1][0] = 10
// dp[1][1] = 15

// dp[2][0] = dp[1][0] + arr[2][0] 제일 왼쪽
// dp[2][1] = Math.max(dp[1][0], dp[1][1]) + arr[2][1] 중앙
// dp[2][2] = dp[1][1] + arr[2][2]; 제일 오른쪽

// dp[3][0] = dp[2][0] + arr[3][0]
// dp[3][1] = Math.max(dp[2][0],dp[2][1]) + arr[3][1]
// dp[3][2] = Math.max(dp[2][1],dp[2][2]) + arr[3][2]
// dp[3][3] = dp[2][2] + arr[3][3]

// <일반식>
// 처음 : dp[i][0] = dp[i-1][0] + arr[i][0]
// 중간 : dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j]
// 마지막 : dp[i][i] = dp[i-1][i-1] + arr[i][i]

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        return tri(triangle);
    }
    
    public int tri(int[][] triangle){
        int[][] dp = new int[triangle.length][];
        for(int i=0; i<triangle.length; i++){
            dp[i] = new int[i+1];
        }
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<=i; j++){
                if(j==0) {
                    dp[i][j] = dp[i-1][0] + triangle[i][0];
                }else if(j==i){
                    dp[i][j] = dp[i-1][i-1] + triangle[i][i];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        int maxAnswer = 0;
        for(int i=0; i<triangle.length; i++){
            maxAnswer = Math.max(maxAnswer,dp[triangle.length-1][i]);
        }
        
        return maxAnswer;
        
    }
}