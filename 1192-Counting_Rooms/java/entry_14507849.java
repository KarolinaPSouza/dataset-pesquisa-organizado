import java.util.*;
public class entry_14507849 {

    public static void solve(char[][] mat, int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        mat[i][j] = '#';
        while (q.size()>0) { 
            int[] curr = q.poll();
            int idx1 = curr[0];
            int idx2 = curr[1];
            if (idx1-1>=0 && mat[idx1-1][idx2]!='#'){
                mat[idx1-1][idx2] = '#';
                q.add(new int[]{idx1-1, idx2});
            }
            if (idx1+1<mat.length && mat[idx1+1][idx2]!='#'){
                mat[idx1+1][idx2] = '#';
                q.add(new int[]{idx1+1, idx2});
            }
            if (idx2-1>=0  && mat[idx1][idx2-1]!='#'){
                mat[idx1][idx2-1] = '#';
                q.add(new int[]{idx1, idx2-1});
            }
            if ( idx2+1<mat[0].length && mat[idx1][idx2+1]!='#'){
                mat[idx1][idx2+1] = '#';
                q.add(new int[]{idx1, idx2+1});
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] mat = new char[n][m];
        for(int i=0;i<n;i++){
            String str = sc.nextLine();
            for (int j=0;j<m;j++) {
                mat[i][j] = str.charAt(j);
            }
        }

        long count= 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (mat[i][j] == '.'){
                    count++;
                    solve(mat, i, j);
                }
            }
        }
        System.out.println(count);
    }
}