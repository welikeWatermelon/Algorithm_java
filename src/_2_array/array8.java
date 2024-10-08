package src._2_array;
//다시 해야한다
import java.util.*;
import java.util.Scanner;

public class array8 {
    public static int[] solution(int n, int[] arr) {
        int[] nArr = arr.clone(); //arr는 원래 배열
        int[] answer = new int[n]; //순위 적는 배열
        Arrays.sort(nArr); //nArr는 오름차순으로 정렬된 배열
        for (int i=0;i<n; i++) {
            int a = Arrays.asList(nArr).indexOf(arr[i]); //arr
            //오름차순으로 정렬된 배열에서 arr[i]의 위치가 어딨냐?
            answer[i] = a+1;
            //
        }
        return answer;
    }

    public static void main(String[] args) {
        array8 T = new array8();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, arr)[0]);
    }
}
