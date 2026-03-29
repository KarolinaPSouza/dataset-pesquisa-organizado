import java.util.*;
public class entry_14813866 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char[][] matrix=new char[m][n];
        for(int index=0;index<m;index++){
            String s=sc.next().trim();
            for(int j=0;j<n;j++){
                matrix[index][j]=s.charAt(j);
            }
        }

    boolean[][] visited=new boolean[m][n];
    int[][] adj=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        long count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='.'&&!visited[i][j]){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});

                    while(!q.isEmpty()){
                        int[] qce=q.poll();
                        for(int adji=0;adji<4;adji++){
                        int adjr= qce[0]+ adj[adji][0];
                        int adjc=qce[1]+adj[adji][1];
                        if(adjr>=0&&adjc>=0&&adjr<m&&adjc<n&&!visited[adjr][adjc]){
                            if(matrix[adjr][adjc]=='.'){
                                q.offer(new int[]{adjr,adjc});
                                visited[adjr][adjc]=true;

                            }

                        }

                    }
                }
                count++;
                }
            }
        }
        System.out.print(count);
    }

}