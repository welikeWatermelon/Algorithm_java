package home_0312;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class inflearn_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> qu = new LinkedList<>();
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            qu.add(i);
        }

        int cnt = 0;
        while(qu.size()!=1) {
            cnt++;
            if (cnt == K) {
                qu.remove();
                cnt=0;
                continue;
            }
            qu.add(qu.poll());

        }
        System.out.println(qu.poll());
    }
}
