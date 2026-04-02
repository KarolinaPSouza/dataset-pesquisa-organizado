import java.util.*;

public class entry_4939719 {
    public static void main(String[] args)
    {
        Input input = new Input();
        Output output = new Output();
        int n = input.nextInt();
        int q = input.nextInt();
        long[] x = new long[n];
        for (int i = 0; i < n; i++)
            x[i] = input.nextInt();
        LongBinaryIndexedTree binaryIndexedTree = new LongBinaryIndexedTree(x, 0, Long::sum, (a, b) -> a - b);
        long[] prefix = new long[n];
        prefix[0] = x[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + x[i];
        LongLazySegmentTree segmentTree = new LongLazySegmentTree(prefix, Long.MIN_VALUE, 0, Math::max, Long::sum, (value, from, to) -> value);
        for (int i = 0; i < q; i++)
        {
            if (input.nextInt() == 1)
            {
                int k = input.nextInt() - 1;
                int u = input.nextInt();
                int difference = u - (int)x[k];
                x[k] = u;
                binaryIndexedTree.set(k, u);
                segmentTree.update(k, n, difference);
            }
            else
            {
                int a = input.nextInt() - 1;
                int b = input.nextInt();
                output.append(Math.max(segmentTree.query(a, b) - binaryIndexedTree.get(0, a), 0)).appendNewLine();
            }
        }
        output.flush();
    }
}

class Input
{
    private final byte[] buffer;
    private int pos;

