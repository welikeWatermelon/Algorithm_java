import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int[] parent;
    public static int[] countChild;
    public static int F;
    public static void main(String[] args) {
        // 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 문자열로 들어오는 애를 어떻게 숫자로 분리할까
        // key-value = 문자열-index 로 하자\
        for (int t = 0; t < T; t++) {

            HashMap<String, Integer> hashMap = new HashMap<>();
            int idx = 0;

            F = sc.nextInt();
            parent = new int[2*F+1];
            countChild = new int[2 * F + 1];
            for (int i = 1; i <= 2 * F; i++) {
                parent[i] = i;
                countChild[i] = 1;
            }

            for (int i = 1; i <= 2*F; i++) {
                parent[i] = i;
            }

            for (int j = 0; j < F; j++) {
                String firstName = sc.next();
                String secondName = sc.next();

                // 이름이 없으면 넣어줌
                if (!hashMap.containsKey(firstName)) {
                    idx++;
                    hashMap.put(firstName, idx);
                }

                if (!hashMap.containsKey(secondName)) {
                    idx++;
                    hashMap.put(secondName, idx);
                }

                int firstIdx = hashMap.get(firstName);
                int secondIdx = hashMap.get(secondName);

                union(firstIdx, secondIdx);

                System.out.println(countChild[find(firstIdx)]);
            }
        }


    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX != parentY) {
            parent[parentY] = parentX;
            countChild[parentX] += countChild[parentY];
        }
    }

}
