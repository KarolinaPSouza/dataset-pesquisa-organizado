# PyPy3 — Concert Tickets (Fenwick Tree + compression)

import sys
from bisect import bisect_right

class Fenwick:
    def __init__(self, n):
        self.n = n
        self.bit = [0]*(n+1)
    def add(self, i, v):
        while i <= self.n:
            self.bit[i] += v
            i += i & -i
    def sum(self, i):
        s = 0
        while i > 0:
            s += self.bit[i]
            i -= i & -i
        return s
    def find_by_prefix(self, target):
        """smallest idx with prefix sum >= target (1-based), assuming target>=1"""
        i = 0
        bitmask = 1 << (self.n.bit_length())  # highest power of two >= n
        while bitmask:
            nxt = i + bitmask
            if nxt <= self.n and self.bit[nxt] < target:
                target -= self.bit[nxt]
                i = nxt
            bitmask >>= 1
        return i + 1

def main():
    data = list(map(int, sys.stdin.buffer.read().split()))
    n, m = data[0], data[1]
    h = data[2:2+n]
    t = data[2+n:2+n+m]

    # coordinate compression of ticket prices
    keys = sorted(set(h))
    idx = {v: i+1 for i, v in enumerate(keys)}  # 1-based for BIT

    bit = Fenwick(len(keys))
    # add counts per price
    from collections import Counter
    cnt = Counter(h)
    for v, c in cnt.items():
        bit.add(idx[v], c)

    out = []
    for x in t:
        # pos = number of keys <= x
        pos = bisect_right(keys, x)
        if pos == 0:
            out.append("-1")
            continue
        total = bit.sum(pos)
        if total == 0:
            out.append("-1")
            continue
        # the total-th ticket within first 'pos' keys is the best (largest <= x)
        kidx = bit.find_by_prefix(total)
        bit.add(kidx, -1)
        out.append(str(keys[kidx-1]))

    sys.stdout.write("\n".join(out))

if __name__ == "__main__":
    main()