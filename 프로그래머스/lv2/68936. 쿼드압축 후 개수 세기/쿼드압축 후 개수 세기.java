class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        zip(arr, 0, 0, arr.length);

        return answer;
    }
    
     private  void zip(int[][] arr, int sx, int sy, int size) {

        if (check(arr, sx, sy, size) || size == 1) {
            answer[arr[sy][sx]]++;
            return;
        }

        int middle = size / 2;

        zip(arr, sx, sy, middle);
        zip(arr, sx, sy + middle, middle);
        zip(arr, sx + middle, sy, middle);
        zip(arr, sx + middle, sy + middle, middle);
    }

    private  boolean check(int[][] arr, int sx, int sy, int size) {

        int num = arr[sy][sx];

        for (int y = sy; y < sy + size; y++) {
            for (int x = sx; x < sx + size; x++) {
                if (num != arr[y][x])
                    return false;
            }
        }

        return true;
    }
}