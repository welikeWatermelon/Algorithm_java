package swea_0308;

import java.util.Scanner;

public class swea_6808 {
    public static int[] in;
    public static int[] gyu;

    public static boolean[] checked;
    public static int gyuWin;
    public static int inWin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            gyuWin = 0;
            inWin = 0;
            checked= new boolean[9];
            gyu = new int[9];
            boolean[] gyuChecked = new boolean[19];

            for (int i = 0; i < 9; i++) {
                gyu[i] = sc.nextInt(); //규영이 카드는 고정
                gyuChecked[gyu[i]]=true;
            }

            //인영이 카드 만들기
            in = new int[9]; //0번 인덱스는 무시될것임 (숫자카드가 1부터 시작하니까)
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!gyuChecked[i]) {
                    in[idx++] = i;
                }
            }

            inyoung(new int[9], 0);

            System.out.printf("#%d %d %d\n",t,gyuWin,inWin); //총 경기수에서 빼도되긴함

        }
    }

    // list의 조합을 만들어야함
    public static void inyoung(int[] tmpArr, int depth) {
        if (depth == 9) {
            winner(tmpArr); //한번 실행하면 이 코드가 조건에 해당하는 숫자를 계속 만들어내면서 winner 함수를 불러올 것임
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!checked[i]) {
                checked[i]=true;
                tmpArr[depth] = in[i];
                inyoung(tmpArr,depth + 1);
                checked[i]=false;
            }
        }
    }

    //누가 이기는지 T/F로 반환
    public static void winner(int[] arr) { //arr는 인영이 카드가 들어갈 것임
        int inScore=0;
        int gyuScore=0;

        for (int i = 0; i < 9; i++) {
            if (arr[i] > gyu[i]) {
                inScore += arr[i] + gyu[i];
            } else {
                gyuScore += arr[i] + gyu[i];
            }
        }

        if (inScore > gyuScore) {
            inWin++;
        } else {
            gyuWin++;
        }

    }
}
