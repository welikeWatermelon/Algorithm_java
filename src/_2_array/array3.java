package src._2_array;

import java.util.ArrayList;
import java.util.Scanner;

public class array3 {
    public static ArrayList<String> solution(int n, int[] a, int[] b) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.abs(a[i] - b[i]) == 2) {
                if (a[i] > b[i]) {
                    answer.add("B");
                } else {
                    answer.add("A");
                }
            } else if (a[i] > b[i]) {
                answer.add("A");
            } else if (a[i] < b[i]) {
                answer.add("B");
            } else {
                answer.add("D");
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        array3 T = new array3();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];


        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        for (String i : T.solution(n, a, b)) {
            System.out.println(i);
        }

    }
}
