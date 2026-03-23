import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Map;
import java.io.Writer;
import java.util.Map.Entry;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class entry_2893009 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ConcertTickets solver = new ConcertTickets();
        solver.solve(1, in, out);
        out.close();
    }

    static class ConcertTickets {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int tickets = in.nextInt();
            int m = in.nextInt();
            int[] ticketArr = in.nextIntArray(tickets);
            int[] customers = in.nextIntArray(m);

            EzIntIntTreeMap tt = new EzIntIntTreeMap();

            for (int i : ticketArr) {
                int x = tt.get(i);
                if (tt.returnedNull()) {
                    x = 0;
                }
                x++;
                tt.put(i, x);
            }

            for (int i : customers) {
                var x = tt.floorKey(i);
                if (!tt.returnedNull()) {
                    out.println(x);
                    int cnt = tt.get(x) - 1;
                    if (cnt == 0) {
                        tt.remove(x);
                    } else {
                        tt.put(x, cnt);
                    }
                } else {
                    out.println(-1);
                }
            }
        }

    }

    static interface EzIntIntMapIterator {
        boolean hasNext();

        int getKey();

        int getValue();

        void next();

    }

    static final class PrimitiveHashCalculator {
        private PrimitiveHashCalculator() {
        }

        public static int getHash(int x) {
            return x;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) array[i] = nextInt();
            return array;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class EzIntIntTreeMap implements EzIntIntSortedMap {
        private static final int DEFAULT_CAPACITY = 10;
        private static final double ENLARGE_SCALE = 2.0;
        private static final int HASHCODE_INITIAL_VALUE = 0x811c9dc5;
        private static final int HASHCODE_MULTIPLIER = 0x01000193;
        private static final boolean BLACK = false;
        private static final boolean RED = true;
        private static final int NULL = 0;
        private static final int DEFAULT_NULL_KEY = (new int[1])[0];
        private static final int DEFAULT_NULL_VALUE = (new int[1])[0];
        private int[] keys;
        private int[] values;
        private int[] left;
        private int[] right;
        private int[] p;
        private boolean[] color;
        private int size;
        private int root;
        private boolean returnedNull;

        public EzIntIntTreeMap() {
            this(DEFAULT_CAPACITY);
        }

        public EzIntIntTreeMap(int capacity) {
            if (capacity < 0) {
                throw new IllegalArgumentException("Capacity must be non-negative");
            }
            capacity++;
            keys = new int[capacity];
            values = new int[capacity];
            left = new int[capacity];
            right = new int[capacity];
            p = new int[capacity];
            color = new boolean[capacity];
            color[NULL] = BLACK;
            size = 0;
            root = NULL;
            returnedNull = false;
        }

        public EzIntIntTreeMap(EzIntIntMap map) {
            this(map.size());
            for (EzIntIntMapIterator it = map.iterator(); it.hasNext(); it.next()) {
                put(it.getKey(), it.getValue());
            }
        }

        public EzIntIntTreeMap(Map<Integer, Integer> javaMap) {
            this(javaMap.size());
            for (Map.Entry<Integer, Integer> e : javaMap.entrySet()) {
                put(e.getKey(), e.getValue());
            }
        }

        public int size() {
            return size;
        }

        public int get(int key) {
            int x = root;
            while (x != NULL) {
                if (key < keys[x]) {
                    x = left[x];
                } else if (key > keys[x]) {
                    x = right[x];
                } else {
                    returnedNull = false;
                    return values[x];
                }
            }
            returnedNull = true;
            return DEFAULT_NULL_VALUE;
        }

        public int put(int key, int value) {
            int y = NULL;
            int x = root;
            while (x != NULL) {
                //noinspection SuspiciousNameCombination
                y = x;
                if (key < keys[x]) {
                    x = left[x];
                } else if (key > keys[x]) {
                    x = right[x];
                } else {
                    final int oldValue = values[x];
                    values[x] = value;
                    returnedNull = false;
                    return oldValue;
                }
            }
            if (size == color.length - 1) {
                enlarge();
            }
            int z = ++size;
            keys[z] = key;
            values[z] = value;
            p[z] = y;
            if (y == NULL) {
                root = z;
            } else {
                if (key < keys[y]) {
                    left[y] = z;
                } else {
                    right[y] = z;
                }
            }
            left[z] = NULL;
            right[z] = NULL;
            color[z] = RED;
            fixAfterAdd(z);
            returnedNull = true;
            return DEFAULT_NULL_VALUE;
        }

        public int remove(int key) {
            int z = root;
            while (z != NULL) {
                if (key < keys[z]) {
                    z = left[z];
                } else if (key > keys[z]) {
                    z = right[z];
                } else {
                    final int removedValue = values[z];
                    removeNode(z);
                    returnedNull = false;
                    return removedValue;
                }
            }
            returnedNull = true;
            return DEFAULT_NULL_VALUE;
        }

        private void removeNode(int z) {
            int y = (left[z] == NULL || right[z] == NULL) ? z : successorNode(z);
            int x = (left[y] != NULL) ? left[y] : right[y];
            p[x] = p[y];
            if (p[y] == NULL) {
                root = x;
            } else {
                if (y == left[p[y]]) {
                    left[p[y]] = x;
                } else {
                    right[p[y]] = x;
                }
            }
            if (y != z) {
                keys[z] = keys[y];
                values[z] = values[y];
            }
            //noinspection PointlessBooleanExpression
            if (color[y] == BLACK) {
                fixAfterRemove(x);
            }
            // Swap with last
            if (y != size) {
                // copy fields
                keys[y] = keys[size];
                values[y] = values[size];
                left[y] = left[size];
                right[y] = right[size];
                p[y] = p[size];
                color[y] = color[size];
                // fix the children's parents
                p[left[size]] = y;
                p[right[size]] = y;
                // fix one of the parent's children
                if (left[p[size]] == size) {
                    left[p[size]] = y;
                } else {
                    right[p[size]] = y;
                }
                // fix root
                if (root == size) {
                    root = y;
                }
            }
            size--;
        }

        private int successorNode(int x) {
            if (right[x] != NULL) {
                x = right[x];
                while (left[x] != NULL) {
                    x = left[x];
                }
                return x;
            } else {
                int y = p[x];
                while (y != NULL && x == right[y]) {
                    //noinspection SuspiciousNameCombination
                    x = y;
                    y = p[y];
                }
                return y;
            }
        }

        private void fixAfterAdd(int z) {
            while (color[p[z]] == RED) {
                if (p[z] == left[p[p[z]]]) {
                    int y = right[p[p[z]]];
                    if (color[y] == RED) {
                        color[p[z]] = BLACK;
                        color[y] = BLACK;
                        color[p[p[z]]] = RED;
                        z = p[p[z]];
                    } else {
                        if (z == right[p[z]]) {
                            z = p[z];
                            rotateLeft(z);
                        }
                        color[p[z]] = BLACK;
                        color[p[p[z]]] = RED;
                        rotateRight(p[p[z]]);
                    }
                } else {
                    int y = left[p[p[z]]];
                    if (color[y] == RED) {
                        color[p[z]] = BLACK;
                        color[y] = BLACK;
                        color[p[p[z]]] = RED;
                        z = p[p[z]];
                    } else {
                        if (z == left[p[z]]) {
                            z = p[z];
                            rotateRight(z);
                        }
                        color[p[z]] = BLACK;
                        color[p[p[z]]] = RED;
                        rotateLeft(p[p[z]]);
                    }
                }
            }
            color[root] = BLACK;
        }

        private void fixAfterRemove(int x) {
            while (x != root && color[x] == BLACK) {
                if (x == left[p[x]]) {
                    int w = right[p[x]];
                    if (color[w] == RED) {
                        color[w] = BLACK;
                        color[p[x]] = RED;
                        rotateLeft(p[x]);
                        w = right[p[x]];
                    }
                    if (color[left[w]] == BLACK && color[right[w]] == BLACK) {
                        color[w] = RED;
                        x = p[x];
                    } else {
                        if (color[right[w]] == BLACK) {
                            color[left[w]] = BLACK;
                            color[w] = RED;
                            rotateRight(w);
                            w = right[p[x]];
                        }
                        color[w] = color[p[x]];
                        color[p[x]] = BLACK;
                        color[right[w]] = BLACK;
                        rotateLeft(p[x]);
                        x = root;
                    }
                } else {
                    int w = left[p[x]];
                    if (color[w] == RED) {
                        color[w] = BLACK;
                        color[p[x]] = RED;
                        rotateRight(p[x]);
                        w = left[p[x]];
                    }
                    if (color[left[w]] == BLACK && color[right[w]] == BLACK) {
                        color[w] = RED;
                        x = p[x];
                    } else {
                        if (color[left[w]] == BLACK) {
                            color[right[w]] = BLACK;
                            color[w] = RED;
                            rotateLeft(w);
                            w = left[p[x]];
                        }
                        color[w] = color[p[x]];
                        color[p[x]] = BLACK;
                        color[left[w]] = BLACK;
                        rotateRight(p[x]);
                        x = root;
                    }
                }
            }
            color[x] = BLACK;
        }

        private void rotateLeft(int x) {
            int y = right[x];
            right[x] = left[y];
            if (left[y] != NULL) {
                p[left[y]] = x;
            }
            p[y] = p[x];
            if (p[x] == NULL) {
                root = y;
            } else {
                if (x == left[p[x]]) {
                    left[p[x]] = y;
                } else {
                    right[p[x]] = y;
                }
            }
            left[y] = x;
            p[x] = y;
        }

        private void rotateRight(int x) {
            int y = left[x];
            left[x] = right[y];
            if (right[y] != NULL) {
                p[right[y]] = x;
            }
            p[y] = p[x];
            if (p[x] == NULL) {
                root = y;
            } else {
                if (x == right[p[x]]) {
                    right[p[x]] = y;
                } else {
                    left[p[x]] = y;
                }
            }
            right[y] = x;
            p[x] = y;
        }

        public boolean returnedNull() {
            return returnedNull;
        }

        public EzIntIntMapIterator iterator() {
            return new EzIntIntTreeMapIterator();
        }

        private void enlarge() {
            int newLength = Math.max(color.length + 1, (int) (color.length * ENLARGE_SCALE));
            keys = Arrays.copyOf(keys, newLength);
            values = Arrays.copyOf(values, newLength);
            left = Arrays.copyOf(left, newLength);
            right = Arrays.copyOf(right, newLength);
            p = Arrays.copyOf(p, newLength);
            color = Arrays.copyOf(color, newLength);
        }

        private int firstNode() {
            int x = root;
            while (left[x] != NULL) {
                x = left[x];
            }
            return x;
        }

        public int floorKey(int key) {
            int x = root;
            while (x != NULL) {
                if (key > keys[x]) {
                    if (right[x] != NULL) {
                        x = right[x];
                    } else {
                        returnedNull = false;
                        return keys[x];
                    }
                } else if (key < keys[x]) {
                    if (left[x] != NULL) {
                        x = left[x];
                    } else {
                        int y = p[x];
                        while (y != NULL && x == left[y]) {
                            //noinspection SuspiciousNameCombination
                            x = y;
                            y = p[y];
                        }
                        if (y == NULL) {
                            returnedNull = true;
                            return DEFAULT_NULL_KEY;
                        } else {
                            returnedNull = false;
                            return keys[y];
                        }
                    }
                } else {
                    returnedNull = false;
                    return keys[x];
                }
            }
            returnedNull = true;
            return DEFAULT_NULL_KEY;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EzIntIntTreeMap that = (EzIntIntTreeMap) o;

            if (size != that.size) {
                return false;
            }
            for (int x = firstNode(), y = that.firstNode();
                 x != NULL;
                //noinspection SuspiciousNameCombination
                 x = successorNode(x), y = that.successorNode(y)
            ) {
                if (keys[x] != that.keys[y] || values[x] != that.values[y]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int hash = HASHCODE_INITIAL_VALUE;
            for (int x = firstNode(); x != NULL; x = successorNode(x)) {
                hash = (hash ^ PrimitiveHashCalculator.getHash(keys[x])) * HASHCODE_MULTIPLIER;
                hash = (hash ^ PrimitiveHashCalculator.getHash(values[x])) * HASHCODE_MULTIPLIER;
            }
            return hash;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            for (int x = firstNode(); x != NULL; x = successorNode(x)) {
                if (sb.length() > 1) {
                    sb.append(", ");
                }
                sb.append(keys[x]);
                sb.append('=');
                sb.append(values[x]);
            }
            sb.append('}');
            return sb.toString();
        }

        private class EzIntIntTreeMapIterator implements EzIntIntMapIterator {
            private int x;

            private EzIntIntTreeMapIterator() {
                x = firstNode();
            }

            public boolean hasNext() {
                return x != NULL;
            }

            public int getKey() {
                if (x == NULL) {
                    throw new NoSuchElementException("Iterator doesn't have more entries");
                }
                return keys[x];
            }

            public int getValue() {
                if (x == NULL) {
                    throw new NoSuchElementException("Iterator doesn't have more entries");
                }
                return values[x];
            }

            public void next() {
                if (x == NULL) {
                    return;
                }
                x = successorNode(x);
            }

        }

    }

    static interface EzIntIntSortedMap extends EzIntIntMap {
        int size();

        EzIntIntMapIterator iterator();

        boolean equals(Object object);

        int hashCode();

        String toString();

    }

    static interface EzIntIntMap {
        int size();

        EzIntIntMapIterator iterator();

        boolean equals(Object object);

        int hashCode();

        String toString();

    }

    static class Arrays {
        private Arrays() {
        }

        public static int[] copyOf(int[] original, int newLength) {
            return java.util.Arrays.copyOf(original, newLength);
        }

        public static boolean[] copyOf(boolean[] original, int newLength) {
            return java.util.Arrays.copyOf(original, newLength);

        }

    }
}
