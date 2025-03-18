import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = sc.nextInt();
        }

        Deque<Integer> arr = new LinkedList<>();

        //👉 Deque<Integer> list = new LinkedList<>(); 로 선언하면,
        // Deque 인터페이스에 get(int index) 메서드가 없어서 컴파일 에러 발생!!! 🚨
        // 따라서 ((LinkedList<Integer>) deque).get(3);

        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        // Deque를 LinkedList로 구현하면 get(int index) 메서드 사용 가능
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (target[i] == ((LinkedList<Integer>) arr).get(j)) {
                    //앞에 숫자가 많으면
                    if (j > arr.size() - j) {
                        int idx = 0;
                        while (idx++ < (arr.size() - j)) {
                            sol3(arr);
                            cnt++;
                        }
                    } else {
                        int idx = 0;
                        while (idx++ < j) {
                            sol2(arr);
                            cnt++;
                        }
                    }
                    arr.pop();
                }
            }
        }

        System.out.println(cnt);



    }

    // 2번
    public static void sol2(Deque<Integer> arr) {
        arr.addLast(arr.removeFirst());
    }

    // 3번
    public static void sol3(Deque<Integer> arr) {
        arr.addFirst(arr.removeLast());
    }
}

//1. 첫 번째 원소 뽑기
//2. 뒤로 하나 밀기 (앞에꺼 -> 맨 뒤)
//3. 앞으로 하나 들여오기 (뒤에꺼 -> 맨앞)
// 2번, 3번 연산의 최솟값



// 10 3
// 2 9 5
//
//
// 1 2 3 4 5 6 7 8 9 10
// (2) 2 3 4 5 6 7 8 9 10 1 -> pop -> 3 4 5 6 7 8 9 10 1
// (3) 1 3 4 5 6 7 8 9 10
// (3) 10 1 3 4 5 6 7 8 9
// (3) 9 10 1 3 4 5 6 7 8 -> pop -> 10 1 3 4 5 6 7 8
//    ㅣ-- 5개---ㅣ--4개-ㅣ -> (3)만 4번


// 뽑을 원소의 위치의 앞과 뒤의 원소의 개수를 샘
// 작은 쪽으로 함(뒤가 작다면 (3) 반복, 앞이 작다면 (2) 반복
//