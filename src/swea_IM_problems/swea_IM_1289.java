package swea_IM_problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class swea_IM_1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= T; t++) {
            String binaryStr = sc.next();
            char[] binary = new char[binaryStr.length()];
            for (int i = 0; i < binaryStr.length(); i++) {
                binary[i] = binaryStr.charAt(i);
            }

            int cnt = 0;
            for (int i = 0; i < binaryStr.length(); i++) {
                if(binary[i]=='1'){
                    for (int j = i; j < binaryStr.length(); j++) {
                        if (binary[j] == '1') {
                            binary[j] = '0';

                        }else{
                            binary[j] = '1';
                        }
                    }
                    cnt++;
                }

                if(new BigInteger(new String(binary)).equals(BigInteger.ZERO)){ //정수(BigInteger)로 변환
                    break;
                }
            }

            System.out.printf("#%d %d\n",t,cnt);
        }
    }
}
