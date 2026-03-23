import sys
import bisect
input = sys.stdin.readline

class Fenwick:
    def __init__(self, n):
        self.n = n
        self.bit = [0] * (n + 1)

    def add(self, i, delta):
        # i is 1-based
        n = self.n
        while i <= n:
            self.bit[i] += delta
            i += i & -i

    def sum(self, i):
        # prefix sum up to i (1-based)
        s = 0
        while i > 0:
            s += self.bit[i]
            i -= i & -i
        return s

    def find_kth(self, k):
        # Find smallest index idx such that prefix_sum(idx) >= k
        # assumes 1 <= k <= total_sum
        idx = 0
        bitmask = 1 << (self.n.bit_length())  # power of two >= n
        while bitmask:
            t = idx + bitmask
            if t <= self.n and self.bit[t] < k:
                k -= self.bit[t]
                idx = t
            bitmask >>= 1
        return idx + 1  # 1-based index

# Read input
n, m = map(int, input().split())
tickets = list(map(int, input().split()))
customers = list(map(int, input().split()))

# Coordinate compress unique ticket prices
unique = sorted(set(tickets))
K = len(unique)
pos = {v: i+1 for i, v in enumerate(unique)}  # 1-based indices

# Build Fenwick with counts
bit = Fenwick(K)
from collections import Counter
cnt = Counter(tickets)
for val, c in cnt.items():
    bit.add(pos[val], c)

# Process customers
out_lines = []
for p in customers:
    # index of first element > p in unique => number of unique prices <= p
    r = bisect.bisect_right(unique, p)
    if r == 0:
        out_lines.append("-1")
        continue
    total_le_r = bit.sum(r)
    if total_le_r == 0:
        out_lines.append("-1")
        continue
    # find index of the last available ticket <= p -> it's the total_le_r-th ticket
    idx = bit.find_kth(total_le_r)  # 1-based index into unique
    price = unique[idx - 1]
    out_lines.append(str(price))
    bit.add(idx, -1)

sys.stdout.write("\n".join(out_lines) + "\n")