package src.array;

import java.util.ArrayList;
import java.util.Scanner;

public class array4 {
    public static ArrayList<Integer> solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);

        for (int i = 2; i < n; i++) {
            int newAns = arr.get(i-2) + arr.get(i-1);
            arr.add(newAns);
        }
        return arr;
    }

    public static void main(String[] args) {
        array4 T = new array4();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Integer를 String으로 변환하고, 공백으로 구분하여 출력
        /*String result = T.solution(n).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));  // 공백으로 구분

        System.out.println(result);  // 출력 예: 1 1 2 3 5 8 13 21 34 55
*/
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ",T.solution(n).get(i));
        }
    }
}
