package swea_0221;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swea_2930 {
    static int heapSize;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            heapSize = 0;
            int N = Integer.parseInt(sc.nextLine()); //수행해야 하는 연산의 수
            int[] heap = new int[N * 16];
            ArrayList<Integer> answer = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] cal = sc.nextLine().split(" ");
                if (cal[0].equals("1")) { //삽입
                    add(heap, Integer.parseInt(cal[1]));
                } else { //삭제
                    //만약 pop 할게 없을 경우 -1을 출력해야함
                    int popNum=pop(heap);
                    answer.add(popNum);
                }
            }
            System.out.printf("#%d", t);
            for (Integer i : answer) {
                System.out.printf(" %d",i);
            }
            System.out.println();
        }
    }

    public static void add(int[] heap, int addNum){

        heap[++heapSize] = addNum;

        int ch = heapSize;
        int p = ch / 2; //버림이 필요한데, 정수형이라 버려짐

        //올릴 수 있으면 올라가야함 (자식이 크면 올라가야함)
        while(p>0 && heap[p]<heap[ch]){
            //swap
            int tmp = heap[p];
            heap[p] = heap[ch];
            heap[ch] = tmp;

            ch = p;
            p = ch/2;
        }
    } // heapPush

    public static int pop(int[] heap) {
        //힙이 공백이면 안됨
        if (heapSize == 0) {
            return -1; //-1보다 에러처리가 제일 좋음 (주어지는 값이 어디 범위인지를 보고 판단)
        }
        int item = heap[1]; //루트노드의 값을 저장해놓았다
        //막내를 수장의 자리에 올려 놓는다.
        heap[1] = heap[heapSize--];
        int p = 1;
        int ch = p * 2; //왼자 셋팅
        if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) { //오자가 있다면 + 오자가 왼자보다 더 높은 값이라면
            ch+=1; //오자로 교환
        }

        //내려갈 수 있으면 내려가
        while (ch <= heapSize && heap[p] < heap[ch]) {
            int tmp = heap[p];
            heap[p] = heap[ch];
            heap[ch] = tmp;

            p = ch;
            ch = p*2; //왼자 세팅
            if (ch + 1 <= heapSize && heap[ch] < heap[ch+1]) {
                ch+=1; //오자로 교환
            }
        }
        return item;
    }
}
