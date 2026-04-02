import java.io.*;
import java.util.*;

public class entry_1144224 {
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    static Reader sc=new Reader();
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));




    public static void main(String[] args) throws IOException {
        Reader re = new Reader();
        int N = inputInt();
        int M = inputInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = inputInt();
            int v = inputInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] teams = new int[N+1];
        Arrays.fill(teams, 0);
        boolean[] visited = new boolean[N+1];
        boolean impossible = false;

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            if (impossible) break;
            int newTeam = 1;
            if (teams[i] == 0){
                teams[i] = 1;
                newTeam = 2;
            }
            else {
                newTeam = teams[i] == 1 ? 2 : 1;
            }
            impossible = dfs(i, graph, teams, newTeam, impossible, visited);
        }

        if(impossible) System.out.println("IMPOSSIBLE");
        else {
            for (int i = 1; i <= N; i++) {
                print(teams[i] + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, int[] teams, int newTeam, boolean imp, boolean[] visited){
        if (visited[node]){
            if(teams[node] != 0 && teams[node] != newTeam) imp = true;
            return imp;
        }
        visited[node] = true;
        teams[node] = newTeam;
        if (imp) return imp;
        for(int n: graph.get(node)){
            int next = newTeam == 1 ? 2 : 1;
            if(teams[n] != 0 && teams[n] != next){
                imp = true;
                return imp;
            }
            imp = dfs(n, graph, teams, next, imp, visited);
        }
        return imp;
    }

    public static int inputInt()throws IOException
    {
        return sc.nextInt();
    }
    public static long inputLong()throws IOException
    {
        return sc.nextLong();
    }
    public static double inputDouble()throws IOException
    {
        return sc.nextDouble();
    }
    public static String inputString()throws IOException
    {
        return sc.readLine();
    }
    public static void print(String a)throws IOException
    {
        bw.write(a);
    }
    public static void printSp(String a)throws IOException
    {
        bw.write(a+" ");
    }
    public static void println(String a)throws IOException
    {
        bw.write(a+"\n");
    }

}