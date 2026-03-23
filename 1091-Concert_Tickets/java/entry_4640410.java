public class entry_4640410 {
    public static void main(String[] args)
    {
        Input input = new Input();
        Output output = new Output();
        int n = input.nextInt();
        int m = input.nextInt();
        AVLTreeMap<Integer, Integer> map = new AVLTreeMap<>(Integer::compareTo);
        for (int i = 0; i < n; i++)
            map.merge(input.nextInt(), 1, Integer::sum);
        for (int i = 0; i < m; i++)
        {
            map.computeForFloor(input.nextInt(), (k, v) ->
            {
                if (v == null)
                {
                    output.append(-1).appendNewLine();
                    return null;
                }
                else
                {
                    output.append(k).appendNewLine();
                    return v == 1 ? null : v - 1;
                }
            });
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

class AVLTreeMap<K, V> implements BiFunctionalIterable<K, V>
{
    private Entry<K, V> root;
    private final Comparator<K> comparator;
    private int size;

    public AVLTreeMap(Comparator<K> comparator)
    {
        this.comparator = comparator;
    }

    public int size()
    {
        return size;
    }

    public void forEach(BiConsumer<K, V> biConsumer)
    {
        forEach(root, biConsumer);
    }

    private void forEach(Entry<K, V> entry, BiConsumer<K, V> biConsumer)
    {
        if (entry != null)
        {
            forEach(entry.left, biConsumer);
            biConsumer.accept(entry.key, entry.value);
            forEach(entry.right, biConsumer);
        }
    }

    public void put(K k, V v)
    {
        merge(k, v, (v1, v2) -> v2);
    }

    public void merge(K k, V v, BiFunction<V, V, V> remappingFunction)
    {
        if (size == 0)
        {
            root = new Entry<>(k, v, null);
            size = 1;
        }
        else
        {
            Entry<K, V> entry = root;
            Entry<K, V> child;
            while (true)
            {
                int comparison = comparator.compare(k, entry.key);
                if (comparison < 0)
                {
                    if (entry.left == null)
                    {
                        entry.left = new Entry<>(k, v, entry);
                        child = entry.left;
                        break;
                    }
                    else
                        entry = entry.left;
                }
                else if (comparison > 0)
                {
                    if (entry.right == null)
                    {
                        entry.right = new Entry<>(k, v, entry);
                        child = entry.right;
                        break;
                    }
                    else
                        entry = entry.right;
                }
                else
                {
                    entry.value = remappingFunction.apply(entry.value, v);
                    return;
                }
            }
            for (; entry != null; child = entry, entry = entry.parent)
            {
                if (entry.left == child)
                {
                    if (entry.balanceFactor == 1)
                    {
                        if (child.balanceFactor == 1)
                            rotateLL(entry, child);
                        else
                            rotateLR(entry, child, child.right);
                        break;
                    }
                    else if (++entry.balanceFactor == 0)
                        break;
                }
                else
                {
                    if (entry.balanceFactor == -1)
                    {
                        if (child.balanceFactor == -1)
                            rotateRR(entry, child);
                        else
                            rotateRL(entry, child, child.left);
                        break;
                    }
                    else if (--entry.balanceFactor == 0)
                        break;
                }
            }
            size++;
        }
    }

    public V get(K k)
    {
        return getOrDefault(k, null);
    }

    public V getOrDefault(K k, V defaultValue)
    {
        for (Entry<K, V> entry = root; entry != null; )
        {
            int comparison = comparator.compare(k, entry.key);
            if (comparison < 0)
                entry = entry.left;
            else if (comparison > 0)
                entry = entry.right;
            else
                return entry.value;
        }
        return defaultValue;
    }

    public void computeForFloor(K k, BiFunction<K, V, V> remappingFunction)
    {
        Entry<K, V> floor;
        for (Entry<K, V> entry = root; ; entry = entry.left)
        {
            if (entry == null)
            {
                remappingFunction.apply(null, null);
                return;
            }
            int comparison = comparator.compare(k, entry.key);
            if (comparison >= 0)
            {
                if (comparison == 0)
                {
                    compute(entry, remappingFunction);
                    return;
                }
                else
                {
                    floor = entry;
                    break;
                }
            }
        }
        for (Entry<K, V> entry = floor.right; entry != null; )
        {
            int comparison = comparator.compare(k, entry.key);
            if (comparison < 0)
                entry = entry.left;
            else if (comparison > 0)
            {
                floor = entry;
                entry = entry.right;
            }
            else
            {
                floor = entry;
                break;
            }
        }
        compute(floor, remappingFunction);
    }

    private void compute(Entry<K, V> entry, BiFunction<K, V, V> remappingFunction)
    {
        V v = remappingFunction.apply(entry.key, entry.value);
        if (v == null)
            remove(entry);
        else
            entry.value = v;
    }

    private void remove(Entry<K, V> entry)
    {
        size--;
        if (entry.left != null && entry.right != null)
        {
            Entry<K, V> next = entry.right;
            while (next.left != null)
                next = next.left;
            entry.key = next.key;
            entry.value = next.value;
            entry = next;
        }
        else if (entry == root)
        {
            root = entry.left == null ? entry.right : entry.left;
            return;
        }
        Entry<K, V> removed = entry;
        Entry<K, V> child = entry;
        for (entry = entry.parent; entry != null; child = entry, entry = entry.parent)
        {
            if (entry.left == child)
            {
                if (entry.balanceFactor == -1)
                {
                    child = entry.right;
                    if (child.balanceFactor == -1)
                    {
                        rotateRR(entry, child);
                        entry = child;
                    }
                    else if (child.balanceFactor == 0)
                    {
                        rotateRO(entry, child);
                        break;
                    }
                    else
                    {
                        Entry<K, V> grandchild = child.left;
                        rotateRL(entry, child, grandchild);
                        entry = grandchild;
                    }
                }
                else if (entry.balanceFactor-- == 0)
                    break;
            }
            else
            {
                if (entry.balanceFactor == 1)
                {
                    child = entry.left;
                    if (child.balanceFactor == 1)
                    {
                        rotateLL(entry, child);
                        entry = child;
                    }
                    else if (child.balanceFactor == 0)
                    {
                        rotateLO(entry, child);
                        break;
                    }
                    else
                    {
                        Entry<K, V> grandchild = child.right;
                        rotateLR(entry, child, grandchild);
                        entry = grandchild;
                    }
                }
                else if (entry.balanceFactor++ == 0)
                    break;
            }
        }
        child = removed.left == null ? removed.right : removed.left;
        if (removed.parent.left == removed)
            removed.parent.left = child;
        else
            removed.parent.right = child;
        if (child != null)
            child.parent = removed.parent;
    }

    private void rotateLL(Entry<K, V> entry, Entry<K, V> child)
    {
        entry.balanceFactor = 0;
        child.balanceFactor = 0;
        replaceAsChild(entry, child);
        setNullableLeftChild(entry, child.right);
        setNonNullRightChild(child, entry);
    }

    private void rotateLO(Entry<K, V> entry, Entry<K, V> child)
    {
        entry.balanceFactor = 1;
        child.balanceFactor = -1;
        replaceAsChild(entry, child);
        setNonNullLeftChild(entry, child.right);
        setNonNullRightChild(child, entry);
    }

    private void rotateLR(Entry<K, V> entry, Entry<K, V> child, Entry<K, V> grandchild)
    {
        if (grandchild.balanceFactor == -1)
        {
            entry.balanceFactor = 0;
            child.balanceFactor = 1;
            setNonNullLeftChild(entry, grandchild.right);
            setNullableRightChild(child, grandchild.left);
        }
        else if (grandchild.balanceFactor == 0)
        {
            entry.balanceFactor = 0;
            child.balanceFactor = 0;
            setNullableLeftChild(entry, grandchild.right);
            setNullableRightChild(child, grandchild.left);
        }
        else
        {
            entry.balanceFactor = -1;
            child.balanceFactor = 0;
            setNullableLeftChild(entry, grandchild.right);
            setNonNullRightChild(child, grandchild.left);
        }
        grandchild.balanceFactor = 0;
        replaceAsChild(entry, grandchild);
        setNonNullRightChild(grandchild, entry);
        setNonNullLeftChild(grandchild, child);
    }

    private void rotateRR(Entry<K, V> entry, Entry<K, V> child)
    {
        entry.balanceFactor = 0;
        child.balanceFactor = 0;
        replaceAsChild(entry, child);
        setNullableRightChild(entry, child.left);
        setNonNullLeftChild(child, entry);
    }

    private void rotateRO(Entry<K, V> entry, Entry<K, V> child)
    {
        entry.balanceFactor = -1;
        child.balanceFactor = 1;
        replaceAsChild(entry, child);
        setNonNullRightChild(entry, child.left);
        setNonNullLeftChild(child, entry);
    }

    private void rotateRL(Entry<K, V> entry, Entry<K, V> child, Entry<K, V> grandchild)
    {
        if (grandchild.balanceFactor == -1)
        {
            entry.balanceFactor = 1;
            child.balanceFactor = 0;
            setNullableRightChild(entry, grandchild.left);
            setNonNullLeftChild(child, grandchild.right);
        }
        else if (grandchild.balanceFactor == 0)
        {
            entry.balanceFactor = 0;
            child.balanceFactor = 0;
            setNullableRightChild(entry, grandchild.left);
            setNullableLeftChild(child, grandchild.right);
        }
        else
        {
            entry.balanceFactor = 0;
            child.balanceFactor = -1;
            setNonNullRightChild(entry, grandchild.left);
            setNullableLeftChild(child, grandchild.right);
        }
        grandchild.balanceFactor = 0;
        replaceAsChild(entry, grandchild);
        setNonNullLeftChild(grandchild, entry);
        setNonNullRightChild(grandchild, child);
    }

    private void setNonNullLeftChild(Entry<K, V> entry, Entry<K, V> child)
    {
        entry.left = child;
        child.parent = entry;
    }

    private void setNonNullRightChild(Entry<K, V> entry, Entry<K, V> child)
    {
        entry.right = child;
        child.parent = entry;
    }

    private void setNullableLeftChild(Entry<K, V> entry, Entry<K, V> child)
    {
        entry.left = child;
        if (child != null)
            child.parent = entry;
    }

    private void setNullableRightChild(Entry<K, V> entry, Entry<K, V> child)
    {
        entry.right = child;
        if (child != null)
            child.parent = entry;
    }

    private void replaceAsChild(Entry<K, V> oldEntry, Entry<K, V> newEntry)
    {
        Entry<K, V> parent = oldEntry.parent;
        if (parent == null)
            root = newEntry;
        else if (parent.left == oldEntry)
            parent.left = newEntry;
        else
            parent.right = newEntry;
        newEntry.parent = parent;
    }

    private static class Entry<K, V>
    {
        private K key;
        private V value;
        private Entry<K, V> parent;
        private Entry<K, V> left;
        private Entry<K, V> right;
        private int balanceFactor;

        private Entry(K key, V value, Entry<K, V> parent)
        {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }
}

interface BiConsumer<T, U>
{
    void accept(T t, U u);
}

interface BiFunction<T, U, R>
{
    R apply(T t, U u);
}

interface BiFunctionalIterable<T, U>
{
    void forEach(BiConsumer<T, U> biConsumer);
}

interface Comparator<T>
{
    int compare(T a, T b);
}