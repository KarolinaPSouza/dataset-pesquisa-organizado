import java.util.*;
 
public class entry_4945255
{
    public static void main(String[] args)
    {
        Input input = new Input();
        Output output = new Output();
        int n = input.nextInt();
        int x = input.nextInt();
        IntegerArrayList list1 = new IntegerArrayList((1 << (n >> 1)) + 1);
        list1.add(0);
        for (int i = 0; i < n >> 1; i++)
        {
            int t = input.nextInt();
            for (int j = list1.size() - 1; j >= 0; j--)
            {
                int sum = list1.get(j) + t;
                if (sum <= x)
                    list1.add(sum);
            }
        }
        list1.add(Integer.MAX_VALUE);
        int[] array1 = list1.toArray();
        Array.sort(array1);
        IntegerArrayList unique1 = new IntegerArrayList(array1.length);
        IntegerArrayList count1 = new IntegerArrayList(array1.length);
        int prev = 0;
        for (int i = 1; i < array1.length; i++)
        {
            if (array1[i] != array1[prev])
            {
                unique1.add(array1[prev]);
                count1.add(i - prev);
                prev = i;
            }
        }
        IntegerArrayList list2 = new IntegerArrayList((1 << (n + 1) >> 1) + 1);
        list2.add(0);
        for (int i = n >> 1; i < n; i++)
        {
            int t = input.nextInt();
            for (int j = list2.size() - 1; j >= 0; j--)
            {
                int sum = list2.get(j) + t;
                if (sum <= x)
                    list2.add(sum);
            }
        }
        list2.add(Integer.MAX_VALUE);
        int[] array2 = list2.toArray();
        Array.sort(array2);
        IntegerArrayList unique2 = new IntegerArrayList(array2.length);
        IntegerArrayList count2 = new IntegerArrayList(array2.length);
        prev = 0;
        for (int i = 1; i < array2.length; i++)
        {
            if (array2[i] != array2[prev])
            {
                unique2.add(array2[prev]);
                count2.add(i - prev);
                prev = i;
            }
        }
        long count = 0;
        for (int i = 0, j = unique2.size() - 1; i < unique1.size() && j >= 0; )
        {
            int sum = unique1.get(i) + unique2.get(j);
            if (sum == x)
                count += (long)count1.get(i) * count2.get(j);
            if (sum <= x)
                i++;
            if (sum >= x)
                j--;
        }
        output.append(count).appendNewLine();
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
 
class Array
{
    private static final int SORT_BITS = 4;
    private static final int SORT_RADIX = 1 << SORT_BITS;
 
    private Array() {}
 
    public static void sort(int[] array)
    {
        int[][] buckets = new int[SORT_RADIX][array.length];
        int[] size = new int[SORT_RADIX];
        for (int e: array)
        {
            int index = e & SORT_RADIX - 1;
            buckets[index][size[index]++] = e;
        }
        int[][] newBuckets = new int[SORT_RADIX][array.length];
        for (int i = SORT_BITS; i < Integer.SIZE; i += SORT_BITS)
        {
            int[] newSize = new int[SORT_RADIX];
            for (int j = 0; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                {
                    int index = buckets[j][k] >>> i & SORT_RADIX - 1;
                    newBuckets[index][newSize[index]++] = buckets[j][k];
                }
            }
            int[][] temp = buckets;
            buckets = newBuckets;
            newBuckets = temp;
            size = newSize;
        }
        {
            int i = 0;
            for (int j = SORT_RADIX >> 1; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
            for (int j = 0; j < SORT_RADIX >> 1; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
        }
    }
 
    public static void sort(int[] array, int[] keys)
    {
        int[][] buckets = new int[SORT_RADIX][array.length];
        int[][] keyBuckets = new int[SORT_RADIX][array.length];
        int[] size = new int[SORT_RADIX];
        for (int i = 0; i < array.length; i++)
        {
            int index = keys[i] & SORT_RADIX - 1;
            buckets[index][size[index]] = array[i];
            keyBuckets[index][size[index]++] = keys[i];
        }
        int[][] newBuckets = new int[SORT_RADIX][array.length];
        int[][] newKeyBuckets = new int[SORT_RADIX][array.length];
        for (int i = 1; i < Integer.SIZE / SORT_BITS; i++)
        {
            int[] newSize = new int[SORT_RADIX];
            for (int j = 0; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                {
                    int newKey = keyBuckets[j][k] >>> SORT_BITS;
                    int index = newKey & SORT_RADIX - 1;
                    newBuckets[index][newSize[index]] = buckets[j][k];
                    newKeyBuckets[index][newSize[index]++] = newKey;
                }
            }
            int[][] temp1 = buckets;
            buckets = newBuckets;
            newBuckets = temp1;
            int[][] temp2 = keyBuckets;
            keyBuckets = newKeyBuckets;
            newKeyBuckets = temp2;
            size = newSize;
        }
        {
            int i = 0;
            for (int j = SORT_RADIX >> 1; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
            for (int j = 0; j < SORT_RADIX >> 1; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
        }
    }
 
    public static <T> void sort(T[] array, ToIntegerFunction<T> keyExtractor)
    {
        T[][] buckets = (T[][])new Object[SORT_RADIX][array.length];
        int[][] keyBuckets = new int[SORT_RADIX][array.length];
        int[] size = new int[SORT_RADIX];
        for (T e: array)
        {
            int key = keyExtractor.apply(e);
            int index = key & SORT_RADIX - 1;
            buckets[index][size[index]] = e;
            keyBuckets[index][size[index]++] = key;
        }
        T[][] newBuckets = (T[][])new Object[SORT_RADIX][array.length];
        int[][] newKeyBuckets = new int[SORT_RADIX][array.length];
        for (int i = 1; i < Integer.SIZE / SORT_BITS; i++)
        {
            int[] newSize = new int[SORT_RADIX];
            for (int j = 0; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                {
                    int newKey = keyBuckets[j][k] >>> SORT_BITS;
                    int index = newKey & SORT_RADIX - 1;
                    newBuckets[index][newSize[index]] = buckets[j][k];
                    newKeyBuckets[index][newSize[index]++] = newKey;
                }
            }
            T[][] temp1 = buckets;
            buckets = newBuckets;
            newBuckets = temp1;
            int[][] temp2 = keyBuckets;
            keyBuckets = newKeyBuckets;
            newKeyBuckets = temp2;
            size = newSize;
        }
        {
            int i = 0;
            for (int j = SORT_RADIX >> 1; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
            for (int j = 0; j < SORT_RADIX >> 1; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
        }
    }
 
    public static <T> void sort(T[] array, ToIntegerFunction<T>... keyExtractors)
    {
        T[][] buckets = (T[][])new Object[SORT_RADIX][array.length];
        int[][] keyBuckets = new int[SORT_RADIX][array.length];
        int[] size = new int[SORT_RADIX];
        for (T e: array)
        {
            int key = keyExtractors[keyExtractors.length - 1].apply(e);
            int index = key & SORT_RADIX - 1;
            buckets[index][size[index]] = e;
            keyBuckets[index][size[index]++] = key;
        }
        T[][] newBuckets = (T[][])new Object[SORT_RADIX][array.length];
        int[][] newKeyBuckets = new int[SORT_RADIX][array.length];
        for (int i = 1; i < Integer.SIZE / SORT_BITS; i++)
        {
            int[] newSize = new int[SORT_RADIX];
            for (int j = 0; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                {
                    int newKey = keyBuckets[j][k] >>> SORT_BITS;
                    int index = newKey & SORT_RADIX - 1;
                    newBuckets[index][newSize[index]] = buckets[j][k];
                    newKeyBuckets[index][newSize[index]++] = newKey;
                }
            }
            T[][] temp1 = buckets;
            buckets = newBuckets;
            newBuckets = temp1;
            int[][] temp2 = keyBuckets;
            keyBuckets = newKeyBuckets;
            newKeyBuckets = temp2;
            size = newSize;
        }
        for (int i = keyExtractors.length - 2; i >= 0; i--)
        {
            int[] newSize = new int[SORT_RADIX];
            for (int j = SORT_RADIX >> 1; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                {
                    int key = keyExtractors[i].apply(buckets[j][k]);
                    int index = key & SORT_RADIX - 1;
                    newBuckets[index][newSize[index]] = buckets[j][k];
                    newKeyBuckets[index][newSize[index]++] = key;
                }
            }
            for (int j = 0; j < SORT_RADIX >> 1; j++)
            {
                for (int k = 0; k < size[j]; k++)
                {
                    int key = keyExtractors[i].apply(buckets[j][k]);
                    int index = key & SORT_RADIX - 1;
                    newBuckets[index][newSize[index]] = buckets[j][k];
                    newKeyBuckets[index][newSize[index]++] = key;
                }
            }
            T[][] temp1 = buckets;
            buckets = newBuckets;
            newBuckets = temp1;
            int[][] temp2 = keyBuckets;
            keyBuckets = newKeyBuckets;
            newKeyBuckets = temp2;
            size = newSize;
            for (int j = 1; j < Integer.SIZE / SORT_BITS; j++)
            {
                newSize = new int[SORT_RADIX];
                for (int k = 0; k < SORT_RADIX; k++)
                {
                    for (int l = 0; l < size[k]; l++)
                    {
                        int newKey = keyBuckets[k][l] >>> SORT_BITS;
                        int index = newKey & SORT_RADIX - 1;
                        newBuckets[index][newSize[index]] = buckets[k][l];
                        newKeyBuckets[index][newSize[index]++] = newKey;
                    }
                }
                temp1 = buckets;
                buckets = newBuckets;
                newBuckets = temp1;
                temp2 = keyBuckets;
                keyBuckets = newKeyBuckets;
                newKeyBuckets = temp2;
                size = newSize;
            }
        }
        {
            int i = 0;
            for (int j = SORT_RADIX >> 1; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
            for (int j = 0; j < SORT_RADIX >> 1; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
        }
    }
 
    public static <T> void sort(T[] array, ToLongFunction<T> keyExtractor)
    {
        T[][] buckets = (T[][])new Object[SORT_RADIX][array.length];
        long[][] keyBuckets = new long[SORT_RADIX][array.length];
        int[] size = new int[SORT_RADIX];
        for (T e: array)
        {
            long key = keyExtractor.apply(e);
            int index = (int)key & SORT_RADIX - 1;
            buckets[index][size[index]] = e;
            keyBuckets[index][size[index]++] = key;
        }
        T[][] newBuckets = (T[][])new Object[SORT_RADIX][array.length];
        long[][] newKeyBuckets = new long[SORT_RADIX][array.length];
        for (int i = 1; i < Long.SIZE / SORT_BITS; i++)
        {
            int[] newSize = new int[SORT_RADIX];
            for (int j = 0; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                {
                    long newKey = keyBuckets[j][k] >>> SORT_BITS;
                    int index = (int)newKey & SORT_RADIX - 1;
                    newBuckets[index][newSize[index]] = buckets[j][k];
                    newKeyBuckets[index][newSize[index]++] = newKey;
                }
            }
            T[][] temp1 = buckets;
            buckets = newBuckets;
            newBuckets = temp1;
            long[][] temp2 = keyBuckets;
            keyBuckets = newKeyBuckets;
            newKeyBuckets = temp2;
            size = newSize;
        }
        {
            int i = 0;
            for (int j = SORT_RADIX >> 1; j < SORT_RADIX; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
            for (int j = 0; j < SORT_RADIX >> 1; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
        }
    }
 
    public static <T> void shuffle(int[] array)
    {
        for (int i = array.length; i > 1; i--)
            swap(array, Random.nextInt(i), i - 1);
    }
 
    public static <T> void shuffle(T[] array)
    {
        for (int i = array.length; i > 1; i--)
            swap(array, Random.nextInt(i), i - 1);
    }
 
    public static void swap(byte[] array, int i, int j)
    {
        byte temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 
    public static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 
    public static <T> void swap(T[] array, int i, int j)
    {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 
    public static void permute(byte[] array, Procedure procedure)
    {
        permute(array, array.length, procedure);
    }
 
    private static void permute(byte[] array, int length, Procedure procedure)
    {
        if (length == 1)
            procedure.run();
        else
        {
            permute(array, --length, procedure);
            for (int i = 0; i < length; i++)
            {
                int index = (length & 1) == 0 ? 0 : i;
                swap(array, index, length);
                permute(array, length, procedure);
            }
        }
    }
 
    public static void permute(int[] array, Procedure procedure)
    {
        permute(array, array.length, procedure);
    }
 
    private static void permute(int[] array, int length, Procedure procedure)
    {
        if (length == 1)
            procedure.run();
        else
        {
            permute(array, --length, procedure);
            for (int i = 0; i < length; i++)
            {
                int index = (length & 1) == 0 ? 0 : i;
                swap(array, index, length);
                permute(array, length, procedure);
            }
        }
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
 
interface Procedure
{
    void run();
}
 
class Random
{
    private static long seed = System.nanoTime() ^ 8682522807148012L;
 
    private Random() {}
 
    public static void nextBytes(byte[] bytes)
    {
        for (int i = 0, len = bytes.length; i < len; )
        {
            for (int rnd = nextInt(), n = Math.min(len - i, Integer.SIZE / Byte.SIZE); n-- > 0; rnd >>= Byte.SIZE)
                bytes[i++] = (byte)rnd;
        }
    }
 
    public static int nextInt()
    {
        return next(32);
    }
 
    public static int nextInt(int bound)
    {
        int r = next(31);
        int m = bound - 1;
        if ((bound & m) == 0)
            r = (int)(bound * (long)r >> 31);
        else
            for (int u = r; u - (r = u % bound) + m < 0; u = next(31));
        return r;
    }
 
    public static long nextLong()
    {
        return (long)next(32) << 32 | next(32);
    }
 
    public static boolean nextBoolean()
    {
        return next(1) != 0;
    }
 
    public static float nextFloat()
    {
        return next(24) / (float)(1 << 24);
    }
 
    public static double nextDouble()
    {
        return ((long)next(26) << 27 | next(27)) * 0x1.0p-53;
    }
 
    private static int next(int bits)
    {
        seed = seed * 0x5DEECE66DL + 0xBL & 0xFFFFFFFFFFFFL;
        return (int)(seed >>> 48 - bits);
    }
}
 
interface ToIntegerFunction<T>
{
    int apply(T t);
}
 
interface ToLongFunction<T>
{
    long apply(T t);
}