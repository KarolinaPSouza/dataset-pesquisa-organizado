import java.util.*;
public class entry_14813579 {
    public static int diff[][]={{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt();
        int C=sc.nextInt();
        sc.nextLine();
        char grid[][]=new char[R][C];
        for(int i=0;i<R;i++){
            String str=sc.nextLine();
            for(int j=0;j<C;j++){
                grid[i][j]=str.charAt(j);
            }
        }
        int count=0;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]=='.'){
                    count++;
                    changewall(grid,row,col,R,C);
                }
            }
        }
        System.out.println(count);
    }
    public static void changewall(char[][]grid,int row,int col,int R,int C){
        Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{row, col});

    while (!stack.isEmpty()) {
        int[] curr = stack.pop();
        int r = curr[0];
        int c = curr[1];
        if (r < 0 || r >= R || c < 0 || c >= C) continue;
        if (grid[r][c] == '.') {
            grid[r][c] = '#';
            for (int[] dir : diff) {
                int adjR = r + dir[0];
                int adjC = c + dir[1];
                stack.push(new int[]{adjR, adjC});
            }
        }
    }
    }
} 