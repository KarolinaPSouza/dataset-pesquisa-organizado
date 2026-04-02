import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_11563758 {
    static int mod = (int)1e9 + 7;    

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

    static class Update{
        long val;
        Update(){
            val = 0;
        }
        Update(long v){
            val = v;
        }
        void merge(Update newUpdate){
            val = newUpdate.val;
        }
    }
    static class Node{
        long val;
        long pref;
        Node(){
            val = 0;
            pref = 0;
        }
        Node(int v, int p){
            val = v;
            pref = p;
        }
        void merge(Node left, Node right){
            val = left.val + right.val;
            pref = Math.max(left.pref, left.val + right.pref);
        }
        void updateValue(int start, int end, Update newUpdate){
            val = newUpdate.val;
            pref = newUpdate.val;
        }
    }
    static class SGT{
        Node[] tree;
        Update[] updates;
        boolean[] lazy;
        int[] arr;
        int n;
        SGT(int n, int[] arr){
            this.arr = arr;
            this.n = n;
            int size = 1;
            while(size < 2 * n){
                size = (size << 1);
            }
            tree = new Node[size];
            updates = new Update[size];
            lazy = new boolean[size];
            for(int i = 0; i<size; i++){
                tree[i] = new Node();
                updates[i] = new Update();
                lazy[i] = false;
            }
            build(0, n - 1, 1);
        }
        void build(int low, int high, int index){
            if(low == high){
                tree[index] = new Node(arr[low], arr[low]);
                return;
            }
            int mid = (low + high) / 2;
            build(low, mid, 2*index);
            build(mid + 1, high, 2 *index + 1);
            tree[index].merge(tree[2*index], tree[2*index + 1]);
        }
        void updateNode(int low, int high, int index, Update newUpdate){
            tree[index].updateValue(low, high, newUpdate);
            if(low != high){
                lazy[index] = true;
                updates[index].merge(newUpdate);
            }
        }
        void pushdownUpdate(int low, int high, int index){
            if(lazy[index]){
                int mid = (low + high )/ 2;
                updateNode(low, mid, 2*index, updates[index]);
                updateNode(mid + 1, high, 2*index + 1, updates[index]);
                updates[index] = new Update();
                lazy[index] = false;
            }
        }
        void makeUpdate(int low, int high, int start, int end, int index, Update newUpdate){
            if(high < start || low > end) return;
            if(start <= low && high <= end){
                updateNode(low, high, index, newUpdate);
                return;
            }
            pushdownUpdate(low, high, index);
            int mid = (low + high) / 2;
            makeUpdate(low, mid, start, end, 2*index, newUpdate);
            makeUpdate(mid + 1, high, start, end, 2*index + 1, newUpdate);
            tree[index].merge(tree[2*index], tree[2*index + 1]);
        }
        void update(int start, int end, int value){
            Update newUpdate = new Update(value);
            makeUpdate(0, n - 1, start, end, 1, newUpdate);
        }
        Node query(int low, int high, int start, int end, int index){
            if(low > end || high < start) return new Node();
            if(start <= low && high <= end){
                return tree[index];
            }
            int mid = (low + high)/2;
            pushdownUpdate(low, high, index);
            Node left = query(low, mid, start, end, 2*index);
            Node right = query(mid + 1, high, start, end, 2*index + 1);
            Node ans = new Node();
            ans.merge(left, right);
            return ans;
        }
    }
    public static void entry_11563758(String[] args) throws IOException {
        Reader sc = new Reader();
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // while(t --> 0){
            // String empty = sc.nextLine();
            StringBuilder ans = new StringBuilder();
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            SGT sgt = new SGT(n, arr);
            for(int i = 0; i<q; i++){
                int query = sc.nextInt();
                if(query == 1){
                    int a = sc.nextInt() - 1;
                    // int b = sc.nextInt() - 1;
                    int value = sc.nextInt();
                    sgt.update(a, a, value);
                }
                else{
                    int a = sc.nextInt() - 1;
                    int b = sc.nextInt() - 1;
                    long currAns = sgt.query(0, n - 1, a, b, 1).pref;
                    ans.append(Math.max(currAns, 0) +"\n");
                }
            }
            System.out.println(String.valueOf(ans));
        // }
    }
}