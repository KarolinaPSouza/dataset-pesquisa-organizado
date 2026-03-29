import java.util.*;
public class entry_2227015 {
    private static char[][]arr;
    private static int[] yc = {-1,1,0,0};
    private static int[] xc =  {0,0,-1,1};
    private static int count = 0;private static Queue<int[]> q = new LinkedList<>();
    public static void fill(int x, int y) {
        arr[x][y]='#';
        int[]asdfasdf={x,y};
        q.add(asdfasdf);
        while (!q.isEmpty()) {
          // System.out.println(q);
            int[]cur = q.poll();

            for (int i = 0; i < 4; i++) {
                try {
                    if (arr[cur[0] + xc[i]][cur[1] + yc[i]] == '.') {int[] temp =new int []{cur[0]+xc[i],cur[1]+yc[i]};
                    arr[cur[0]+xc[i]][cur[1]+yc[i]]='#'    ;
                    q.add(temp);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a= in.nextInt(); int b = in.nextInt();
        arr= new char[a][b];
        for (int i=0;i<a;i++){
            arr[i]=in.next().toCharArray();
        }
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){
                if (arr[i][j]=='.'){count++;fill(i,j);}
            }
        }System.out.println(count);
    }
}