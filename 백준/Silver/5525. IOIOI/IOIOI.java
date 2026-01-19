import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int M = sc.nextInt(); 
        char[] S = sc.next().toCharArray();

        int result = 0;
        int patternCount = 0; 

        for (int i = 1; i < M - 1; i++) {
            if (S[i - 1] == 'I' && S[i] == 'O' && S[i + 1] == 'I') {
                patternCount++;

                if (patternCount >= N) {
                    result++;
                }

                i++;
            } else {
                patternCount = 0;
            }
        }

        System.out.println(result);
    }
}