//package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class entry_2131484 {
    private static final entry_2131484.InputReader console = new InputReader();
    private static List<List<Integer>> adj;
    static int loop = 0;
    static int sv = 0;
    static int ev = 0;

    public static void main(String[] args) throws IOException {

        adj = new ArrayList<>() ;
        int n = console.nextInt();
        int m = console.nextInt();
        boolean[] vis = new boolean[n];
        ArrayList cycle = new ArrayList();
        ArrayList sc = new ArrayList();
        int parent = 0;
        int[] parentArr = new int[n];


        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = console.nextInt() - 1;
            int d = console.nextInt() - 1;
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        if (!exist(parentArr, vis, parent, n)) {
            System.out.println("IMPOSSIBLE");
        } else {
            sc.add(ev);
            int tv = ev;
            while (tv != sv) {
                    sc.add(parentArr[tv]);
                    tv = parentArr[tv];
            }
            sc.add(ev);
            System.out.println(sc.size());
            for (int i = sc.size() - 1; i > -1; i--) {
                System.out.print((int) sc.get(i) + 1 +  " ");
            }
        }
    }
    public static boolean exist(int[] parentArr,boolean[] vis, int parent, int n) {
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                parent = -1;
                boolean isValid = CheckCycleUsingDFS(parentArr,vis, i, parent);
                if (!isValid) return true;
            }
        }
        return false;
    }
    public static boolean CheckCycleUsingDFS(int[] parentArr, boolean[] vis, int i, int parent) {
        vis[i] = true;
        parentArr[i] = parent;
        for (int child:adj.get(i)) {
            if (!vis[child]) {
                if (CheckCycleUsingDFS(parentArr, vis, child, i) == false) return false;
            }
            else {
                if (child != parent){
                    sv = child;
                    ev = i;
                    return false;
                }
            }
        }
        return true;
    }

    static final class InputReader {
        private final int BUFFER_SIZE = 1 << 24;

        private final DataInputStream in = new DataInputStream(System.in);
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private final byte[] buf = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;

        private void fillBuffer() throws IOException {
            bytesRead = in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public String next() throws IOException {
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c < 33) {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String nextLine() throws IOException {
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\r' || c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            return (int) nextLong();
        }

        public long nextLong() throws IOException {
            long ret = 0L, c = read();
            while (c < 33L) {
                c = read();
            }
            boolean neg = (c == 45L);
            if (neg) {
                c = read();
            }
            do {
                ret = (ret << 3) + (ret << 1) + c - 48L;
            } while ((c = read()) > 47 && c < 58);
            return (neg ? -ret : ret);
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public void close() throws IOException {
            in.close();
        }
    }
}


