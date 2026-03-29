import java.util.*;

public class entry_13807941 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        char grid[][]=new char[n][m];
        for(int i=0;i<n;i++){
            String s=sc.next();
            for(int j=0;j<m;j++){
                grid[i][j]=s.charAt(j);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='.'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);


    }
    public static void bfs(char grid[][],int i,int j){
        int n=grid.length,m=grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]!='.'){
            return;
        }

        grid[i][j]='&';
        bfs(grid,i+1,j);
        bfs(grid,i-1,j);
        bfs(grid,i,j+1);
        bfs(grid,i,j-1);
    }
}