import java.io.*;
import java.util.*;

public class entry_747011 { 
    static Random random;
    public static void main(String[] args) {
        FastScanner in = new FasterScanner();
        FastWriter out = new FastWriter();
        random = new Random();

        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    /* ------------------------------------- START -------------------------------------------- */
    static class Solver {
        public void solve(FastScanner in, FastWriter out){
            int n = in.nextInt();
            Pair input[] = new Pair[2*n];
            for(int i = 0; i<n; i++){
                int l = in.nextInt(), r = in.nextInt();
                input[2*i] = new Pair(l, 1);
                input[2*i+1] = new Pair(r, -1);
            }

            Arrays.sort(input);

            // new Debugger().d("input", input).d();

            int cnt = 0, max = 0;
            for(int i = 0; i<input.length; i++){
                cnt += input[i].b;
                max = Math.max(max, cnt);
            }
            out.print(max).endLine();
        }

        static class Pair implements Comparable<Pair> {
            public int a, b;
            public Pair(int a, int b){
                this.a = a;
                this.b = b;
            }
            public boolean equals(Object o) {
                if(o == null || getClass() != o.getClass()) return false;
                Pair p = (Pair) o;
                return a == p.a && b == p.b;
            }
            public int hashCode() {
                return Arrays.hashCode(new int[]{a, b});
            }
            public String toString(){
                return "(" + a + ", " + b + ')';
            }
            public int compareTo(Pair p) {
                if(a == p.a) return Integer.compare(b, p.b);
                else return Integer.compare(a, p.a);
            }
        }
    }
    /* -------------------------------------- END --------------------------------------------- */

    /* Shuffle function to shuffle before Arrays.sort */
    static void shuffle(int[] arr){
        int swapTemp;
        for(int i = arr.length-1; i>= 1; i--){
            int pos = random.nextInt(i+1);
            if(pos == i) continue;
            {swapTemp = arr[i]; arr[i] = arr[pos]; arr[pos] = swapTemp;}
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
    /* Fast output writer */
    static class FastWriter {
        PrintWriter writer;

        public FastWriter(){
            writer = new PrintWriter(new BufferedOutputStream(System.out));
        }

        <T> FastWriter print(T x){
            writer.print(x);
            return this;
        }
        FastWriter endLine(){
            writer.println();
            return this;
        }
        void close(){
            writer.close();
        }
    }

     /* FUCK THE PROBLEM AUTHOR FOR MAKING ME USE THIS */
     static class FasterScanner extends FastScanner {
        final private int BUFFER_SIZE = 1 << 12; 
        private DataInputStream inputStream; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 

        public FasterScanner() { 
            inputStream = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public FasterScanner(String fileName) { 
            try{
                inputStream = new DataInputStream(new FileInputStream(fileName));     
                buffer = new byte[BUFFER_SIZE]; 
                bufferPointer = bytesRead = 0; 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 

        String readLine() { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) { 
                if (c == '\n') break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 

        String next() {
            StringBuilder ret = new StringBuilder();
            byte c = read();
            while(c <= ' ') c = read();
            do{
                ret.append((char) c);
            } while((c = read()) > ' ');
            return new String(ret);
        }

        int nextInt() { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') c = read(); 
            boolean neg = (c == '-'); 
            if (neg) c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 

            if (neg) return -ret; 
            return ret; 
        } 

        long nextLong() { 
            long ret = 0; 
            byte c = read();
            while (c <= ' ') c = read(); 
            boolean neg = (c == '-'); 
            if (neg) c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 

            if (neg) return -ret; 
            return ret; 
        }

        double nextDouble() { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') c = read(); 
            boolean neg = (c == '-'); 
            if (neg) c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 
            if (c == '.') { 
                while ((c = read()) >= '0' && c <= '9') { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
            if (neg) return -ret; 
            return ret; 
        } 

        private void fillBuffer() { 
            try{
                bytesRead = inputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
                if (bytesRead == -1) buffer[0] = -1; 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 

        private byte read() { 
            if (bufferPointer == bytesRead) fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 

        public void close() { 
            if (inputStream == null)  return; 
            try{
                inputStream.close(); 
            } catch (Exception e){
                e.printStackTrace();
            }
        } 
    } 

}