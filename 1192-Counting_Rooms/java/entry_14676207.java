import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_14676207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read first line containing n and m
        String[] dims = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(dims[0]);
        int m = Integer.parseInt(dims[1]);

        char[][] arr = new char[n][m];

        // Read n lines of grid
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            arr[i] = line.toCharArray(); // Each line should have exactly m characters
        }

        int total_rooms = calculate_total_rooms(arr, n, m);
        System.out.println(total_rooms);
    }

    public static int calculate_total_rooms(char arr[][],int n,int m){
        int rooms = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='.'){
                    rooms++;
                    dfs(arr,i,j);
                }
            }
        }
        return rooms;
    }

    private static void dfs(char arr[][],int i,int j){
         if(i<0 || i>=arr.length || j<0 || j>= arr[0].length) return;
         if(arr[i][j]=='#') return;

         arr[i][j]='#';

         dfs(arr,i+1,j);
         dfs(arr,i-1,j);
         dfs(arr,i,j+1);
         dfs(arr,i,j-1);
    }

}