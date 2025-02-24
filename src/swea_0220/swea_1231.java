package swea_0220;

import java.util.Scanner;

public class swea_1231 {
    public static String[] strArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            for (int n = 1; n <= N; n++) {

            }
        }
    }
}

//입력받아야함
class Node{
    String word;
    int firstson;

    public Node(String word, int firstson) {
        this.word = word;
        this.firstson = firstson;
    }

    public Node(String word, int firstson, int secondson) {
        this.word = word;
        this.firstson = firstson;
        this.secondson = secondson;
    }

    int secondson;

}
