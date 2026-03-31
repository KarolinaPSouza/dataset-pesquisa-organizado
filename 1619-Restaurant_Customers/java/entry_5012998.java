import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class entry_5012998 {
    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO();
        int n = io.nextInt();

        List<Interval> customers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int start = io.nextInt();
            int end = io.nextInt();
            customers.add(new Interval(start, end));
        }

        Collections.sort(customers, Comparator.comparingInt(c -> c.start));

//        Collections.sort(customers, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                if (o1.start > o2.start) {
//                    return 1;
//                } else if (o1.start < o2.start) {
//                    return -1;
//                } else if (o1.end > o2.end) {
//                    return 1;
//                } else if (o1.end < o2.end) {
//                    return -1;
//                }
//                return 0;
//            }
//        });
        int cnt = 0;
        int maxCnt = 0;
        TreeMap<Integer, Integer> endMap = new TreeMap<>();
        for (int i=0; i<n; ++i) {
            Interval curr = customers.get(i);
            Map<Integer, Integer> headMap = endMap.headMap(curr.start, true);
            cnt = cnt + 1 - headMap.size();
            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
            Set<Integer> keySet = headMap.keySet();
            Iterator<Map.Entry<Integer, Integer>> it = endMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> end = it.next();
                if (end.getKey() > curr.start) {
                    break;
                }
                if (keySet.contains(end.getKey())) {
                    it.remove();
                }
            }
            if (endMap.containsKey(curr.end)) {
                endMap.put(curr.end, endMap.get(curr.end) + 1);
            } else {
                endMap.put(curr.end, 1);
            }
        }
        io.println(maxCnt);
        io.close();
    }
}

class Interval {
    int start;
    int end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar;
    private int numChars;

    // standard input
    public FastIO() { this(System.in, System.out); }

    public FastIO(InputStream i, OutputStream o) {
        super(o);
        stream = i;
    }

    // file input
    public FastIO(String i, String o) throws IOException {
        super(new FileWriter(o));
        stream = new FileInputStream(i);
    }

    // throws InputMismatchException() if previously detected end of file
    private int nextByte() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars == -1) {
                return -1;  // end of file
            }
        }
        return buf[curChar++];
    }

    // to read in entire lines, replace c <= ' '
    // with a function that checks whether c is a line break
    public String next() {
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');

        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = nextByte();
        } while (c > ' ');
        return res.toString();
    }

    public int nextInt() {  // nextLong() would be implemented similarly
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');

        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = nextByte();
        }

        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public double nextDouble() { return Double.parseDouble(next()); }
}