class Solution {
        public static int[] solution(int[] array, int[][] commands) {
        int N = commands.length;
        int[] answer = new int[N];
        for (int s = 0; s < N; s++) {
            int[] arr = commands[s];
            int i = arr[0]-1; //시작
            int j = arr[1]-1; //끝
            int k = arr[2]-1;
            int[] newNum = new int[j - i + 1];
            int idx = 0;
            for (int t = i; t <= j; t++) {
                newNum[idx++] = array[t];
            }
            int[] tmp = new int[j - i + 1];
            //이제 정렬하면 됨
            mergeSort(newNum, tmp, 0, j - i);
            answer[s] = newNum[k];
        }

        return answer;
    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid+1, end);
            merge(arr,tmp,start,mid,end); //두개로 나뉘어 있는 배열을 합쳐줌

        }
    }

    // arr : 정렬된 결과를 반복적으로 저장하고 있는 배열의 포인터
    public static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start; // 결과 배열방의 어디에 저장해야할지 기억해야함
        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1++];
            } else {
                arr[index] = tmp[part2++];
            }
            index++;
        }

        //앞쪽 배열이 남았다면 털어주기
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }

        //뒤쪽 배열이 남아있다면, 신경 안써도됨
        // -> 뒤쪽 배열은 최종 배열 뒤쪽에 자리하고 있기 때문에 신경 안써도 됨

    }
}