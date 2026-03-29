import java.lang.*;
import java.util.*;

public class entry_15993694 {
    public static void put(int i, int j, ArrayDeque<int[]> st, char[][] input, int [][]mark) {
        int n = input.length, m = input[0].length;
        mark[i][j] = 1;
        if(i + 1 < n && mark[i + 1][j] == 0 && input[i + 1][j] == '.') {
            st.push(new int[]{i + 1, j});
        }
        if(j + 1 < m && mark[i][j + 1] == 0 && input[i][j + 1] == '.') {
            st.push(new int[]{i, j + 1});
        }
        if(i - 1 >= 0 && mark[i - 1][j] == 0 && input[i - 1][j] == '.') {
            st.push(new int[]{i - 1, j});
        }
        if(j - 1 >= 0 && mark[i][j - 1] == 0 && input[i][j - 1] == '.') {
            st.push(new int[]{i, j - 1});
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char [][] input = new char[n][m];
        for(int i = 0; i < n; i++) {
            String row = sc.next();
            for(int j = 0; j < m; j++) {
                input[i][j] = row.charAt(j);
            }
        }
        int ans = 0;
        int [][]mark = new int[n][m];
        ArrayDeque<int[]> st = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((input[i][j] == '.') && mark[i][j] == 0) {
                    ans ++;
                    int []neww = new int [2];
                    neww[0] = i;
                    neww[1] = j;
                    st.push(neww);
                    while(!st.isEmpty()) {
                        int[] curr = st.getFirst();
                        st.pop();
                        mark[curr[0]][curr[1]] = 1;
                        put(curr[0], curr[1], st, input, mark);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}