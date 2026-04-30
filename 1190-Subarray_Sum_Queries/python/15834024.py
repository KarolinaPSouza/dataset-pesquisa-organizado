import sys
 
def main():
    d = sys.stdin.buffer.read().split()
    u = iter(map(int, d))
    g = u.__next__
    
    n, m = g(), g()
    h = 1
    while h < n: h <<= 1
    z = h << 1
    s, p, f, b = [0]*z, [0]*z, [0]*z, [0]*z
    for i in range(n):
        x = g()
        v = x if x > 0 else 0
        k = h + i
        s[k], p[k], f[k], b[k] = x, v, v, v
    for i in range(h - 1, 0, -1):
        l, r = i + i, i + i + 1
        ls, rs, lp, rp, lf, rf, lb, rb = s[l], s[r], p[l], p[r], f[l], f[r], b[l], b[r]
        s[i] = ls + rs
        v = ls + rp
        p[i] = lp if lp > v else v
        v = rs + lf
        f[i] = rf if rf > v else v
        v = lf + rp
        if lb > rb: b[i] = lb if lb > v else v
        else: b[i] = rb if rb > v else v
    q = []
    a = q.append
    for _ in range(m):
        k, x = g() + h - 1, g()
        v = x if x > 0 else 0
        s[k], p[k], f[k], b[k] = x, v, v, v
        
        j = k >> 1
        while j:
            l, r = j + j, j + j + 1
            ls, rs, lp, rp, lf, rf, lb, rb = s[l], s[r], p[l], p[r], f[l], f[r], b[l], b[r]
            s[j] = ls + rs
            v1 = ls + rp
            p[j] = lp if lp > v1 else v1
            v2 = rs + lf
            f[j] = rf if rf > v2 else v2
            v3 = lf + rp
            if lb > rb: b[j] = lb if lb > v3 else v3
            else: b[j] = rb if rb > v3 else v3
            
            j >>= 1
        a(str(b[1]))
    sys.stdout.write('\n'.join(q) + '\n')
 
if __name__ == '__main__':
    main()