//package entry_12910840;

import java.util.*;

public class entry_12910840 {
    static TreeMap<Integer, Integer> mp = new TreeMap<>();//map instead of set due to duplicates
    public static void main(String[] args) {
        //for every child, try to fit in the child with maximum sum

        Input in = new Input();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] h = new int[n];//price of the n tickets
        int[] t = new int[m];//max purchasing power of each of the m people

        for(int i=0; i<n; i++){
            h[i] = in.nextInt();
            mp.merge(h[i], 1, Integer::sum);
        }

        Output out = new Output();
        int res = 0;
        for(int i=0; i<m; i++){
            t[i] = in.nextInt();
            //find which ticket this person can buy
            Map.Entry candidate = mp.floorEntry(t[i]);
            if(candidate != null){
                res += 1;
                out.append((int)candidate.getKey());
                out.append("\n");
                mp.replace((int)candidate.getKey(), (int)candidate.getValue() - 1);
                if(mp.get(candidate.getKey()) == 0){
                    mp.remove(candidate.getKey());
                }
            }else{
                out.append(-1);
                out.append("\n");
            }
        }

//        out.append(res);
        out.flush();
    }
}
class RadixSort_int {
    private static final int BITS = 16;
    private static final int RADIX = 1 << BITS;
    private static final int MASK = RADIX - 1;

