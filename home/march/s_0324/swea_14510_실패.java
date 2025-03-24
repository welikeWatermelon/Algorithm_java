package s_0324;

import java.util.ArrayList;
import java.util.Scanner;

public class swea_14510_실패 {
    public static int N,mxIdx,idx,day,sz;
    public static int mx;
    public static int[] tmp;
    public static ArrayList<Integer> arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out:
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            tmp = new int[N];
            arr = new ArrayList<>();
            mx = 0;
            for (int i = 0; i < N; i++) {
//                tmp[i] = Integer.parseInt(sc.next());
                tmp[i] = sc.nextInt();
                if(mx< tmp[i]) {
                    mx = tmp[i];
                    mxIdx = i;
                }
            }

            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (tmp[i] != mx) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.printf("#%d %d\n",t,0);
                continue out;
            }

            day = 0;
            idx = 0;
            for (int i = 0; i < N; i++) {
                if (tmp[i] < mx) {
                    arr.add(mx-tmp[i]);
                }
            }

            sz = arr.size();

            int twoNum = 0;
            // 홀수를 먼저 털어줘야함
            if (!odd()) { //홀수가 있으면 계속 진행
                for (int i = 0; i < sz; i++) {
                    if (arr.get(i) % 2 == 1) {
                        day += 2; //
                        twoNum++;
                        arr.set(i, arr.get(i) - 1);
                        if (arr.get(idx) == 0) {
                            idx++;
                        }
                    }
                }
                if (isZero()) { //홀수밖에 없는데 다 끝났을 때 ( 1 1 1 2 )
                    System.out.printf("#%d %d\n",t,day-1);

                    continue out;
                }
            }


            // 이제 다 짝수 되었음
            // 짝수 있는거 다 털어야함
            for (int i = 0; i < twoNum; i++) {
                if (isZero()) {
                    System.out.printf("#%d %d\n",t,day-(twoNum-i-2));
                    continue out;
                }
                while (arr.get(idx) == 0) {
                    idx++;
                }
                if(arr.get(idx)!=0) {
                    arr.set(idx, arr.get(idx) - 2);
                }
//                if (i == twoNum - 2 && isZero()) {
//                    System.out.printf("#%d %d\n",t,day-1);
//                    continue out;
//                }
            }

            if (isZero()) { // 여기에 다 털릴수도 있음
                System.out.printf("#%d %d\n",t,day);
                continue out;
            }
            boolean numOne = false;

            day++;
            // 현재 idx가 가리키는 곳은 0이 아닌 지점
//            while (!isZero()) {
                while (!isZero()) {
                    if(arr.get(idx)==0){
                        idx++; // 뺀 게 0이 되면 idx 늘려줘야함
                    }

                    if (day % 2 == 0) { // 짝수면
                        arr.set(idx, arr.get(idx) - 2);
                        if(isZero()) {
                            System.out.printf("#%d %d\n",t,day);
                            continue out;
                        }
                        day++;
                    } else if (day % 2 == 1) { // 홀수
                        if (numOne) { // + 홀수 두번째 날이면
                            arr.set(idx,arr.get(idx)-2);
                            if(isZero()) {
                                System.out.printf("#%d %d\n",t,day);
                                continue out;
                            }
                            numOne = false;
                            day++;
                        } else { // + 홀수 첫번째 날이면
                            numOne = true;
                            day++;
                        }
                    }

                }
//            }

            System.out.println(day);
        }
    }


    // 모두 다 자랐는지 검사하는거 -> 다 자라면 true
    public static boolean isZero(){
        for (int i = 0; i < sz; i++) {
            if (arr.get(i) != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean odd(){
        for (int i = 0; i < sz; i++) {
            if (arr.get(i) % 2 == 1) { //홀수
                return false;
            }
        }
        return true; //짝수
    }
}


// 홀수날은 1 자람
// 짝수날은 2 자람
// BFS로 한다