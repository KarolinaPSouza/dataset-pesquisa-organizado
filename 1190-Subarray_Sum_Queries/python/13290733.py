import sys
import threading
 
def main():
    d = sys.stdin.buffer.read().split()
    it = iter(d)
    n = int(next(it))
    m = int(next(it))
    A = [int(next(it)) for _ in range(n)]
    N = 1
    while N < n:
        N <<= 1
 
    t  = [0] * (2*N)
    p  = [0] * (2*N)
    s  = [0] * (2*N)
    b = [0] * (2*N)
 
    for i, x in enumerate(A):
        idx = N + i
        t[idx]  = x
        p[idx]  = x if x>0 else 0
        s[idx]  = x if x>0 else 0
        b[idx] = x if x>0 else 0
 
    for idx in range(N-1, 0, -1):
        lc = idx<<1
        rc = lc|1
        tt = t[lc] + t[rc]
        pp = max(p[lc], t[lc] + p[rc])
        ss = max(s[rc], t[rc] + s[lc])
        bb = max(b[lc], b[rc], s[lc] + p[rc])
        t[idx], p[idx], s[idx], b[idx] = tt, pp, ss, bb
 
    out = []
    for i in range(m):
        k = int(next(it)) - 1
        x = int(next(it))
        idx = N + k
        t[idx]  = x
        p[idx]  = x if x>0 else 0
        s[idx]  = x if x>0 else 0
        b[idx] = x if x>0 else 0
        idx >>= 1
        while idx:
            lc = idx<<1
            rc = lc|1
            tt = t[lc] + t[rc]
            pp = max(p[lc], t[lc] + p[rc])
            ss = max(s[rc], t[rc] + s[lc])
            bb = max(b[lc], b[rc], s[lc] + p[rc])
            t[idx], p[idx], s[idx], b[idx] = tt, pp, ss, bb
            idx >>= 1
        out.append(str(b[1]))
 
    sys.stdout.write("\n".join(out))
 
if __name__ == "__main__":
    main()