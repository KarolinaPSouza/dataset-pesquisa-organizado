import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
class FastIO extends PrintWriter {
    private InputStream stream;private byte[]buf=new byte[1<<16];
    private int curChar,numChars;public FastIO(){this(System.in,System.out);}
    public FastIO(InputStream i, OutputStream o){super(o);stream=i;}
    public FastIO(String i,String o)throws IOException {super(new FileWriter(o));stream=new FileInputStream(i);}
    private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return -1;}return buf[curChar++];}
    public String nextLine(){int c;do{c=nextByte();}while(c<='\n');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>'\n');return res.toString();}
    public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}
    public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public long nextLong(){int c;do{c=nextByte();}while(c<=' ');long sgn=1;if(c=='-'){sgn=-1;c=nextByte();}long res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public double nextDouble(){return Double.parseDouble(next());
    }

}
class Node {
    long sum;
    long maxPrefixSum;

    Node(long sum, long maxPrefixSum) {
        this.sum = sum;
        this.maxPrefixSum = maxPrefixSum;
    }
}

class SegmentTree {
    static Node[] tree;

    public SegmentTree(int n) {
        tree = new Node[4 * n + 1];
    }

    public void buildSTPrefixSum(int i, int si, int sj, int[] arr) {
        if (si == sj) {
            tree[i] = new Node(arr[si], arr[si]);
            return;
        }
        int mid = (si + sj) / 2;
        buildSTPrefixSum(2 * i + 1, si, mid, arr);
        buildSTPrefixSum(2 * i + 2, mid + 1, sj, arr);
        long sum = tree[2 * i + 1].sum + tree[2 * i + 2].sum;
        long prefixSum = Math.max(tree[2 * i + 1].sum + tree[2 * i + 2].maxPrefixSum, tree[2 * i + 1].maxPrefixSum);
        tree[i] = new Node(sum, prefixSum);
    }

    public void updateSTPrefixSum(int i, int si, int sj, int index, int newVal) {
        if (si == sj && si == index) {
            tree[i] = new Node(newVal, newVal);
            return;
        }
        int mid = (si + sj) / 2;
        if (index <= mid) {
            updateSTPrefixSum(2 * i + 1, si, mid, index, newVal);
        } else {
            updateSTPrefixSum(2 * i + 2, mid + 1, sj, index, newVal);
        }

        long sum = tree[2 * i + 1].sum + tree[2 * i + 2].sum;
        long prefixSum = Math.max(tree[2 * i + 1].sum + tree[2 * i + 2].maxPrefixSum, tree[2 * i + 1].maxPrefixSum);
        tree[i] = new Node(sum, prefixSum);
    }

    public Node getMaxPrefix(int i, int si, int sj, int qi, int qj) {
        if (qi > sj || qj < si) {
            return new Node(0, Long.MIN_VALUE);
        }

        if (qi <= si && sj <= qj) {
            return tree[i];
        }
        int mid = (si + sj) / 2;
        Node n1 = getMaxPrefix(2 * i + 1, si, mid, qi, qj);
        Node n2 = getMaxPrefix(2 * i + 2, mid + 1, sj, qi, qj);
        if(n1.maxPrefixSum==Long.MIN_VALUE){
            return n2;
        }else if(n2.maxPrefixSum==Long.MIN_VALUE){
            return n1;
        }
        long sum = n1.sum + n2.sum;

        long prefixSum = Math.max(n1.sum + n2.maxPrefixSum, n1.maxPrefixSum);
        return new Node(sum, prefixSum);
    }
}

public class entry_11698678 {
    public static void main(String[] args) {
        FastIO sc = new FastIO();
        int n = sc.nextInt();
        SegmentTree st = new SegmentTree(n);
        int q = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        st.buildSTPrefixSum(0, 0, n - 1, arr);
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            if (choice == 2) {
                int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;
                Node result = st.getMaxPrefix(0, 0, n - 1, a, b);
                sc.println(result.maxPrefixSum<0?0:result.maxPrefixSum);
            } else {
                int k = sc.nextInt()-1;
                int u = sc.nextInt();
                st.updateSTPrefixSum(0, 0, n - 1, k, u);
            }
        }
        sc.close();
    }
}