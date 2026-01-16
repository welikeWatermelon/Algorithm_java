import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int blue = 0;
    public static int white = 0;
    public static int[][] board;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        cutting(0,0,N);
        
        System.out.println(white);
        System.out.println(blue);

    }

    public static void cutting(int row, int cal, int size) {
        if (checkColor(row, cal, size)) {
            if (board[row][cal] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        cutting(row + size / 2, cal + size / 2, size / 2);
        cutting(row + size / 2, cal, size / 2);
        cutting(row, cal + size / 2, size / 2);
        cutting(row, cal, size / 2);
    }

    public static boolean checkColor(int row, int cal, int size) {
        int nowColor = board[row][cal];
        
        for (int i = row; i < row + size; i++) {
            for (int j = cal; j < cal + size; j++) {
                if (board[i][j] != nowColor) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
