import java.io.*;
import java.util.*;

public class entry_748851 { 
    static Random random;
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
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

            new QuickSort(input).sort();
            //new Debugger().d(input).d();

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
                int x = a, y = p.a;
                if(x == y){
                    x = b; y = p.b;
                }
                if(x == y) return 0;
                else if(x > y) return 1;
                else return -1;
            }
        }
    }
    /* -------------------------------------- END --------------------------------------------- */


    static class QuickSort {
        int pos[];
        Solver.Pair arr[];
        public QuickSort(Solver.Pair arr[]){
            this.arr = arr;
        }

        public void sort(){
            pos = new int[arr.length];
            for(int i = 0; i<pos.length; i++) pos[i] = i;

            sort(0, pos.length-1);

            // new Debugger().d("pos", pos).d();

            for(int i = 0; i<pos.length; i++){
                if(pos[i] == -1) continue;
                int cur = i;
                Solver.Pair tmp = arr[cur];
                do{
                    int cur2 = pos[cur];
                    pos[cur] = -1;
                    if(cur2 == i) break;
                    arr[cur] = arr[cur2];
                    cur = cur2;
                }while(true);
                arr[cur] = tmp;
            }
        }
        private void sort(int start, int end){
            if(start == end) return;
            int pivot = partition(start, end);
            if(pivot - 1 > start) sort(start, pivot-1);
            if(end > pivot + 1) sort(pivot+1, end);
        }
        private int partition(int start, int end) {
            int pivot = random.nextInt(end-start+1)+start;
            {int swapTemp = pos[pivot]; pos[pivot] = pos[end]; pos[end] = swapTemp;}
            pivot = start-1;
            for(int i = start; i<end; i++){
                if(arr[pos[i]].compareTo(arr[pos[end]]) < 0){
                    pivot++;
                    {int swapTemp = pos[i]; pos[i] = pos[pivot]; pos[pivot] = swapTemp;}
                }
            }
            pivot++;
            {int swapTemp = pos[pivot]; pos[pivot] = pos[end]; pos[end] = swapTemp;}
            return pivot;
        }
    }

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
}