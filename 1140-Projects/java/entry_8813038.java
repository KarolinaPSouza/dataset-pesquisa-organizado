import java.util.*;
import java.io.*;

public class entry_8813038 {
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

    public static void main(String [] args) throws Exception
    {
        //FileInputStream file = new FileInputStream("entry_8813038-t10.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(file));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        Reader s = new Reader();
        //int n = Integer.parseInt(st.nextToken());
        int n = s.nextInt();

        ArrayList<Project> proj = new ArrayList<Project>();

        for (int i = 0; i < n; i++)
        {
            //st = new StringTokenizer(br.readLine());
            //proj.add(new Project(Integer.parseInt(st.nextToken())
            //, Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
            proj.add(new Project(s.nextInt(), s.nextInt(), s.nextLong()));

        }

        Collections.sort(proj);

        TreeMap<Integer, Long> dp = new TreeMap<Integer, Long>();
        dp.put(-1, 0L);
        dp.put(proj.get(0).e, proj.get(0).m);

        for (int i = 1; i < n; i++)
        {
            Project tmp = proj.get(i);
            dp.put(tmp.e, Math.max(dp.get(dp.lastKey()), tmp.m + dp.get(dp.lowerKey(tmp.s))));
        }

        System.out.print(dp.get(dp.lastKey()));
    }
}

class Project implements Comparable<Project>
{
    int s, e;
    long m;

    public Project(int start, int end, long money)
    {
        s = start;
        e = end;
        m = money;
    }

    public int compareTo(Project p)
    {
        return Integer.compare(e, p.e);
    }
}