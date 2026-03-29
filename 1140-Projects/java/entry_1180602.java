import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.io.IOException;
import java.util.Random;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class entry_1180602 {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 29);
        thread.start();
        thread.join();
    }

    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            PrintWriter out = new PrintWriter(outputStream);
            Projects solver = new Projects();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class Projects {
        public void solve(int testNumber, FastInput in, PrintWriter out) {
            int n = in.readInt();
            Project[] projects = new Project[n];
            IntegerArrayList list = new IntegerArrayList(n * 2);
            for (int i = 0; i < n; i++) {
                projects[i] = new Project(in.readInt(), in.readInt(), in.readInt());
                list.add(projects[i].l);
                list.add(projects[i].r);
            }
            list.unique();
            for (int i = 0; i < n; i++) {
                projects[i].l = 1 + list.binarySearch(projects[i].l);
                projects[i].r = 1 + list.binarySearch(projects[i].r);
            }
            int m = list.size();
            long[] dp = new long[m + 1];
            MultiWayStack<Project> stack = new MultiWayStack<>(m + 1, n);
            for (Project p : projects) {
                stack.addLast(p.r, p);
            }
            for (int i = 1; i <= m; i++) {
                dp[i] = dp[i - 1];
                for (Project p : stack.getStack(i)) {
                    dp[i] = Math.max(dp[i], p.reward + dp[p.l - 1]);
                }
            }
            out.println(dp[m]);
        }

    }

    static class RandomWrapper {
        private Random random;
        public static final RandomWrapper INSTANCE = new RandomWrapper(new Random());

        public RandomWrapper() {
            this(new Random());
        }

        public RandomWrapper(Random random) {
            this.random = random;
        }

        public int nextInt(int l, int r) {
            return random.nextInt(r - l + 1) + l;
        }

    }

    static interface SimplifiedStack<T> extends Iterable<T> {
    }

    static class Project {
        int l;
        int r;
        int reward;

        public Project(int l, int r, int reward) {
            this.l = l;
            this.r = r;
            this.reward = reward;
        }

    }

    static class MultiWayStack<T> {
        private Object[] values;
        private int[] next;
        private int[] heads;
        private int alloc;
        private int stackNum;

        public RevokeIterator<T> iterator(final int queue) {
            return new RevokeIterator<T>() {
                int ele = heads[queue];
                int pre = 0;


                public boolean hasNext() {
                    return ele != 0;
                }


                public T next() {
                    T ans = (T) values[ele];
                    pre = ele;
                    ele = next[ele];
                    return ans;
                }


                public void revoke() {
                    ele = pre;
                    pre = 0;
                }
            };
        }

        public SimplifiedStack<T> getStack(int qId) {
            return new SimplifiedStack<T>() {

                public boolean isEmpty() {
                    return MultiWayStack.this.isEmpty(qId);
                }


                public T peekLast() {
                    return MultiWayStack.this.peekLast(qId);
                }


                public void addLast(T x) {
                    MultiWayStack.this.addLast(qId, x);
                }


                public T removeLast() {
                    return MultiWayStack.this.removeLast(qId);
                }


                public Iterator<T> iterator() {
                    return MultiWayStack.this.iterator(qId);
                }
            };
        }

        private void doubleCapacity() {
            int newSize = Math.max(next.length + 10, next.length * 2);
            next = Arrays.copyOf(next, newSize);
            values = Arrays.copyOf(values, newSize);
        }

        public void alloc() {
            alloc++;
            if (alloc >= next.length) {
                doubleCapacity();
            }
            next[alloc] = 0;
        }

        public boolean isEmpty(int qId) {
            return heads[qId] == 0;
        }

        public MultiWayStack(int qNum, int totalCapacity) {
            values = new Object[totalCapacity + 1];
            next = new int[totalCapacity + 1];
            heads = new int[qNum];
            stackNum = qNum;
        }

        public void addLast(int qId, T x) {
            alloc();
            values[alloc] = x;
            next[alloc] = heads[qId];
            heads[qId] = alloc;
        }

        public T peekLast(int qId) {
            return (T) values[heads[qId]];
        }

        public T removeLast(int qId) {
            T ans = (T) values[heads[qId]];
            heads[qId] = next[heads[qId]];
            return ans;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < stackNum; i++) {
                builder.append(i).append(": ");
                for (Iterator iterator = iterator(i); iterator.hasNext(); ) {
                    builder.append(iterator.next()).append(",");
                }
                if (builder.charAt(builder.length() - 1) == ',') {
                    builder.setLength(builder.length() - 1);
                }
                builder.append('\n');
            }
            return builder.toString();
        }

    }

    static interface RevokeIterator<E> extends Iterator<E> {
    }

    static class IntegerArrayList implements Cloneable {
        private int size;
        private int cap;
        private int[] data;
        private static final int[] EMPTY = new int[0];

        public IntegerArrayList(int cap) {
            this.cap = cap;
            if (cap == 0) {
                data = EMPTY;
            } else {
                data = new int[cap];
            }
        }

        public IntegerArrayList(int[] data) {
            this(0);
            addAll(data);
        }

        public IntegerArrayList(IntegerArrayList list) {
            this.size = list.size;
            this.cap = list.cap;
            this.data = Arrays.copyOf(list.data, size);
        }

        public IntegerArrayList() {
            this(0);
        }

        public void ensureSpace(int req) {
            if (req > cap) {
                while (cap < req) {
                    cap = Math.max(cap + 10, 2 * cap);
                }
                data = Arrays.copyOf(data, cap);
            }
        }

        public void add(int x) {
            ensureSpace(size + 1);
            data[size++] = x;
        }

        public void addAll(int[] x) {
            addAll(x, 0, x.length);
        }

        public void addAll(int[] x, int offset, int len) {
            ensureSpace(size + len);
            System.arraycopy(x, offset, data, size, len);
            size += len;
        }

        public void addAll(IntegerArrayList list) {
            addAll(list.data, 0, list.size);
        }

        public void sort() {
            if (size <= 1) {
                return;
            }
            Randomized.shuffle(data, 0, size);
            Arrays.sort(data, 0, size);
        }

        public void unique() {
            if (size <= 1) {
                return;
            }

            sort();
            int wpos = 1;
            for (int i = 1; i < size; i++) {
                if (data[i] != data[wpos - 1]) {
                    data[wpos++] = data[i];
                }
            }
            size = wpos;
        }

        public int binarySearch(int x) {
            return Arrays.binarySearch(data, 0, size, x);
        }

        public int size() {
            return size;
        }

        public int[] toArray() {
            return Arrays.copyOf(data, size);
        }

        public String toString() {
            return Arrays.toString(toArray());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof IntegerArrayList)) {
                return false;
            }
            IntegerArrayList other = (IntegerArrayList) obj;
            return SequenceUtils.equal(data, 0, size - 1, other.data, 0, other.size - 1);
        }

        public int hashCode() {
            int h = 1;
            for (int i = 0; i < size; i++) {
                h = h * 31 + Integer.hashCode(data[i]);
            }
            return h;
        }

        public IntegerArrayList clone() {
            IntegerArrayList ans = new IntegerArrayList();
            ans.addAll(this);
            return ans;
        }

    }

    static class FastInput {
        private final InputStream is;
        private byte[] buf = new byte[1 << 13];
        private int bufLen;
        private int bufOffset;
        private int next;

        public FastInput(InputStream is) {
            this.is = is;
        }

        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }

        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }

        public int readInt() {
            int sign = 1;

            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }

            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }

            return val;
        }

    }

    static class Randomized {
        public static void shuffle(int[] data, int from, int to) {
            to--;
            for (int i = from; i <= to; i++) {
                int s = nextInt(i, to);
                int tmp = data[i];
                data[i] = data[s];
                data[s] = tmp;
            }
        }

        public static int nextInt(int l, int r) {
            return RandomWrapper.INSTANCE.nextInt(l, r);
        }

    }

    static class SequenceUtils {
        public static boolean equal(int[] a, int al, int ar, int[] b, int bl, int br) {
            if ((ar - al) != (br - bl)) {
                return false;
            }
            for (int i = al, j = bl; i <= ar; i++, j++) {
                if (a[i] != b[j]) {
                    return false;
                }
            }
            return true;
        }

    }
}
