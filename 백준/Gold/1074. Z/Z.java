import java.util.Scanner;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int size = (int) Math.pow(2, n);
        
        solve(size, r, c);
        System.out.println(count);
    }

    static void solve(int size, int r, int c) {
        if (size == 1) return;

        int half = size / 2;
        int area = half * half;

        if (r < half && c < half) {
            solve(half, r, c);
        } else if (r < half && c >= half) {
            count += area;
            solve(half, r, c - half);
        } else if (r >= half && c < half) {
            count += area * 2;
            solve(half, r - half, c);
        } else {
            count += area * 3;
            solve(half, r - half, c - half);
        }
    }
}