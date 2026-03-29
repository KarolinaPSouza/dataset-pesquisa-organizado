import java.util.*;

public class entry_14813956 {
    static void dfs(char mat[][],int r,int c){
        if(r>=mat.length || r<0 || c<0 || c>=mat[0].length || mat[r][c]!='.'){
            return;
        }
        mat[r][c]='#';
        dfs(mat,r,c+1);
        dfs(mat,r,c-1);
        dfs(mat,r+1,c);
        dfs(mat,r-1,c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char mat[][] = new char[R][C];
        for(int i=0;i<R;i++){
            String a = sc.next();
            for(int j=0;j<C;j++){
                mat[i][j] = a.charAt(j);
            }
        }
        int count = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][j]=='.'){
                    count++;
                    dfs(mat,i,j);
                }
            }
        }
        System.out.println(count);
    }
}