public class entry_4792393 {
    public static void main(String[] args)
    {
        Input input = new Input();
        Output output = new Output();
        int n = input.nextInt();
        int m = input.nextInt();
        IntegerAVLTreeMap map = new IntegerAVLTreeMap();
        for (int i = 0; i < n; i++)
            map.merge(input.nextInt(), 1, Integer::sum);
        for (int i = 0; i < m; i++)
        {
            map.computeForFloor(input.nextInt(), (k, v) ->
            {
                if (v.isPresent())
                {
                    output.append(k).appendNewLine();
                    if (v.get() == 1)
                        v.clear();
                    else
                        v.set(v.get() - 1);
                }
                else
                    output.append(-1).appendNewLine();
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

class IntegerAVLTreeMap
{
    private Entry root;
    private int size;
    private final OptionalInteger optionalValue = new OptionalInteger();

    public int size()
    {
        return size;
    }

    public void forEach(IntegerBiConsumer biConsumer)
    {
        forEach(root, biConsumer);
    }

    private void forEach(Entry entry, IntegerBiConsumer biConsumer)
    {
        if (entry != null)
        {
            forEach(entry.left, biConsumer);
            biConsumer.accept(entry.key, entry.value);
            forEach(entry.right, biConsumer);
        }
    }

    public void put(int k, int v)
    {
        merge(k, v, (v1, v2) -> v2);
    }

    public void merge(int k, int v, IntegerBiFunction remappingFunction)
    {
        if (size == 0)
        {
            root = new Entry(k, v, null);
            size = 1;
        }
        else
        {
            Entry entry = root;
            Entry child;
            while (true)
            {
                if (k < entry.key)
                {
                    if (entry.left == null)
                    {
                        entry.left = new Entry(k, v, entry);
                        child = entry.left;
                        break;
                    }
                    else
                        entry = entry.left;
                }
                else if (k > entry.key)
                {
                    if (entry.right == null)
                    {
                        entry.right = new Entry(k, v, entry);
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

    public int get(int k)
    {
        return getOrDefault(k, 0);
    }

    public int getOrDefault(int k, int defaultValue)
    {
        for (Entry entry = root; entry != null; )
        {
            if (k < entry.key)
                entry = entry.left;
            else if (k > entry.key)
                entry = entry.right;
            else
                return entry.value;
        }
        return defaultValue;
    }

    public void computeForFloor(int k, IntegerXBiConsumer<OptionalInteger> remappingConsumer)
    {
        Entry floor;
        for (Entry entry = root; ; entry = entry.left)
        {
            if (entry == null)
            {
                optionalValue.clear();
                remappingConsumer.accept(0, optionalValue);
                return;
            }
            if (k >= entry.key)
            {
                if (k == entry.key)
                {
                    compute(entry, remappingConsumer);
                    return;
                }
                else
                {
                    floor = entry;
                    break;
                }
            }
        }
        for (Entry entry = floor.right; entry != null; )
        {
            if (k < entry.key)
                entry = entry.left;
            else if (k > entry.key)
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
        compute(floor, remappingConsumer);
    }

    private void compute(Entry entry, IntegerXBiConsumer<OptionalInteger> remappingConsumer)
    {
        optionalValue.set(entry.value);
        remappingConsumer.accept(entry.key, optionalValue);
        if (optionalValue.isPresent())
            entry.value = optionalValue.get();
        else
            remove(entry);
    }

    private void remove(Entry entry)
    {
        size--;
        if (entry.left != null && entry.right != null)
        {
            Entry next = entry.right;
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
        Entry removed = entry;
        Entry child = entry;
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
                        Entry grandchild = child.left;
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
                        Entry grandchild = child.right;
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

    private void rotateLL(Entry entry, Entry child)
    {
        entry.balanceFactor = 0;
        child.balanceFactor = 0;
        replaceAsChild(entry, child);
        setNullableLeftChild(entry, child.right);
        setNonNullRightChild(child, entry);
    }

    private void rotateLO(Entry entry, Entry child)
    {
        entry.balanceFactor = 1;
        child.balanceFactor = -1;
        replaceAsChild(entry, child);
        setNonNullLeftChild(entry, child.right);
        setNonNullRightChild(child, entry);
    }

    private void rotateLR(Entry entry, Entry child, Entry grandchild)
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

    private void rotateRR(Entry entry, Entry child)
    {
        entry.balanceFactor = 0;
        child.balanceFactor = 0;
        replaceAsChild(entry, child);
        setNullableRightChild(entry, child.left);
        setNonNullLeftChild(child, entry);
    }

    private void rotateRO(Entry entry, Entry child)
    {
        entry.balanceFactor = -1;
        child.balanceFactor = 1;
        replaceAsChild(entry, child);
        setNonNullRightChild(entry, child.left);
        setNonNullLeftChild(child, entry);
    }

    private void rotateRL(Entry entry, Entry child, Entry grandchild)
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

    private void setNonNullLeftChild(Entry entry, Entry child)
    {
        entry.left = child;
        child.parent = entry;
    }

    private void setNonNullRightChild(Entry entry, Entry child)
    {
        entry.right = child;
        child.parent = entry;
    }

    private void setNullableLeftChild(Entry entry, Entry child)
    {
        entry.left = child;
        if (child != null)
            child.parent = entry;
    }

    private void setNullableRightChild(Entry entry, Entry child)
    {
        entry.right = child;
        if (child != null)
            child.parent = entry;
    }

    private void replaceAsChild(Entry oldEntry, Entry newEntry)
    {
        Entry parent = oldEntry.parent;
        if (parent == null)
            root = newEntry;
        else if (parent.left == oldEntry)
            parent.left = newEntry;
        else
            parent.right = newEntry;
        newEntry.parent = parent;
    }

    private static class Entry
    {
        private int key;
        private int value;
        private Entry parent;
        private Entry left;
        private Entry right;
        private int balanceFactor;

        private Entry(int key, int value, Entry parent)
        {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }
}

interface IntegerBiConsumer
{
    void accept(int t, int u);
}

interface IntegerBiFunction
{
    int apply(int a, int b);
}

interface IntegerXBiConsumer<U>
{
    void accept(int t, U u);
}

class OptionalInteger
{
    private int value;
    private boolean present;

    public OptionalInteger() {}

    public OptionalInteger(int value)
    {
        set(value);
    }

    public int get()
    {
        return value;
    }

    public boolean isPresent()
    {
        return present;
    }

    public void set(int value)
    {
        this.value = value;
        present = true;
    }

    public void clear()
    {
        present = false;
    }
}