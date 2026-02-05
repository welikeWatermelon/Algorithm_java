import java.util.*;
import java.io.*;

public class Main { 
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int N = Integer.parseInt(line);

        map = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        drawStar(0, N - 1, N);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(map[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void drawStar(int r, int c, int n) {
        if (n == 3) {
            map[r][c] = '*';
            map[r + 1][c - 1] = map[r + 1][c + 1] = '*';
            map[r + 2][c - 2] = map[r + 2][c - 1] = map[r + 2][c] = map[r + 2][c + 1] = map[r + 2][c + 2] = '*';
            return;
        }

        int size = n / 2;
        drawStar(r, c, size);               // 위
        drawStar(r + size, c - size, size); // 아왼
        drawStar(r + size, c + size, size); // 아오
    }
}