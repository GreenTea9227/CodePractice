import java.util.*;
class Solution {
      int[] nx = new int[]{0,1,0,-1};
     int[] ny = new int[]{1,0,-1,0};
     int[][] arr;
      List<Integer> list = new ArrayList<>();
    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        int index = 1;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns;j++) {
                arr[i][j] = index++;
            }
        }


        for (int[] query : queries) {
            rotate(query[0]-1,query[1]-1,query[2]-1,query[3]-1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private  void rotate(int y1,int x1, int y2, int x2) {

        int cx = x1;
        int cy = y1;

        int num = arr[cy][cx];

        int check = num;
        int index = 0;
        while(index < 4) {

            if(cx + nx[index] >= x1 && cx + nx[index] <= x2 && cy + ny[index] >= y1 && cy + ny[index] <= y2) {
                arr[cy][cx] = arr[cy + ny[index]][cx + nx[index]];
                if (check > arr[cy][cx]) {
                    check = arr[cy][cx];
                }
                cx = cx + nx[index];
                cy = cy + ny[index];

            } else {
                index++;
            }
        }
        arr[cy][cx+1] = num;
        list.add(check);
    }
}