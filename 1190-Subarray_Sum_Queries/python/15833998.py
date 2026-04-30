import sys
 
def main():
    d = sys.stdin.buffer.read().split()
    t = iter(d)
    n = int(next(t))
    m = int(next(t))
    z = 1
    while z < n: z <<= 1
    v = [0] * (z << 1)
    w = [0] * (z << 1)
    x = [0] * (z << 1)
    y = [0] * (z << 1)
    for i in range(n):
        a = int(next(t))
        j = z + i
        v[j] = a
        b = a if a > 0 else 0
        w[j] = x[j] = y[j] = b
    for i in range(z - 1, 0, -1):
        l, r = i << 1, i << 1 | 1
        a, b, c, d, e, f, g, h = v[l], v[r], w[l], w[r], x[l], x[r], y[l], y[r]
        v[i] = a + b
        p = a + d
        w[i] = c if c > p else p
        p = b + e
        x[i] = f if f > p else p
        p = e + d
        q = g if g > h else h
        y[i] = q if q > p else p
        
    o = []
    for _ in range(m):
        i = z + int(next(t)) - 1
        a = int(next(t))
        v[i] = a
        b = a if a > 0 else 0
        w[i] = x[i] = y[i] = b
        i >>= 1
        while i:
            l, r = i << 1, i << 1 | 1
            a, b, c, d, e, f, g, h = v[l], v[r], w[l], w[r], x[l], x[r], y[l], y[r]
            v[i] = a + b
            p = a + d
            w[i] = c if c > p else p
            p = b + e
            x[i] = f if f > p else p
            p = e + d
            q = g if g > h else h
            y[i] = q if q > p else p
            
            i >>= 1
        o.append(str(y[1]))
    sys.stdout.write('\n'.join(o) + '\n')
 
if __name__ == "__main__":
    main()