    private RadixSort_int() {
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length);
    }

    public static void sort(int[] a, int from, int to) {
        int[] b = a.clone();
        for (int i = 0; i < Integer.SIZE; i += BITS) {
            int[] count = new int[RADIX];
            for (int j = from; j < to; j++) count[(int) (b[j] >>> i & MASK)]++;
            count[0] += from;
            for (int j = 1; j < RADIX; j++) count[j] += count[j - 1];
            for (int j = to - 1; j >= from; j--) a[--count[(int) (b[j] >>> i & MASK)]] = b[j];
            int[] temp = a;
            a = b;
            b = temp;
        }
        int lower = from;
        for (int upper = to; lower < upper; ) {
            int mid = lower + upper >> 1;
            if (b[mid] < 0) upper = mid;
            else lower = mid + 1;
        }
        System.arraycopy(b, lower, a, from, to - lower);
        System.arraycopy(b, from, a, to - lower, lower - from);
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
            else
                break;
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
    private static final double EPSILON = 1E-6;

    private Algebra() {}

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

    public static int ceilLog2(int n)
    {
        return 32 - Integer.numberOfLeadingZeros(n - 1);
    }

    public static boolean equal(double a, double b)
    {
        return Math.abs(a - b) < EPSILON;
    }

    public static boolean equal0(double a)
    {
        return Math.abs(a) < EPSILON;
    }

    public static double[] solveLinear(double a, double b, double c, double d, double e, double f)
    {
        double D = a * e - b * d;
        double Dx = c * e - b * f;
        double Dy = a * f - c * d;
        if (D == 0)
            return new double[Dx == 0 && Dy == 0 ? 1 : 0];
        else
            return new double[]{Dx / D, Dy / D};
    }

    public static double[] solveQuadratic(double a, double b, double c)
    {
        double delta = b * b - a * c * 4;
        if (Algebra.equal0(delta))
            return new double[]{-b / (a * 2)};
        else if (delta < 0)
            return new double[0];
        else
        {
            double a2 = a * 2;
            double x = -b / a2;
            double y = Math.sqrt(delta) / a2;
            return new double[]{x + y, x - y};
        }
    }

    public static void permute(byte[] array, Procedure procedure)
    {
        int length = array.length;
        int[] index = new int[array.length];
        Arrays.fill(index, -1);
        int pointer = 0;
        while (pointer >= 0)
        {
            if (index[pointer] < 0)
            {
                if (length == 1)
                {
                    procedure.run();
                    pointer--;
                }
                else
                {
                    length--;
                    index[pointer++] = 0;
                }
            }
            else if (index[pointer] == length)
            {
                length++;
                index[pointer--] = -1;
            }
            else
            {
                swap(array, (length & 1) == 0 ? 0 : index[pointer], length);
                index[pointer++]++;
            }
        }
    }

    public static void permute(int[] array, Procedure procedure)
    {
        int length = array.length;
        int[] index = new int[array.length];
        Arrays.fill(index, -1);
        int pointer = 0;
        while (pointer >= 0)
        {
            if (index[pointer] < 0)
            {
                if (length == 1)
                {
                    procedure.run();
                    pointer--;
                }
                else
                {
                    length--;
                    index[pointer++] = 0;
                }
            }
            else if (index[pointer] == length)
            {
                length++;
                index[pointer--] = -1;
            }
            else
            {
                swap(array, (length & 1) == 0 ? 0 : index[pointer], length);
                index[pointer++]++;
            }
        }
    }

    private static void swap(byte[] array, int i, int j)
    {
        byte temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

interface IntegerConsumer
{
    void accept(int t);
}

interface IntegerFunctionalIterable
{
    void forEach(IntegerConsumer consumer);
}

class IntegerHashSet implements IntegerFunctionalIterable
{
    private int[] count;
    private int[] element1;
    private int[] element2;
    private Item[] items;
    private int size;

    public IntegerHashSet()
    {
        this(4);
    }

    public IntegerHashSet(int n)
    {
        n = 1 << Algebra.ceilLog2(n) + 1;
        count = new int[n];
        element1 = new int[n];
        element2 = new int[n];
        items = new Item[n];
    }

    public int size()
    {
        return size;
    }

    public void forEach(IntegerConsumer consumer)
    {
        if (size != 0)
        {
            for (int i = 0; i < count.length; i++)
            {
                if (count[i] >= 1)
                {
                    consumer.accept(element1[i]);
                    if (count[i] >= 2)
                    {
                        consumer.accept(element2[i]);
                        for (Item item = items[i]; item != null; item = item.next)
                            consumer.accept(item.element);
                    }
                }
            }
        }
    }

    public void add(int e)
    {
        ensureCapacity();
        int index = hash(e) & count.length - 1;
        if (count[index] == 0)
        {
            count[index] = 1;
            element1[index] = e;
            size++;
        }
        else if (element1[index] != e)
        {
            if (count[index] == 1)
            {
                count[index] = 2;
                element2[index] = e;
                size++;
            }
            else if (element2[index] != e)
            {
                if (count[index] == 2)
                {
                    count[index] = 3;
                    items[index] = new Item(e);
                    size++;
                }
                else
                {
                    for (Item item = items[index]; ; item = item.next)
                    {
                        if (item.element == e)
                            break;
                        else if (item.next == null)
                        {
                            count[index]++;
                            item.next = new Item(e);
                            size++;
                            break;
                        }
                    }
                }
            }
        }
    }

    private void ensureCapacity()
    {
        if (size == count.length >> 1)
        {
            int capacity = count.length << 1;
            int[] count = new int[capacity];
            int[] element1 = new int[capacity];
            int[] element2 = new int[capacity];
            Item[] items = new Item[capacity];
            for (int i = 0; i < this.count.length; i++)
            {
                if (this.count[i] >= 1)
                {
                    int index1 = hash(element1[i]) & capacity - 1;
                    count[index1] = 1;
                    element1[index1] = this.element1[i];
                    if (this.count[i] >= 2)
                    {
                        int index2 = hash(element2[i]) & capacity - 1;
                        if (index1 == index2)
                        {
                            count[index1] = 2;
                            element2[index1] = this.element2[i];
                        }
                        else
                        {
                            count[index2] = 1;
                            element1[index2] = this.element2[i];
                        }
                        if (this.count[i] >= 3)
                        {
                            for (Item item = this.items[i]; item != null; )
                            {
                                int index = hash(item.element) & capacity - 1;
                                if (count[index] == 1)
                                {
                                    count[index] = 2;
                                    element2[index] = item.element;
                                    item = item.next;
                                }
                                else if (count[index] == 0)
                                {
                                    count[index] = 1;
                                    element1[index] = item.element;
                                    item = item.next;
                                }
                                else
                                {
                                    count[index]++;
                                    Item temp = item.next;
                                    item.next = items[index];
                                    items[index] = item;
                                    item = temp;
                                }
                            }
                        }
                    }
                }
            }
            this.count = count;
            this.element1 = element1;
            this.element2 = element2;
            this.items = items;
        }
    }

    private int hash(int e)
    {
        int hashCode = Integer.hashCode(e);
        return hashCode ^ hashCode >>> 16;
    }

    private static class Item
    {
        private final int element;
        private Item next;

        private Item(int element)
        {
            this.element = element;
        }
    }
}

interface Procedure
{
    void run();
}