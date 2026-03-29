import java.io.*;
import java.math.*;
import java.util.*;

class Solution {
    static int R,C,count = 0;
    //variable to check whether we reached to target destination or not
    static boolean visited[][];
    static void dfs(int maze[][],int sr,int sc){

        //variables used to track the number of steps taken
        int r,c,rr,cc;
        //tracking whether position(i,j) is visited.initially all false.

        //North,south,east,west direction vectors
        int dr[] = {-1,+1,0,0};
        int dc[] = {0,0,+1,-1};
//        int dr[] = {-1,-1,-1,0,0,1,1,1};
//        int dc[] = {-1,0,1,-1,1,-1,0,1};
        //row stack and column stack
        Stack<Integer> rq = new Stack<>();
        Stack<Integer> cq = new Stack<>();

        //start dfs here
        rq.push(sr);
        cq.push(sc);
        visited[sr][sc] = true;
        while(rq.size()>0){//or cq.size()>0
            r = rq.pop();
            c = cq.pop();
//            if(maze[r][c] == 1000) {//say 1000 is the target
//                break;
//            }
            //explore neighbours
            for(int i=0;i<4;i++){
                rr = r + dr[i];
                cc = c + dc[i];

                if(rr<0||cc<0||rr>=R||cc>=C)continue;

                //skip visited positions
                if(visited[rr][cc])continue;
                //skip blocked positions
                if(maze[rr][cc] == -1)continue;

                rq.push(rr);
                cq.push(cc);
                visited[rr][cc] = true;
            }
        }
        count++;


    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        R = in.nextInt();
        C = in.nextInt();
        int maze[][] = new int[R][C];
        visited = new boolean[R][C];
        in.nextLine();
        for(int i = 0;i<R;i++){
            String s = in.nextLine();
            for(int j = 0;j<C;j++){
                maze[i][j] = (s.charAt(j) == '#')?-1:1;
            }
        }
        //start row and start column
        int sr;
        int sc;
        for (sr = 0;sr < R;sr++){
            for (sc = 0;sc < C;sc++){
                if(maze[sr][sc] == 1 && !visited[sr][sc]){
                    dfs(maze,sr,sc);
                }
            }
        }
        System.out.println(count);
    }

}






/*
Input:
5 8
########
#..#...#
####.#.#
#..#...#
########
  output:
3
 Explanation:
no of islands = 3
*/