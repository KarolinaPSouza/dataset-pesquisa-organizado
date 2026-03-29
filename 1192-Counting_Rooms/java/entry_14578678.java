import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class entry_14578678 {
    static int[] dr ={1,-1,0,0};
    static int[] dc ={0,0,1,-1};
    static int n;
    static int m;
    static boolean[][] board;

    static void dfs(int row, int col) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{row, col});
        board[row][col] = true;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !board[nr][nc]) {
                    board[nr][nc] = true;
                    stack.push(new int[]{nr, nc});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        n = Integer.parseInt(first[0]);
        m = Integer.parseInt(first[1]);
        board = new boolean[n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                if(str.charAt(j)=='#') board[i][j]=true;
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(!board[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}