    public Input()
    {
        try
        {
            buffer = new byte[System.in.available() + 1];
            buffer[buffer.length - 1] = '\n';
            System.in.read(buffer);
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public byte[] next(int n)
    {
        while (true)
        {
            byte b = buffer[pos++];
            if (b != '\n')
            {
                pos--;
                break;
            }
        }
        byte[] bytes = new byte[n];
        System.arraycopy(buffer, pos, bytes, 0, n);
        pos += n;
        return bytes;
    }

    public byte[] next()
    {
        int from;
        while (true)
        {
            byte b = buffer[pos++];
            if (b != ' ' && b != '\n')
            {
                from = pos;
                break;
            }
        }
        while (true)
        {
            byte b = buffer[pos++];
            if (b == ' ' || b == '\n')
                break;
        }
        byte[] bytes = new byte[pos - from];
        System.arraycopy(buffer, from - 1, bytes, 0, bytes.length);
        return bytes;
    }

    public byte[] nextLine()
    {
        int from = pos;
        while (true)
        {
            byte b = buffer[pos++];
            if (b == '\n')
                break;
        }
        byte[] bytes = new byte[pos - from - 1];
        System.arraycopy(buffer, from, bytes, 0, bytes.length);
        return bytes;
    }

    public byte nextChar()
    {
        while (true)
        {
            byte b = buffer[pos++];
            if (b != ' ' && b != '\n')
                return b;
        }
    }

    public int nextInt()
    {
        int n;
        boolean positive;
        while (true)
        {
            byte b = buffer[pos++];
            if (b == '-')
            {
                positive = false;
                n = buffer[pos++] - '0';
                break;
            }
            else if (b >= '0' && b <= '9')
            {
                positive = true;
                n = b - '0';
                break;
            }
        }
        while (true)
        {
            byte b = buffer[pos++];
            if (b >= '0' && b <= '9')
                n = n * 10 + b - '0';
            else
                return positive ? n : -n;
        }
    }

    public long nextLong()
    {
        long n;
        boolean positive;
        while (true)
        {
            byte b = buffer[pos++];
            if (b == '-')
            {
                positive = false;
                n = buffer[pos++] - '0';
                break;
            }
            else if (b >= '0' && b <= '9')
            {
                positive = true;
                n = b - '0';
                break;
            }
        }
        while (true)
        {
            byte b = buffer[pos++];
            if (b >= '0' && b <= '9')
                n = n * 10 + b - '0';
            else
                return positive ? n : -n;
        }
    }

    public double nextDouble()
    {
        long n;
        boolean positive;
        while (true)
        {
            byte b = buffer[pos++];
            if (b == '-')
            {
                positive = false;
                n = buffer[pos++] - '0';
                break;
            }
            else if (b >= '0' && b <= '9')
            {
                positive = true;
                n = b - '0';
                break;
            }
        }
        while (true)
        {
            byte b = buffer[pos++];
            if (b >= '0' && b <= '9')
                n = n * 10 + b - '0';
            else if (b == '.')
                break;
            else
                return positive ? n : -n;
        }
        long m = 0;
        long o = 1;
        while (true)
        {
            byte b = buffer[pos++];
            if (b >= '0' && b <= '9')
            {
                m = m * 10 + b - '0';
                o *= 10;
            }
            else
            {
                double d = n + (double)m / o;
                return positive ? d : -d;
            }
        }
    }
}

class Output
{
    private static final int BUFFER_SIZE = 1048576;
    private final byte[] buffer = new byte[BUFFER_SIZE];
    private int pos;

    public Output append(String s)
    {
        int length = s.length();
        ensureCapacity(length);
        for (int i = 0; i < length; i++)
            buffer[pos++] = (byte)s.charAt(i);
        return this;
    }

    public Output append(byte[] bytes)
    {
        if (BUFFER_SIZE - pos < bytes.length)
        {
            flush();
            if (bytes.length > BUFFER_SIZE)
            {
                System.out.write(bytes, 0, bytes.length);
                return this;
            }
        }
        for (byte b: bytes)
            buffer[pos++] = b;
        return this;
    }

    public Output append(byte[] bytes, int from, int to)
    {
        int length = to - from;
        if (BUFFER_SIZE - pos < length)
        {
            flush();
            if (length > BUFFER_SIZE)
            {
                System.out.write(bytes, from, length);
                return this;
            }
        }
        for (int i = from; i < to; i++)
            buffer[pos++] = bytes[i];
        return this;
    }

    public Output append(char c)
    {
        ensureCapacity(1);
        buffer[pos++] = (byte)c;
        return this;
    }

    public Output append(int i)
    {
        return append(Integer.toString(i));
    }

    public Output append(long l)
    {
        return append(Long.toString(l));
    }

    public Output append(double d)
    {
        return append(Double.toString(d));
    }

    public void appendNewLine()
    {
        ensureCapacity(1);
        buffer[pos++] = '\n';
    }

    public void flush()
    {
        System.out.write(buffer, 0, pos);
        pos = 0;
    }

    private void ensureCapacity(int n)
    {
        if (BUFFER_SIZE - pos < n)
            flush();
    }
}

class Algebra
{
    private Algebra() {}

    public static long sq(int n)
    {
        return (long)n * n;
    }

    public static long pow(int a, int b)
    {
        long result = 1;
        for (int i = 0; i < b; i++)
            result *= a;
        return result;
    }

    public static int modPow(int n, int exponent, int m)
    {
        long result = 1;
        for (long i = 1, j = n; i <= exponent; i <<= 1, j = j * j % m)
        {
            if ((i & exponent) != 0)
                result = result * j % m;
        }
        return (int)result;
    }

    public static int modInverse(int n, int p)
    {
        return modPow(n, p - 2, p);
    }

    public static int[] modInverses(int n, int p)
    {
        int[] inverses = new int[n + 1];
        inverses[1] = 1;
        for (int i = 2; i <= n; i++)
            inverses[i] = (int)((long)(p - p / i) * inverses[p % i] % p);
        return inverses;
    }

    public static IntegerArrayList primes(int n)
    {
        if (n < 4)
            throw new RuntimeException();
        IntegerArrayList primes = new IntegerArrayList();
        primes.add(2);
        int[] minima = new int[n + 1];
        for (int i = 3; i < (n + 2) / 3; i += 2)
        {
            int minimum;
            if (minima[i] == 0)
            {
                minimum = i;
                primes.add(i);
            }
            else
                minimum = minima[i];
            for (int e: primes)
            {
                int index = e * i;
                if (index < n)
                {
                    minima[index] = e;
                    if (e == minimum)
                        break;
                }
                else
                    break;
            }
        }
        for (int i = (n + 2) / 3 | 1; i <= n; i += 2)
        {
            if (minima[i] == 0)
                primes.add(i);
        }
        return primes;
    }

    public static int gcd(int a, int b)
    {
        if (a < b)
        {
            int temp = a;
            a = b;
            b = temp;
        }
        while (true)
        {
            a %= b;
            if (a == 0)
                return b;
            else
            {
                int temp = a;
                a = b;
                b = temp;
            }
        }
    }

    public static long gcd(long a, long b)
    {
        if (a < b)
        {
            long temp = a;
            a = b;
            b = temp;
        }
        while (true)
        {
            a %= b;
            if (a == 0)
                return b;
            else
            {
                long temp = a;
                a = b;
                b = temp;
            }
        }
    }

    public static int log2(int n)
    {
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public static int log2(long n)
    {
        return 63 - Long.numberOfLeadingZeros(n);
    }

    public static int ceilLog2(int n)
    {
        return 32 - Integer.numberOfLeadingZeros(n - 1);
    }

    public static int minBinarySearch(IntegerPredicate function, int lower, int upper)
    {
        while (lower < upper)
        {
            int mid = lower + upper >> 1;
            if (function.test(mid))
                upper = mid;
            else
                lower = mid + 1;
        }
        return lower;
    }

    public static long minBinarySearch(LongPredicate function, long lower, long upper)
    {
        while (lower < upper)
        {
            long mid = lower + upper >> 1;
            if (function.test(mid))
                upper = mid;
            else
                lower = mid + 1;
        }
        return lower;
    }

    public static int maxBinarySearch(IntegerPredicate function, int lower, int upper)
    {
        while (lower < upper)
        {
            int mid = lower + upper + 1 >> 1;
            if (function.test(mid))
                lower = mid;
            else
                upper = mid - 1;
        }
        return lower;
    }

    public static long maxBinarySearch(LongPredicate function, long lower, long upper)
    {
        while (lower < upper)
        {
            long mid = lower + upper + 1 >> 1;
            if (function.test(mid))
                lower = mid;
            else
                upper = mid - 1;
        }
        return lower;
    }
}

class IntegerArrayList implements Cloneable, Iterable<Integer>
{
    private static final int[] EMPTY = new int[0];
    private int[] array;
    private int size;

    public IntegerArrayList()
    {
        array = EMPTY;
    }

    public IntegerArrayList(int n)
    {
        array = new int[n];
    }

    public int size()
    {
        return size;
    }

    public IntegerArrayList clone()
    {
        try
        {
            IntegerArrayList clone = (IntegerArrayList)super.clone();
            clone.array = size == 0 ? EMPTY : array.clone();
            return clone;
        }
        catch (CloneNotSupportedException ex)
        {
            throw new RuntimeException();
        }
    }

    public Iterator<Integer> iterator()
    {
        return new IALIterator();
    }

    public void add(int e)
    {
        if (array.length == size)
        {
            if (array.length == 0)
                array = new int[4];
            else
                grow(size << 1);
        }
        array[size++] = e;
    }

    private void grow(int capacity)
    {
        int[] array = new int[capacity];
        System.arraycopy(this.array, 0, array, 0, size);
        this.array = array;
    }

    public int get(int index)
    {
        return array[index];
    }

    public void set(int index, int e)
    {
        array[index] = e;
    }

    public int last()
    {
        return array[size - 1];
    }

    public int remove()
    {
        return array[--size];
    }

    public void clear()
    {
        size = 0;
    }

    public int[] toArray()
    {
        int[] array = new int[size];
        System.arraycopy(this.array, 0, array, 0, size);
        return array;
    }

    public void sort()
    {
        Arrays.sort(array, 0, size);
    }

    private class IALIterator implements Iterator<Integer>
    {
        private int index;

        public boolean hasNext()
        {
            return index != size;
        }

        public Integer next()
        {
            return array[index++];
        }
    }
}

interface IntegerPredicate
{
    boolean test(int t);
}

class LongBinaryIndexedTree
{
    private final long[] tree;
    private final long defaultValue;
    private final LongBinaryOperator addOperator;
    private final LongBinaryOperator subtractOperator;

    public LongBinaryIndexedTree(long[] elements, long defaultValue, LongBinaryOperator addOperator, LongBinaryOperator subtractOperator)
    {
        long[] prefixSum = new long[elements.length + 1];
        prefixSum[0] = defaultValue;
        for (int i = 0; i < elements.length; i++)
            prefixSum[i + 1] = addOperator.apply(prefixSum[i], elements[i]);
        tree = new long[elements.length + 1];
        for (int i = 1; i <= elements.length; i++)
        {
            int lowestOneBit = Integer.lowestOneBit(i);
            tree[i] = subtractOperator.apply(prefixSum[i], prefixSum[i - lowestOneBit]);
        }
        this.defaultValue = defaultValue;
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
    }

    public long get(int from, int to)
    {
        return subtractOperator.apply(getPrefix(to), getPrefix(from));
    }

    private long getPrefix(int to)
    {
        long result = defaultValue;
        for (; to != 0; to -= Integer.lowestOneBit(to))
            result = addOperator.apply(result, tree[to]);
        return result;
    }

    public void set(int index, long value)
    {
        long oldValue = get(index);
        for (index++; index < tree.length; index += Integer.lowestOneBit(index))
            tree[index] = addOperator.apply(subtractOperator.apply(tree[index], oldValue), value);
    }

    private long get(int index)
    {
        int elementIndex = index + 1;
        long result = tree[elementIndex];
        for (int i = 1; i < Integer.lowestOneBit(elementIndex); index -= i, i <<= 1)
            result = subtractOperator.apply(result, tree[index]);
        return result;
    }
}

interface LongBinaryOperator
{
    long apply(long t, long u);
}

interface LongIntegerIntegerLongTriFunction
{
    long apply(long t, int u, int v);
}

class LongLazySegmentTree
{
    private final long[] tree;
    private final long[] lazy;
    private final long queryDefaultValue;
    private final long updateDefaultValue;
    private final LongBinaryOperator queryOperator;
    private final LongBinaryOperator mergeOperator;
    private final LongIntegerIntegerLongTriFunction batchFunction;

    public LongLazySegmentTree(long[] elements, long queryDefaultValue, long updateDefaultValue, LongBinaryOperator queryOperator, LongBinaryOperator mergeOperator, LongIntegerIntegerLongTriFunction batchFunction)
    {
        int offset = 1 << Algebra.ceilLog2(elements.length);
        tree = new long[offset << 1];
        System.arraycopy(elements, 0, tree, offset, elements.length);
        Arrays.fill(tree, offset + elements.length, tree.length, queryDefaultValue);
        for (int i = offset >> 1; i != 0; i >>= 1)
        {
            for (int k = i; k < i << 1; k++)
                tree[k] = queryOperator.apply(tree[k << 1], tree[k << 1 | 1]);
        }
        lazy = new long[tree.length];
        Arrays.fill(lazy, updateDefaultValue);
        this.queryDefaultValue = queryDefaultValue;
        this.updateDefaultValue = updateDefaultValue;
        this.queryOperator = queryOperator;
        this.mergeOperator = mergeOperator;
        this.batchFunction = batchFunction;
    }

    public long query(int from, int to)
    {
        int segmentIndex = 1;
        int segmentFrom = 0;
        int segmentTo = tree.length >> 1;
        if (from == segmentFrom && to == segmentTo)
            return querySegment(segmentIndex, segmentFrom, segmentTo);
        while (true)
        {
            if (to == segmentTo)
                return queryLeft(segmentIndex, segmentFrom, segmentTo, from);
            else if (from == segmentFrom)
                return queryRight(segmentIndex, segmentFrom, segmentTo, to);
            else
            {
                propagate(segmentIndex, segmentFrom, segmentTo);
                int segmentMiddle = segmentFrom + segmentTo >> 1;
                if (to <= segmentMiddle)
                {
                    segmentIndex <<= 1;
                    segmentTo = segmentMiddle;
                }
                else if (from >= segmentMiddle)
                {
                    segmentIndex = segmentIndex << 1 | 1;
                    segmentFrom = segmentMiddle;
                }
                else
                    return queryOperator.apply(queryLeft(segmentIndex << 1, segmentFrom, segmentMiddle, from), queryRight(segmentIndex << 1 | 1, segmentMiddle, segmentTo, to));
            }
        }
    }

    private long queryLeft(int segmentIndex, int segmentFrom, int segmentTo, int from)
    {
        long result = queryDefaultValue;
        while (true)
        {
            propagate(segmentIndex, segmentFrom, segmentTo);
            int segmentMiddle = segmentFrom + segmentTo >> 1;
            if (from > segmentMiddle)
            {
                segmentIndex = segmentIndex << 1 | 1;
                segmentFrom = segmentMiddle;
            }
            else
            {
                result = queryOperator.apply(querySegment(segmentIndex << 1 | 1, segmentMiddle, segmentTo), result);
                if (from < segmentMiddle)
                {
                    segmentIndex <<= 1;
                    segmentTo = segmentMiddle;
                }
                else
                    return result;
            }
        }
    }

    private long queryRight(int segmentIndex, int segmentFrom, int segmentTo, int to)
    {
        long result = queryDefaultValue;
        while (true)
        {
            propagate(segmentIndex, segmentFrom, segmentTo);
            int segmentMiddle = segmentFrom + segmentTo >> 1;
            if (to < segmentMiddle)
            {
                segmentIndex <<= 1;
                segmentTo = segmentMiddle;
            }
            else
            {
                result = queryOperator.apply(result, querySegment(segmentIndex << 1, segmentFrom, segmentMiddle));
                if (to > segmentMiddle)
                {
                    segmentIndex = segmentIndex << 1 | 1;
                    segmentFrom = segmentMiddle;
                }
                else
                    return result;
            }
        }
    }

    private long querySegment(int segmentIndex, int segmentFrom, int segmentTo)
    {
        return lazy[segmentIndex] == updateDefaultValue ? tree[segmentIndex] : mergeOperator.apply(tree[segmentIndex], batchFunction.apply(lazy[segmentIndex], segmentFrom, segmentTo));
    }

    public void update(int from, int to, long value)
    {
        if (from == 0 && to == tree.length >> 1)
            lazy[1] = mergeOperator.apply(lazy[1], value);
        else
            update(1, 0, tree.length >> 1, from, to, value);
    }

    private void update(int segmentIndex, int segmentFrom, int segmentTo, int from, int to, long value)
    {
        if (to == segmentTo)
            updateLeft(segmentIndex, segmentFrom, segmentTo, from, value);
        else if (from == segmentFrom)
            updateRight(segmentIndex, segmentFrom, segmentTo, to, value);
        else
        {
            propagate(segmentIndex, segmentFrom, segmentTo);
            int segmentMiddle = segmentFrom + segmentTo >> 1;
            if (to <= segmentMiddle)
                update(segmentIndex << 1, segmentFrom, segmentMiddle, from, to, value);
            else if (from >= segmentMiddle)
                update(segmentIndex << 1 | 1, segmentMiddle, segmentTo, from, to, value);
            else
            {
                updateLeft(segmentIndex << 1, segmentFrom, segmentMiddle, from, value);
                updateRight(segmentIndex << 1 | 1, segmentMiddle, segmentTo, to, value);
            }
            tree[segmentIndex] = queryOperator.apply(querySegment(segmentIndex << 1, segmentFrom, segmentMiddle), querySegment(segmentIndex << 1 | 1, segmentMiddle, segmentTo));
        }
    }

    private void updateLeft(int segmentIndex, int segmentFrom, int segmentTo, int from, long value)
    {
        propagate(segmentIndex, segmentFrom, segmentTo);
        int segmentMiddle = segmentFrom + segmentTo >> 1;
        if (from > segmentMiddle)
            updateLeft(segmentIndex << 1 | 1, segmentMiddle, segmentTo, from, value);
        else
        {
            lazy[segmentIndex << 1 | 1] = mergeOperator.apply(lazy[segmentIndex << 1 | 1], value);
            if (from < segmentMiddle)
                updateLeft(segmentIndex << 1, segmentFrom, segmentMiddle, from, value);
        }
        tree[segmentIndex] = queryOperator.apply(querySegment(segmentIndex << 1, segmentFrom, segmentMiddle), querySegment(segmentIndex << 1 | 1, segmentMiddle, segmentTo));
    }

    private void updateRight(int segmentIndex, int segmentFrom, int segmentTo, int to, long value)
    {
        propagate(segmentIndex, segmentFrom, segmentTo);
        int segmentMiddle = segmentFrom + segmentTo >> 1;
        if (to < segmentMiddle)
            updateRight(segmentIndex << 1, segmentFrom, segmentMiddle, to, value);
        else
        {
            lazy[segmentIndex << 1] = mergeOperator.apply(lazy[segmentIndex << 1], value);
            if (to > segmentMiddle)
                updateRight(segmentIndex << 1 | 1, segmentMiddle, segmentTo, to, value);
        }
        tree[segmentIndex] = queryOperator.apply(querySegment(segmentIndex << 1, segmentFrom, segmentMiddle), querySegment(segmentIndex << 1 | 1, segmentMiddle, segmentTo));
    }

    private void propagate(int segmentIndex, int segmentFrom, int segmentTo)
    {
        if (lazy[segmentIndex] != updateDefaultValue)
        {
            tree[segmentIndex] = mergeOperator.apply(tree[segmentIndex], batchFunction.apply(lazy[segmentIndex], segmentFrom, segmentTo));
            lazy[segmentIndex << 1] = mergeOperator.apply(lazy[segmentIndex << 1], lazy[segmentIndex]);
            lazy[segmentIndex << 1 | 1] = mergeOperator.apply(lazy[segmentIndex << 1 | 1], lazy[segmentIndex]);
            lazy[segmentIndex] = updateDefaultValue;
        }
    }
}

interface LongPredicate
{
    boolean test(long t);
}