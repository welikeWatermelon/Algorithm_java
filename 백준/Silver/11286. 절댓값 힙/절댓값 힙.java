import java.util.*;

class A implements Comparable<A> {

    int x;
    int y;

    public A(int x) {
        this.x = x;
        this.y = Math.abs(x);
    }

    @Override
    public int compareTo(A o) {
        int tmp = this.y - o.y;
        if (tmp == 0) {
            return this.x - o.x;
        }
        return tmp; // y 기준 정렬
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<A> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().x);
                }
            } else {
                pq.add(new A(num));
            }
        }
    }
}

// x가 자연수라면 배열에 x라는 값을 넣는
//  x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우
// 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.