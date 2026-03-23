//package tree_queries.tree_diameter.successive_leaf_removal;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.*;

class FastReader {
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastReader() {
        in = new BufferedInputStream(System.in, BS);
    }

    // dont' use this to read chars.
    private char readChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int readInt() {
        return (int) readLong();
    }

    public int[] readInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) readLong();
        }
        return res;
    }

    public long[] readLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public long readLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = readChar();
        for (; (c < '0' || c > '9'); c = readChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = readChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public double nextDouble() {
        double cur = readLong();
        return c != '.' ? cur : cur + readLong() / cnt;
    }

    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    public String readString() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c > 32) {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }

    public String readLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c != '\n') {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }

    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = readChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}


class SuccessiveLeafRemoval{

    private int[] nodeDegrees;
    private List<Integer> degreeOneNodes;
    private List<Integer>[] tree;
    SuccessiveLeafRemoval(List<Integer>[] tree){
        this.tree = tree;
        nodeDegrees = new int[tree.length];
        degreeOneNodes = new ArrayList<>();
        for (int v = 0; v < tree.length; v++){
            nodeDegrees[v] = tree[v].size();
            if (nodeDegrees[v] == 1) degreeOneNodes.add(v);
        }
    }
    public List<Integer> removeAllDegreeOneNodes(){
        List<Integer> temp = degreeOneNodes;
        degreeOneNodes = new ArrayList<>();
        for (int v : temp){
            nodeDegrees[v] = 0;
            for (int adj : tree[v]){
                if (nodeDegrees[adj] == 0) continue;
                nodeDegrees[adj]--;
                if (nodeDegrees[adj] == 1) degreeOneNodes.add(adj);
            }
        }
        return temp;
    }
}

public class entry_10004749 {
    private PrintWriter writer;
    private FastReader reader;
    private int[] size;
    private List<Integer>[] tree;
    private int[] parent;

    private  int getDiameter(){
        SuccessiveLeafRemoval successiveLeafRemoval = new SuccessiveLeafRemoval(tree);
        int removedCnt = 0;
        int n = tree.length;
        int diameter = 0;
        while (removedCnt < n-2){
            List<Integer> degreeOneNodes = successiveLeafRemoval.removeAllDegreeOneNodes();
            removedCnt += degreeOneNodes.size();
            diameter += 2;
        }
        List<Integer> degreeOneNodes = successiveLeafRemoval.removeAllDegreeOneNodes();
        if (degreeOneNodes.size() == 2) diameter += 1;
        return diameter;

    }
    private void solve(){
        writer = new PrintWriter(System.out);
        reader = new FastReader();
        int n = reader.readInt();
        readTree(n);
        writer.println(getDiameter());
        writer.close();

    }
    private void readTree(int n){
        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++){
            int u = reader.readInt()-1;
            int v = reader.readInt()-1;
            tree[u].add(v);
            tree[v].add(u);
        }
    }

    public static void main(String[] args) {
        new Thread(null, ()-> new entry_10004749().solve(), "SolutionThread", 1<<25).start();
    }
}