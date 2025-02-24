

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = Integer.parseInt(sc.nextLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < X; i++) {
            String[] order = sc.nextLine().split(" ");
            if (order[0].equals("push")) {
                queue.add(Integer.parseInt(order[1]));
            } else if (order[0].equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll());
                }
            } else if (order[0].equals("size")) {
                System.out.println(queue.size());
            } else if (order[0].equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order[0].equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peek());
                }
            } else {//back
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(((LinkedList<Integer>) queue).getLast());
                }
            }
        }
    }
}
