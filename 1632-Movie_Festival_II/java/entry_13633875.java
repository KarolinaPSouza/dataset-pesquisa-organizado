import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

class fastio {
    private final InputStream in;
    private final PrintWriter out;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, buflen = 0;

    public fastio() {
        in = System.in;
        out = new PrintWriter(System.out);
    }

    private int read() throws IOException {
        if (ptr >= buflen) {
            ptr = 0;
            buflen = in.read(buffer);
            if (buflen <= 0) return -1;
        }
        return buffer[ptr++];
    }

    public int nextInt() throws IOException {
        int c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        int x = 0;
        while (c >= '0' && c <= '9') {
            x = x * 10 + (c - '0');
            c = read();
        }
        return neg ? -x : x;
    }

    public long nextLong() throws IOException {
        int c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        long x = 0;
        while (c >= '0' && c <= '9') {
            x = x * 10 + (c - '0');
            c = read();
        }
        return neg ? -x : x;
    }

    public String next() throws IOException {
        int c = read();
        while (c <= ' ') c = read();
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
            c = read();
        } while (c > ' ');
        return sb.toString();
    }

    public String nextLine() throws IOException {
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = read()) != -1 && c != '\n') {
            sb.append((char) c);
        }
        return sb.toString();
    }

    public void print(Object o) {
        out.print(o);
    }

    public void println(Object o) {
        out.println(o);
    }

    public void flush() {
        out.flush();
    }

    public void close() {
        out.close();
    }

    public char nextChar() throws IOException {
        int c = read();
        while (c <= ' ') c = read(); // skip whitespace
        return (char) c;
    }

    public double nextDouble() throws IOException {
        int c = read();
        while (c <= ' ') c = read();

        boolean neg = false;
        if (c == '-') {
            neg = true;
            c = read();
        }

        double x = 0;
        while (c >= '0' && c <= '9') {
            x = x * 10 + (c - '0');
            c = read();
        }

        if (c == '.') {
            c = read();
            double frac = 1;
            while (c >= '0' && c <= '9') {
                frac /= 10;
                x += (c - '0') * frac;
                c = read();
            }
        }

        return neg ? -x : x;
    }
}

public class entry_13633875 {
    public static void main(String[] args) throws IOException{
        fastio io=new fastio();

        int n=io.nextInt();
        int k=io.nextInt();

        int[]start=new int[n];
        int[]end=new int[n];
        ArrayList<int[]>sortend=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            start[i]=io.nextInt();
            end[i]=io.nextInt();
            sortend.add(new int[]{end[i],start[i],i});
        }

        sortend.sort((a,b)->{
            if(a[0]==b[0])return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        ArrayList<Integer>list=new ArrayList<>();
        int i=0;
        int size=0;
        long count=0;
        while(size<k&&i<n)
        {
            int[]temp=sortend.get(i++);
            int currentstart=temp[1];
            if(!list.isEmpty()&&currentstart>=list.get(0))
            {
                int l=0;
                int r=size-1;
                while(l<=r)
                {
                    int mid=(l+r)/2;
                    if(list.get(mid)>currentstart)                        
                    {
                        r=mid-1;
                    }
                    else
                    {
                        l=mid+1;
                    }
                }
                list.remove(r);
                size--;
            }
            list.add(temp[0]);
            size++;
            count++;
        }

        while(i<n)
        {
            int min=list.get(0);
            int[] current=sortend.get(i);
            int st=current[1];
            int en=current[0];

            if(st<min)
            {
                i++;
                continue;
            }
            int l=0;
            int r=k-1;
            while(l<=r)
            {
                int mid=(l+r)/2;
                if(list.get(mid)>st)                        
                {
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
            list.remove(r);
            list.add(en);
            count++;
            i++;
        }

        io.print(count);
        io.flush();
    }
}