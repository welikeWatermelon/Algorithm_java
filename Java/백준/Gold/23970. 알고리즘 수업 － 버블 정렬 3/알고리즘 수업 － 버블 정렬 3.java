
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arr2 = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(stk.nextToken());
        }

        int targetHash = Arrays.hashCode(arr2);

        if( Arrays.hashCode(arr) == targetHash)
        {
        	System.out.println(1);
        	return;
        }
        
        for(int i=0; i<N-1; i++){
            boolean swapped = true;

            for (int j = 0; j < N - 1 - i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped=false;
                    if ( arr[j] == arr2[j] && arr[j+1] == arr2[j+1] && Arrays.hashCode(arr) == targetHash) {
                        System.out.println(1);
                        return;
                    }
                }
            }
            if(swapped) break;
        }

        System.out.println(0);
    }
}