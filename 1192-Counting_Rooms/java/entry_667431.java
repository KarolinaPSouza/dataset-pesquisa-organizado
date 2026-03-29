//code written by a living bruh moment
import java.io.*;
import java.lang.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class entry_667431 {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] grid = new char[n][m];
        for(int i = 0; i<n; i++){
            String s = in.next();
            for(int j = 0; j<m; j++){
                grid[i][j] = s.charAt(j);
            }
        }
        int rooms = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '.'){
                    floodfill(i,j,grid);
                    ++rooms;
                }
            }
        }
        out.print(rooms);
        out.close();
    }
    public static void floodfill(int i, int j, char[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(grid[i][j] != '.'){
            return;
        }
        grid[i][j] = '#';
        floodfill(i+1, j , grid);
        floodfill(i-1, j , grid);
        floodfill(i, j+1 , grid);
        floodfill(i, j-1 , grid);
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong()
        {
            return Long.parseLong(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }
        public String nextLine()
        {
            try
            {
                return reader.readLine();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
        public boolean hasNext()
        {
            String next=null;
            try
            {
                next=reader.readLine();
            }
            catch(Exception e)
            {
            }
            if(next==null)
            {
                return false;
            }
            tokenizer=new StringTokenizer(next);
            return true;
        }
    }
}