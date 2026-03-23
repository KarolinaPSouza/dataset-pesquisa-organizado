import java.io.*;
import java.util.*;

public class entry_730831 {
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    /* Implement Solution Here */
    static class Solver {
        public void solve(FastScanner in, PrintWriter out){
            int tc = in.nextInt();
            for(int caseNum = 1; caseNum <= tc; caseNum++){
                solveOne(caseNum, in, out);
            }
        }

        void solveOne(int caseNum, FastScanner in, PrintWriter out) {
            long row = in.nextLong();
            long col = in.nextLong();
            long level = Math.max(row, col);
            long number = 0;
            if(row == level) 
                number += col;
            else 
                number += level + level-row;

            if(level % 2 == 0){
                number = level*level+1 - number;
            }
            else{
                number = (level-1) * (level-1) + number;
            }
            out.println(number);
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
}