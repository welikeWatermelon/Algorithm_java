package home_0313;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class inflearn_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String essential = sc.next();
        String subject = sc.next();
        Queue<Character> q = new LinkedList<>();

        for (char c : essential.toCharArray()) {
            q.add(c);
        }

        for (char c : subject.toCharArray()) {
            if (!q.isEmpty() && c == q.peek()) {
                q.poll();
            }
        }
        if (q.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
