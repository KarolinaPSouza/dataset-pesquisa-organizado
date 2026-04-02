//package Graph;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class entry_10508073 {
    public static void main(String[] args) throws IOException {
        Reader fr = new Reader();
        int n=fr.nextInt(),m=fr.nextInt();

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int x=fr.nextInt(),y=fr.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        boolean[] visited=new boolean[n+1];
        int[] par=new int[n+1];
        Arrays.fill(par, -1);
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;
        while (q.size()>0) {
            int cur=q.peek();
            q.poll();
            if(cur==n)break;
            for(int child:adj.get(cur)){
                if(visited[child]==false){
                    q.add(child);
                    visited[child]=true;
                    par[child]=cur;
                }
            }

        }

        if(par[n]==-1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            List<Integer> path=new ArrayList<>();
            int cur=n;
            while(par[cur]!=-1){
                path.add(cur);
                cur=par[cur];
            }
            path.add(1);
            System.out.println(path.size());
            StringBuilder sb=new StringBuilder();
            for(int i=path.size()-1;i>=0;i--){
                sb.append(path.get(i).toString()+" ");
            }
            System.out.println(sb.toString());
        }

    }





        static class Reader { final private int BUFFER_SIZE = 1 << 16; private DataInputStream din; private byte[] buffer; private int bufferPointer, bytesRead; public Reader() { din = new DataInputStream(System.in); buffer = new byte[BUFFER_SIZE]; bufferPointer = bytesRead = 0; } public Reader(String file_name) throws IOException { din = new DataInputStream( new FileInputStream(file_name)); buffer = new byte[BUFFER_SIZE]; bufferPointer = bytesRead = 0; } public String readLine() throws IOException { byte[] buf = new byte[64]; int cnt = 0, c; while ((c = read()) != -1) { if (c == '\n') { if (cnt != 0) { break; } else { continue; } } buf[cnt++] = (byte)c; } return new String(buf, 0, cnt); } public int nextInt() throws IOException { int ret = 0; byte c = read(); while (c <= ' ') { c = read(); } boolean neg = (c == '-'); if (neg) c = read(); do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9'); if (neg) return -ret; return ret; } public long nextLong() throws IOException { long ret = 0; byte c = read(); while (c <= ' ') c = read(); boolean neg = (c == '-'); if (neg) c = read(); do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9'); if (neg) return -ret; return ret; } public double nextDouble() throws IOException { double ret = 0, div = 1; byte c = read(); while (c <= ' ') c = read(); boolean neg = (c == '-'); if (neg) c = read(); do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9'); if (c == '.') { while ((c = read()) >= '0' && c <= '9') { ret += (c - '0') / (div *= 10); } } if (neg) return -ret; return ret; } private void fillBuffer() throws IOException { bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); if (bytesRead == -1) buffer[0] = -1; } private byte read() throws IOException { if (bufferPointer == bytesRead) fillBuffer(); return buffer[bufferPointer++]; } public void close() throws IOException { if (din == null) return; din.close(); } }

}