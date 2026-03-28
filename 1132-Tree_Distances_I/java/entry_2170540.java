import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class entry_2170540 {
    static class Reader {
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
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

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
            } while ((c = read()) >= '0' && c <= '9');
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
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
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
    public static void main(String args[]) throws IOException {
        Reader sc=new Reader();
        long mod=1000000007l;
        int n=sc.nextInt();
        ArrayList<Integer>[] l=new ArrayList[n];
        for(int j=0;j<n;j++)
        {
            l[j]=new ArrayList<>();
        }

        int end1=0;
        int end2=0;
        int arr[]=new int[n];
        for(int j=0;j<n-1;j++)
        {
            int x=sc.nextInt()-1;
            int y=sc.nextInt()-1;
            arr[x]++;
            arr[y]++;
            l[x].add(y);
            l[y].add(x);
        }


        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        queue.add(0);
        int dis[]=new int[n];
        boolean touch[]=new boolean[n];
        while (queue.isEmpty()==false)
        {
            int x=queue.poll();
            int y=queue.poll();
            touch[x]=true;
            dis[x]=y;
            for(int j=0;j<l[x].size();j++)
            {
                if(touch[l[x].get(j)]==false)
                {
                    queue.add(l[x].get(j));
                    queue.add(y+1);
                }
            }
        }
        int maxf=0;
        for(int j=0;j<n;j++)
        {
            if(dis[j]>maxf)
            {
                end1=j;
                maxf=dis[j];
                //break;
            }
        }

        queue.add(end1);
        queue.add(0);
        dis=new int[n];
        touch=new boolean[n];
        while (queue.isEmpty()==false)
        {
            int x=queue.poll();
            int y=queue.poll();
            touch[x]=true;
            dis[x]=y;
            for(int j=0;j<l[x].size();j++)
            {
                if(touch[l[x].get(j)]==false)
                {
                    queue.add(l[x].get(j));
                    queue.add(y+1);
                }
            }
        }
        int max=0;

        for(int j=0;j<n;j++)
        {
            if(dis[j]>max)
            {
                end2=j;
                max=dis[j];
            }
        }

        int dis2[]=new int[n];
        queue.add(end2);
        queue.add(0);
        boolean touch2[]=new boolean[n];
        while (queue.isEmpty()==false)
        {
            int x=queue.poll();
            int y=queue.poll();
            touch2[x]=true;
            dis2[x]=y;
            for(int j=0;j<l[x].size();j++)
            {
                if(touch2[l[x].get(j)]==false)
                {
                    queue.add(l[x].get(j));
                    queue.add(y+1);
                }
            }
        }

        StringBuilder ans=new StringBuilder();
        for(int j=0;j<n;j++)
        {
            ans.append(Math.max(dis[j],dis2[j])+" ");

        }
        System.out.println(ans);



    }
}