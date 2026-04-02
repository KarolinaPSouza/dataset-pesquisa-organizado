//package cf;
import java.io.*;
import java.util.*;
public class entry_485500 {
    static int n,m,visited[];
    static ArrayList<Integer>g[];
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);        
        Reader sc=new Reader();
        n=sc.nextInt();
        m=sc.nextInt();
        g=new ArrayList[n];
        visited=new int[n];
        for(int i=0;i<n;i++)g[i]=new ArrayList<>();
        int u,v,cnt=0;
        for(int i=0;i<m;i++)
        {
            u=sc.nextInt()-1;
            v=sc.nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(visited[i]==1)continue;
            cnt++;
             ans.add(i+1);
            dfs(i,-1);
        }
        if(cnt-1==0)out.write("0");
        else
        {
            out.write(cnt-1+"\n");
            u=ans.get(0);
            for(int i=1;i<ans.size();i++)
            {
                out.write(u+" "+ans.get(i)+"\n");
                u=ans.get(i);
            }
        }
        out.flush();

    }

    public static void dfs(int u,int p)
    {
        if(visited[u]==1)return;
        visited[u]=1;
        for(int v:g[u])
        {
            if(v==p)continue;
            dfs(v,u);
        }
    }







    ///////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////
    static class FastReader {        

        BufferedReader br;        
        StringTokenizer st;        

        public FastReader() {            
            br = new BufferedReader(new InputStreamReader(System.in));            
        }        

        String next() {            
            while (st == null || !st.hasMoreElements()) {                
                try {                    
                    st = new StringTokenizer(br.readLine());                    
                } catch (IOException e) {                    
                    e.printStackTrace();                    
                }                
            }            
            return st.nextToken();            
        }        

        int nextInt() {            
            return Integer.parseInt(next());            
        }        

        long nextLong() {            
            return Long.parseLong(next());            
        }        

        double nextDouble() {            
            return Double.parseDouble(next());            
        }        

        String nextLine() {            
            String str = "";            
            try {                
                str = br.readLine();                
            } catch (IOException e) {                
                e.printStackTrace();                
            }            
            return str;            
        }        
    }    
   //////////////////////////////////////////////////////////////////
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
            byte[] buf = new byte[1001]; // line length 
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
}
