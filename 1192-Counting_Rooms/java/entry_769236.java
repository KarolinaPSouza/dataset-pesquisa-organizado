import java.io.*;
import java.util.*;

public class entry_769236 implements Runnable {
    static Random random;
    static boolean benchmark = false;
    static long timeStamp;

    public static void main(String[] args) {
        new Thread(null, new entry_769236(), "Main", 1<<28).start();
    }

    /* ------------------------------------- START -------------------------------------------- */
    static class Solver {
        static char grid[][];
        static int[] dx = new int[]{0, 0, 1, -1}, dy = new int[]{1, -1, 0, 0};
        static int n, m;

        public void solve(Scanner in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            in.nextLine();
            grid = new char[n][m];
            for(int i = 0; i<n; i++){
                String s = in.nextLine();
                for(int j = 0; j<m; j++)
                    grid[i][j] = s.charAt(j);
            }

            int cnt = 0;
            for(int x = 0; x < grid.length; x++){
                for(int y = 0; y<grid[x].length; y++){
                    if(grid[x][y] == '.') {
                        dfs(x, y);
                        cnt++;
                    }
                }
            }
            out.println(cnt);
        }

        private void dfs(int x, int y) {
            grid[x][y] = '#';

            if(x > 0     && grid[x-1][y] == '.') dfs(x-1, y);
            if(y > 0     && grid[x][y-1] == '.') dfs(x, y-1);
            if(x < n - 1 && grid[x+1][y] == '.') dfs(x+1, y);
            if(y < m - 1 && grid[x][y+1] == '.') dfs(x, y+1);
        }
    }
    /* -------------------------------------- END --------------------------------------------- */

    /* Shuffle function to shuffle before Arrays.sort */
    static void shuffle(int[] arr){
        int swapTemp;
        for(int i = arr.length-1; i>= 1; i--){
            int pos = random.nextInt(i+1);
            if(pos == i) continue;
            {swapTemp = arr[i]; arr[i] = arr[pos]; arr[pos] = swapTemp;}
        }
    }

    /* Fast Input reader */
    static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StringTokenizer("");
        }

        String next() {
            while (!tokenizer.hasMoreTokens()) {
                try{
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine() {
            String string = "";
            try {
                string = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return string;
        }
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        //FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        random = new Random();

        if(benchmark) timeStamp = System.currentTimeMillis();
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
        if(benchmark) System.err.println("\033[0;31m"+(System.currentTimeMillis()-timeStamp)+" ms"+"\033[0m");
    }

}