package home_0313;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class b_2841{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        Stack<Integer> three = new Stack<>();
        Stack<Integer> four = new Stack<>();
        Stack<Integer> five = new Stack<>();
        Stack<Integer> six = new Stack<>();
        List<Stack<Integer>> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);

        int N = sc.nextInt();
        int P = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int string = sc.nextInt();
            int fret = sc.nextInt();
            if (list.get(string - 1).isEmpty()) {
                list.get(string - 1).add(fret);
                cnt++;
            } else if (list.get(string - 1).peek() < fret) {
                cnt++;
                list.get(string - 1).add(fret);
            }else {
                while (!list.get(string - 1).isEmpty()
                        && list.get(string - 1).peek() > fret) {
                    cnt++;
                    list.get(string - 1).pop();
                }
                if (!list.get(string - 1).isEmpty() && list.get(string - 1).peek() == fret) {
                    continue;
                }
                list.get(string - 1).add(fret);
                cnt++;
            }
        }

        System.out.println(cnt);


    }
}
