//package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class entry_5463350 {
    static final int MN = 100010;
    static ArrayList<Integer>[] adj = new ArrayList[MN];
    static boolean[] visited = new boolean[MN], color = new boolean[MN];
    static FastIO io = new FastIO();
    static char[] str = new char[MN];
    static void DFS(int s, boolean colorSet){
        if(visited[s]){
            if(color[s] != colorSet){
                io.println("IMPOSSIBLE");
                io.close();
                System.exit(0);
            }
            return;
        }
        str[s] = colorSet ? '1' : '2';
        visited[s] = true;
        color[s] =  colorSet;
        for(int node:adj[s]){

            DFS(node, !colorSet);
        }
    }

    public static void main(String[] args) {
        int n = io.nextInt(), m = io.nextInt();
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            int a = io.nextInt() - 1, b = io.nextInt() - 1;
            adj[a].add(b);adj[b].add(a);
        }
        for(int i = 0; i < n; i++){
            if(!visited[i])
            DFS(i, true);
        }
        StringBuilder str1 = new StringBuilder();
        for(char charr:str){
            str1.append(charr).append(" ");
        }
        io.println(str1);
        io.close();
    }
}
class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar, numChars;

    // standard input
    public FastIO() {
        this(System.in, System.out);
    }

    public FastIO(InputStream i, OutputStream o) {
        super(o);
        stream = i;
    }

    // file input
    public FastIO(String i, String o) throws IOException {
        super(new FileWriter(o));
        stream = new FileInputStream(i);
    }

    // throws InputMismatchException() if previously detected end of file
    private int nextByte() {
        if (numChars == -1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars == -1) return -1; // end of file
        }
        return buf[curChar++];
    }

    // to read in entire lines, replace c <= ' '
    // with a function that checks whether c is a line break
    public String next() {
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = nextByte();
        } while (c > ' ');
        return res.toString();
    }

    public int nextInt() { // nextLong() would be implemented similarly
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = nextByte();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}